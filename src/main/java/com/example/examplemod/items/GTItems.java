package com.example.examplemod.items;

import com.example.examplemod.items.dust.IronDust;
import com.example.examplemod.items.parts.CrusherPartItem;
import net.minecraft.world.item.Item;

import java.util.Arrays;

public enum GTItems {
    TEST(new TestItem()),
    IRON_DUST(new IronDust()),
    FURNACE_PART(new CrusherPartItem());

    ItemBase itemBase;

    GTItems(ItemBase itemBase) {
        this.itemBase = itemBase;
    }


    public static Item[] getItems(){
        return Arrays.stream(values()).map(GTItems::getItem).toArray(Item[]::new);
    }

    public Item getItem() {
        return itemBase;
    }
}
