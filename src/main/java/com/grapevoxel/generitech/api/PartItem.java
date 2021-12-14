package com.grapevoxel.generitech.api;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

//TODO: Have partItem return a list of it Recipes instead of on a item by item bases.
public interface PartItem {

    ItemStack processResult(ItemStack itemStack, Level level);

    int processTicks(ItemStack itemStack);

    boolean canProcess(ItemStack itemStack, Level level);

    Recipe<?>[] getRecipes(Level level);

}
