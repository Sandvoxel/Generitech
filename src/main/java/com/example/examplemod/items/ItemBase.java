package com.example.examplemod.items;

import com.example.examplemod.Generitech;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.StringUtils;

public abstract class ItemBase extends Item {
    public ItemBase(Properties properties, String registryName) {
        super(properties);
        if (StringUtils.isAllLowerCase(registryName))
            Generitech.LOGGER.fatal("Item " + registryName + " needs to be all lowercase");

        this.setRegistryName(registryName);
    }
}
