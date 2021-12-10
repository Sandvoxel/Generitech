package com.example.examplemod.inventory;

import com.example.examplemod.client.PowerFurnaceScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;

public enum Menus {
    POWER_FURNACE_MENU("power_furnace", PowerFurnaceMenu::new, PowerFurnaceScreen::new);

    private final MenuType<?> menuType;
    private final MenuScreens.ScreenConstructor<?, ?> screenConstructor;

    <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> Menus(String id, MenuType.MenuSupplier<? extends M> supplier, MenuScreens.ScreenConstructor<M, U> screenType) {
        this.menuType = new MenuType<>(supplier);
        this.menuType.setRegistryName(id + "menu");
        this.screenConstructor = screenType;
    }

    public static  MenuType<?>[]  getMenuTypes(){
        return Arrays.stream(values()).map(Menus::getMenuType).toArray(MenuType<?>[] ::new);
    }

    public <T extends AbstractContainerMenu> MenuType<T> getMenuType() {
        return (MenuType<T>) menuType;
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerScreens() {
        for (Menus menu:values()) {
            MenuScreens.register(menu.getMenuType(), menu.screenConstructor);
        }
    }

}
