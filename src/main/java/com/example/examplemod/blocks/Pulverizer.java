package com.example.examplemod.blocks;

import com.example.examplemod.blockentitys.BlockEntitys;
import com.example.examplemod.blockentitys.PulverizerEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class Pulverizer extends BlockEntityBase {
    public Pulverizer() {
        super(Properties.of(Material.STONE), "pulverizer");
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return BlockEntitys.PULVERIZER.getEntityType() == blockEntityType ? PulverizerEntity::tick : null;
    }
}
