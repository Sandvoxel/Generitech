package com.example.examplemod.blockentitys;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class ItemContainerEntity extends BlockEntity implements Container, MenuProvider {
    protected ItemContainer itemContainer = new ItemContainer(3);

    public ItemContainerEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    public int getContainerSize() {
        return itemContainer.getContainerSize();
    }

    @Override
    public boolean isEmpty() {
        return itemContainer.isEmpty();
    }

    @Override
    public ItemStack getItem(int index) {
        return itemContainer.getItem(index);
    }

    @Override
    public ItemStack removeItem(int index, int amount) {
        return itemContainer.removeItem(index, amount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return itemContainer.removeItemNoUpdate(index);
    }

    @Override
    public void setItem(int index, ItemStack itemStack) {
        itemContainer.setItem(index,itemStack);
    }

    @Override
    public int getMaxStackSize() {
        return itemContainer.getMaxStackSize();
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return !(player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) > 64.0D);
        }
    }

    @Override
    public void clearContent() {
        itemContainer.clearContent();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int index, Inventory inventory, Player player) {
        return null;
    }

}
