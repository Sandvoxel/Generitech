package com.grapevoxel.generitech.blockentitys;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TickableBlockEntity extends BlockEntity {
	public TickableBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState blockState) {
		super(blockEntityType, pos, blockState);
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
		BlockEntity entity = level.getBlockEntity(blockPos);
		if(!(entity instanceof TickableBlockEntity tickableBlockEntity))
			return;
		tickableBlockEntity.localTick(level, blockPos, blockState);
	}

	public abstract void localTick(Level level, BlockPos blockPos, BlockState blockState);

	}
