package com.grapevoxel.generitech.blocks;

import com.grapevoxel.generitech.Generitech;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.StringUtils;

public class BlockBase extends Block {
    public BlockBase(Properties properties, String registryName) {
        super(properties);
        if (StringUtils.isAllLowerCase(registryName))
            Generitech.LOGGER.fatal("Block " + registryName + " Needs to be all lowercase");

        this.setRegistryName(registryName);
    }
}
