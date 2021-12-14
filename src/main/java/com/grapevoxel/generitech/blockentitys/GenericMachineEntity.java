package com.grapevoxel.generitech.blockentitys;

import com.grapevoxel.generitech.Generitech;
import com.grapevoxel.generitech.api.PartItem;
import com.grapevoxel.generitech.blockentitys.inventory.ItemContainerEntity;
import com.grapevoxel.generitech.inventory.PowerFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

//TODO: Precompute map of Recipes upon machine being constructed
public class GenericMachineEntity extends ItemContainerEntity {

    private int processTime;
    private static final int[] PART_SLOTS = {2,3};


    public GenericMachineEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntities.POWER_FURNACE.getEntityType(), blockPos, blockState, 6);
    }

    public void serverTick(Level level, BlockPos blockPos, BlockState blockState){

        if(itemContainer.getItem(1).isEmpty() && canProcess(itemContainer.getItem(0))){
            itemContainer.addItemStack(1, new ItemStack(itemContainer.getItem(0).getItem(),1));
            itemContainer.decrementItem(0);
            this.processTime = processTicks(itemContainer.getItem(1));
        }

        if(!itemContainer.getItem(1).isEmpty() && processTime <= 0){
            ItemStack processedItem = processResult(itemContainer.getItem(1));
            canProcess(itemContainer.getItem(1));
            itemContainer.addItemStack(4,2, processedItem);
            itemContainer.clearSlot(1);
        }

        if(processTime > 0 && itemContainer.canPlaceStack(4,2, processResult(itemContainer.getItem(1))))
            processTime--;

        //FIXME: Debug progress bar
        if(processTime != 0 && processTime % 20 == 0)
            Generitech.LOGGER.info("Processing: " + processTime);

    }

    private int processTicks(ItemStack itemStack){
        itemStack = itemStack.copy();
        PartItem[] partItems = getItemParts();
        if(partItems.length == 0)
            return 0;
        int processTicks = 0;

        for (PartItem partItem : partItems) {
            if(partItem.canProcess(itemStack, level)){
                processTicks = partItem.processTicks(itemStack);
            }
        }
        return processTicks;
    }
    private ItemStack processResult(ItemStack itemStack){
        itemStack = itemStack.copy();
        PartItem[] partItems = getItemParts();
        if(partItems.length == 0)
            return ItemStack.EMPTY;

        for (PartItem partItem : partItems) {
            if(partItem.canProcess(itemStack, level)){
                itemStack = partItem.processResult(itemStack,level);
            }else {
                return ItemStack.EMPTY;
            }
        }
        return itemStack;
    }

    private boolean canProcess(ItemStack itemStack){
        itemStack = itemStack.copy();
        PartItem[] partItems = getItemParts();
        if(partItems.length == 0)
            return false;

        for (PartItem partItem : partItems) {
            if(partItem.canProcess(itemStack, level)){
                itemStack = partItem.processResult(itemStack,level);
            }else {
                return false;
            }
        }
        return true;
    }

    public PartItem[] getItemParts(){
        List<PartItem> partItems = new ArrayList<>();

        for (int i : PART_SLOTS) {
            if(itemContainer.getItem(i).getItem() instanceof PartItem part){
                partItems.add(part);
            }
        }

        return partItems.toArray(PartItem[]::new);
    }


    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("container.powerfurnace");
    }


    @Override
    public int[] getSlotsForFace(Direction direction) {
        if(direction == Direction.DOWN){
            return new int[] {5};
        }
        if(direction == Direction.UP){
            return new int[] {2};
        }
        return new int[] {0};
    }

    @Override
    public boolean canPlaceItemThroughFace(int p_19235_, ItemStack itemStack, @Nullable Direction direction) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int p_19239_, ItemStack p_19240_, Direction p_19241_) {
        return true;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new PowerFurnaceMenu(containerId, inventory, this);
    }

    public int getProcessTime() {
        return processTime;
    }
}
