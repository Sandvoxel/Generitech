package com.example.examplemod.items.dust;

import com.example.examplemod.items.ItemBase;
import net.minecraft.world.item.CreativeModeTab;

public class IronDust extends ItemBase {
    public IronDust() {
        super(new Properties().tab(CreativeModeTab.TAB_MATERIALS), "irondust");
    }
}
