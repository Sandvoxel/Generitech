package com.example.examplemod.blockentitys;

import com.example.examplemod.Generitech;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class ItemContainerEntity extends BlockEntity implements Container, MenuProvider, WorldlyContainer {
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

    public void dropItems(Level world, BlockPos pos){
        final Random RANDOM = new Random();

        double d0 = EntityType.ITEM.getWidth();
        double d1 = 1.0D - d0;
        double d2 = d0 / 2.0D;
        double d3 = Math.floor(pos.getX()) + RANDOM.nextDouble() * d1 + d2;
        double d4 = Math.floor(pos.getY()) + RANDOM.nextDouble() * d1;
        double d5 = Math.floor(pos.getZ()) + RANDOM.nextDouble() * d1 + d2;

        for(ItemStack itemStack : itemContainer.getItems()){
            while(!itemStack.isEmpty()) {
                ItemEntity itementity = new ItemEntity(world, d3, d4, d5, itemStack.split(RANDOM.nextInt(21) + 10));
                float f = 0.05F;
                itementity.setDeltaMovement(RANDOM.nextGaussian() * (double)0.05F, RANDOM.nextGaussian() * (double)0.05F + (double)0.2F, RANDOM.nextGaussian() * (double)0.05F);
                world.addFreshEntity(itementity);
            }
        }

    }

    @Override
    public void load(CompoundTag compoundTag) {
        itemContainer.loadAllItems(compoundTag);
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        itemContainer.saveAllItems(compoundTag);
    }

}

















