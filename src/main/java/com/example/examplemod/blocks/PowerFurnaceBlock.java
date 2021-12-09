package com.example.examplemod.blocks;

import com.example.examplemod.Generitech;
import com.example.examplemod.blockentitys.BlockEntities;
import com.example.examplemod.blockentitys.ItemContainerEntity;
import com.example.examplemod.blockentitys.PowerFurnaceEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
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

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level world, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        BlockEntity entity = world.getBlockEntity(pos);
        if(entity instanceof ItemContainerEntity){
            ((ItemContainerEntity) entity).dropItems(world,pos);
        }

        return super.onDestroyedByPlayer(state,world,pos,player,willHarvest,fluid);
    }
}
