package com.grapevoxel.generitech.items.parts;

import com.grapevoxel.generitech.api.PartItem;
import com.grapevoxel.generitech.items.GTItems;
import com.grapevoxel.generitech.items.ItemBase;
import com.grapevoxel.generitech.types.items.ItemRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrusherPartItem extends ItemBase  implements PartItem {
    //FIXME: temp data for input output should be some kind of registry
    private Set<ItemRecipe> recipes = new HashSet<>();


    public CrusherPartItem() {
        super(new Item.Properties(), "crusherpartitem");

        recipes.add(new ItemRecipe(new ItemStack(Items.IRON_ORE, 1),
                new ItemStack(GTItems.IRON_DUST.getItem(),2)));
    }

    @Override
    public ItemStack processResult(ItemStack itemStack) {
        if(!canProcess(itemStack))
            return ItemStack.EMPTY;


        return recipes.stream().filter(x -> x.getInputStack().sameItem(itemStack)).map(ItemRecipe::getOutputStack).findFirst().orElse(ItemStack.EMPTY).copy();
    }

    @Override
    public int processTicks(ItemStack itemStack) {
        return 80;
    }

    @Override
    public boolean canProcess(ItemStack itemStack) {
        return recipes.stream().map(ItemRecipe::getInputStack).anyMatch(x -> x.sameItem(itemStack));
    }
}
