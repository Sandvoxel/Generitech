package com.grapevoxel.generitech.blocks;

import com.grapevoxel.generitech.blockentitys.BlockEntities;
import com.grapevoxel.generitech.blockentitys.inventory.ItemContainerEntity;
import com.grapevoxel.generitech.blockentitys.GenericMachineEntity;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class GenericMachineBlock extends BlockEntityBase implements Wearable {

    //TODO: Wearable machines (on head)
    //TODO: Abstract common methods into a new parent Abstract Class BlockInteractableBase

    public GenericMachineBlock() {
        super(Properties.of(Material.METAL), "generic_machine", GenericMachineEntity::new);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {

        return BlockEntities.POWER_FURNACE.getEntityType() == blockEntityType ? GenericMachineEntity::tick : null;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof GenericMachineEntity) {
                player.openMenu((GenericMachineEntity)blockEntity);
            }

            return InteractionResult.CONSUME;
        }
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
