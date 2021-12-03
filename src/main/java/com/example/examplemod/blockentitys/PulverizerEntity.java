package com.example.examplemod.blockentitys;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PulverizerEntity extends BlockEntity {

    public PulverizerEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntitys.PULVERIZER.getEntityType(), blockPos, blockState);
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        ExampleMod.LOGGER.info(blockPos);
    }

}
