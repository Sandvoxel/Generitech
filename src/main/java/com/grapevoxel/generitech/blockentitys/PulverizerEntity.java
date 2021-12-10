package com.grapevoxel.generitech.blockentitys;

import com.grapevoxel.generitech.Generitech;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PulverizerEntity extends BlockEntity {

    public PulverizerEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntities.PULVERIZER.getEntityType(), blockPos, blockState);
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        Generitech.LOGGER.info(blockPos);
    }

}
