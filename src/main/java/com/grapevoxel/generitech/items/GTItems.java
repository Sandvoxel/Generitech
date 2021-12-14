package com.grapevoxel.generitech.items;

import com.grapevoxel.generitech.items.dust.IronDust;
import com.grapevoxel.generitech.items.parts.FurnacePartItem;
import net.minecraft.world.item.Item;

import java.util.Arrays;

public enum GTItems {
    TEST(new TestItem()),
    IRON_DUST(new IronDust()),
    FURNACE_PART(new FurnacePartItem()),
    WRENCH(new Wrench());

    private final ItemBase itemBase;

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
