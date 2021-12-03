package com.example.examplemod.blocks;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.StringUtils;

public class BlockBase extends Block {
    public BlockBase(Properties properties, String registryName) {
        super(properties);
        if (StringUtils.isAllLowerCase(registryName))
            ExampleMod.LOGGER.fatal("Block " + registryName + " Needs to be all lowercase");

        this.setRegistryName(registryName);
    }
}
