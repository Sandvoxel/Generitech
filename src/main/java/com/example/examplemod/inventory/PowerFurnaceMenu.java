package com.example.examplemod.inventory;

import com.example.examplemod.blocks.Blocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PowerFurnaceMenu extends ItemCombinerMenu {

    //TODO: implement Menu on Block

    public PowerFurnaceMenu(int p_39774_, Inventory p_39775_) {
        super(Menus.POWER_FURNACE_MENU.getMenuType(), p_39774_, p_39775_, ContainerLevelAccess.NULL);
    }

    @Override
    protected boolean mayPickup(Player player, boolean p_39799_) {
        return false;
    }

    @Override
    protected void onTake(Player player, ItemStack itemStack) {

    }

    @Override
    protected boolean isValidBlock(BlockState blockState) {
        return true;
    }

    @Override
    public void createResult() {

    }
}
