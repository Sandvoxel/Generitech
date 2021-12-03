package com.example.examplemod.blockentitys;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PowerFurnaceEntity extends BlockEntity {

    public PowerFurnaceEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntitys.POWER_FURNACE.getEntityType(), blockPos, blockState);
    }

}
