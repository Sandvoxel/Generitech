package com.grapevoxel.generitech.items.parts;

import com.grapevoxel.generitech.api.PartItem;
import com.grapevoxel.generitech.items.ItemBase;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class FurnacePartItem extends ItemBase  implements PartItem {

    public FurnacePartItem() {
        super(new Item.Properties(), "furnacepartitem");
    }

    @Override
    public ItemStack processResult(ItemStack itemStack, Level level) {
        if(!canProcess(itemStack, level))
            return ItemStack.EMPTY;

        SimpleContainer container = new SimpleContainer(1);
        container.setItem(0, itemStack);

        Recipe<?> recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, container, level).orElse(null);
        if(recipe == null)
            return ItemStack.EMPTY;

        return recipe.getResultItem().copy();
    }

    @Override
    public int processTicks(ItemStack itemStack) {
        return 200;
    }

    @Override
    public boolean canProcess(ItemStack itemStack, Level level) {
        if(itemStack == ItemStack.EMPTY)
            return false;

        SimpleContainer container = new SimpleContainer(2);
        container.setItem(0, itemStack);

        Recipe<?> recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, container, level).orElse(null);

        return recipe != null;
    }

    @Override
    public Recipe<?>[] getRecipes(Level level) {
        return level.getRecipeManager().getAllRecipesFor(RecipeType.SMELTING).toArray(Recipe[]::new);
    }
}
