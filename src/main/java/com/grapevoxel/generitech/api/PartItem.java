package com.grapevoxel.generitech.api;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface PartItem {

    ItemStack processResult(ItemStack itemStack, Level level);

    int processTicks(ItemStack itemStack);

    boolean canProcess(ItemStack itemStack, Level level);

}
