package com.example.examplemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockEntityBase extends BlockBase implements EntityBlock {

    private final BlockEntityType.BlockEntitySupplier<? extends BlockEntity> entityType;

    public BlockEntityBase(Properties properties, String registryName, BlockEntityType.BlockEntitySupplier<? extends BlockEntity> entityType) {
        super(properties, registryName);
        this.entityType = entityType;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return entityType.create(blockPos, blockState);
    }
}
