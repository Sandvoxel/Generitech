package com.example.examplemod.inventory;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.Arrays;

public enum Menus {
    POWER_FURNACE_MENU("power_furnace", PowerFurnaceMenu::new);

    private final MenuType<?> menuType;

    <T extends AbstractContainerMenu> Menus(String id, MenuType.MenuSupplier<T> supplier) {
        menuType = new MenuType<>(supplier);
        menuType.setRegistryName(id + "menu");
    }

    public static  MenuType<?>[]  getMenuTypes(){
        return Arrays.stream(values()).toArray(MenuType<?>[] ::new);
    }

    public MenuType<?> getMenuType() {
        return menuType;
    }
}
