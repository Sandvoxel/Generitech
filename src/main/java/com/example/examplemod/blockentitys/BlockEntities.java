package com.example.examplemod.blockentitys;

import com.example.examplemod.blocks.GTBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Arrays;
import java.util.Objects;

public enum BlockEntities {
    PULVERIZER(PulverizerEntity::new, GTBlocks.PULVERIZER.getBlock()),
    POWER_FURNACE(PowerFurnaceEntity::new, GTBlocks.POWER_FURNACE.getBlock());


    private final BlockEntityType<?> entityType;


    BlockEntities(BlockEntityType.BlockEntitySupplier<? extends BlockEntity> entityType, Block... blocks) {
        this.entityType = BlockEntityType.Builder.of(entityType, blocks).build(null);
        this.entityType.setRegistryName(Objects.requireNonNull(blocks[0].getRegistryName()) + "entity");
    }


    public static BlockEntityType<?>[] getBlockEntitys() {
        return Arrays.stream(values()).map(BlockEntities::getEntityType).toArray(BlockEntityType[]::new);
    }

    public BlockEntityType<?> getEntityType() {
        return entityType;
    }

}


