package com.example.examplemod.items.parts;

import com.example.examplemod.items.ItemBase;
import net.minecraft.world.item.ItemStack;

public abstract class PartItem extends ItemBase {
    public PartItem(Properties properties, String registryName) {
        super(properties, registryName);
    }

    public abstract ItemStack processResult(ItemStack itemStack);

    public abstract int processTicks(ItemStack itemStack);

    public abstract boolean canProcess(ItemStack itemStack);

}
