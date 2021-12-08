package com.example.examplemod.blockentitys;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

public class PowerFurnaceEntity extends ItemContainerEntity{


    public PowerFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntities.POWER_FURNACE.getEntityType(), blockPos, blockState);
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("container.powerfurnace");
    }
}
