package com.grapevoxel.generitech.inventory;

import com.grapevoxel.generitech.blockentitys.GenericMachineEntity;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

public class PowerFurnaceMenu extends AbstractContainerMenu {

    private GenericMachineEntity genericMachineEntity = null;

    //TODO: clean up
    public PowerFurnaceMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, new SimpleContainer(6));
    }

    public PowerFurnaceMenu(int containerId, Inventory inventory, Container container) {
        super(Menus.POWER_FURNACE_MENU.getMenuType(), containerId);

        //add power furnace slots
        for (int i = 0; i < container.getContainerSize(); i++) {
            this.addSlot(new Slot(container, i, 16 + i * 32, 16));
        }

        //add inventory slots
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        //add hotbar slots
        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        if (!(container instanceof GenericMachineEntity genericMachineEntity))
            return;
        this.genericMachineEntity = genericMachineEntity;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    public GenericMachineEntity getPowerFurnaceEntity() {
        return genericMachineEntity;
    }
}
