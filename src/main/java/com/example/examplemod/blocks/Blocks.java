package com.example.examplemod.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.Objects;

public enum Blocks {
    TEST_BLOCK(new TestBlock()),
    PULVERIZER(new PulverizerBlock()),
    POWER_FURNACE(new PowerFurnaceBlock());

    private final BlockBase block;
    private final Item blockitem;

    Blocks(BlockBase blockBase) {
        block = blockBase;
        blockitem = new BlockItem(blockBase,
                new Item.Properties()).setRegistryName(
                Objects.requireNonNull(blockBase.getRegistryName()));
    }


    public static Block[] getBlocks() {
        return Arrays.stream(values())
                .map(Blocks::getBlock)
                .toArray(Block[]::new);
    }

    public static Item[] getBlockItems() {
        return Arrays.stream(values())
                .map(Blocks::getBlockItem)
                .toArray(Item[]::new);
    }

    public BlockBase getBlock() {
        return block;
    }

    public Item getBlockItem() {
        return blockitem;
    }
}
