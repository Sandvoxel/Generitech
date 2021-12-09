package com.example.examplemod.blockentitys;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PowerFurnaceEntity extends ItemContainerEntity{

    private int processTime;

    public PowerFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntities.POWER_FURNACE.getEntityType(), blockPos, blockState);
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        BlockEntity entity = level.getBlockEntity(blockPos);
        if(!(entity instanceof PowerFurnaceEntity powerFurnace))
            return;
        powerFurnace.localTick(level, blockPos, blockState);
    }

    public void localTick(Level level, BlockPos blockPos, BlockState blockState){
        if(itemContainer.getItem(0).isEmpty() && itemContainer.getItem(1).isEmpty())
            return;

        if (itemContainer.getItem(1).isEmpty() && itemContainer.getItem(0).getItem() == Items.CHEST){
            itemContainer.addItemStack(1, itemContainer.decrementItem(0));
            processTime = 80;
        }else if(!itemContainer.getItem(1).isEmpty() && itemContainer.getItem(1).getItem() == Items.CHEST){
            if(processTime <= 0){
                itemContainer.clearSlot(1);
                itemContainer.addItemStack(2, new ItemStack(Items.HOPPER,1));
            }else {
                processTime--;
            }
        }


    }



    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("container.powerfurnace");
    }


    @Override
    public int[] getSlotsForFace(Direction direction) {
        if(direction == Direction.DOWN){
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
    public AbstractContainerMenu createMenu(int index, Inventory inventory, Player player) {
        return null;
    }
}
