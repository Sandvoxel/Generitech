package com.example.examplemod.api;

import net.minecraft.world.item.ItemStack;

public interface PartItem {

    ItemStack processResult(ItemStack itemStack);

    int processTicks(ItemStack itemStack);

    boolean canProcess(ItemStack itemStack);

}
