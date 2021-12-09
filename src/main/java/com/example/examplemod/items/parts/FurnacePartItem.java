package com.example.examplemod.items.parts;

import com.example.examplemod.items.GTItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.lwjgl.system.CallbackI;

import java.util.HashMap;
import java.util.Map;

public class FurnacePartItem extends PartItem{
    //FIXME: temp data for input output should be some kind of registry
    private final Map<ItemStack, ItemStack> outputMap = new HashMap<>();


    public FurnacePartItem() {
        super(new Item.Properties(), "furnacepartitem");
        outputMap.put(new ItemStack(Items.IRON_ORE, 1),
                new ItemStack(GTItems.IRON_DUST.getItem(),2));
    }

    @Override
    public ItemStack processResult(ItemStack itemStack) {
        if(!canProcess(itemStack))
            return ItemStack.EMPTY;

        for (Map.Entry<ItemStack, ItemStack> entry : outputMap.entrySet()) {
            if (entry.getKey().sameItem(itemStack))
                return entry.getValue().copy();
        }
        return ItemStack.EMPTY;
    }

    @Override
    public int processTicks(ItemStack itemStack) {
        return 80;
    }

    @Override
    public boolean canProcess(ItemStack itemStack) {
        for (Map.Entry<ItemStack, ItemStack> entry : outputMap.entrySet()) {
            if (entry.getKey().sameItem(itemStack))
                return true;
        }
        return false;
    }
}
