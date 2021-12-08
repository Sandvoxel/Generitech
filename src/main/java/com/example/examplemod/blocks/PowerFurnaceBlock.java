package com.example.examplemod.blocks;

import com.example.examplemod.Generitech;
import com.example.examplemod.blockentitys.BlockEntities;
import com.example.examplemod.blockentitys.PowerFurnaceEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class PowerFurnaceBlock extends BlockEntityBase implements Wearable {

    //TODO Wearable machines (on head)

    public PowerFurnaceBlock() {
        super(Properties.of(Material.METAL), "power_furnace", PowerFurnaceEntity::new);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return BlockEntities.POWER_FURNACE.getEntityType() == blockEntityType ? PowerFurnaceEntity::tick : null;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

}
