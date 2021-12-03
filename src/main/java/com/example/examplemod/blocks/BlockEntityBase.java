package com.example.examplemod.blocks;

import com.example.examplemod.blockentitys.PulverizerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BlockEntityBase extends BlockBase implements EntityBlock {
    public BlockEntityBase(Properties properties, String registryName) {
        super(properties, registryName);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PulverizerEntity(blockPos, blockState);
    }
}
