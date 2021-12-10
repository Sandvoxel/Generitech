package com.example.examplemod.blockentitys;

import com.example.examplemod.api.PartItem;
import com.example.examplemod.inventory.PowerFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PowerFurnaceEntity extends ItemContainerEntity {

    private int processTime;

    public PowerFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntities.POWER_FURNACE.getEntityType(), blockPos, blockState, 6);
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        BlockEntity entity = level.getBlockEntity(blockPos);
        if(!(entity instanceof PowerFurnaceEntity powerFurnace))
            return;
        powerFurnace.localTick(level, blockPos, blockState);
    }

    public void localTick(Level level, BlockPos blockPos, BlockState blockState){
        if(!(itemContainer.getItem(2).getItem() instanceof PartItem part))
            return;

        if(itemContainer.getItem(1).isEmpty() && part.canProcess(itemContainer.getItem(0))){
            itemContainer.addItemStack(1, new ItemStack(itemContainer.getItem(0).getItem(),1));
            itemContainer.decrementItem(0);
            this.processTime = part.processTicks(itemContainer.getItem(1));
        }

        if(!itemContainer.getItem(1).isEmpty() && processTime <= 0){
            ItemStack processedItem = part.processResult(itemContainer.getItem(1));
            itemContainer.addItemStack(5, processedItem);
            itemContainer.clearSlot(1);
        }


        if(processTime > 0)
            processTime--;



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
