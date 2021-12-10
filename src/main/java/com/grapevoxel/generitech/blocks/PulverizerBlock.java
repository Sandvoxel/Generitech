package com.grapevoxel.generitech.blocks;

import com.grapevoxel.generitech.blockentitys.BlockEntities;
import com.grapevoxel.generitech.blockentitys.PulverizerEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class PulverizerBlock extends BlockEntityBase {

    public PulverizerBlock() {
        super(Properties.of(Material.STONE), "pulverizer", PulverizerEntity::new);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return BlockEntities.PULVERIZER.getEntityType() == blockEntityType ? PulverizerEntity::tick : null;
    }
}
