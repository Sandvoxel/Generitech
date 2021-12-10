package com.grapevoxel.generitech.registry;

import com.grapevoxel.generitech.blockentitys.BlockEntities;
import com.grapevoxel.generitech.blocks.GTBlocks;
import com.grapevoxel.generitech.inventory.Menus;
import com.grapevoxel.generitech.items.GTItems;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registry {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        blockRegistryEvent.getRegistry().registerAll(GTBlocks.getBlocks());
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
        itemRegistryEvent.getRegistry().registerAll(GTBlocks.getBlockItems());
        itemRegistryEvent.getRegistry().registerAll(GTItems.getItems());
    }


    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<BlockEntityType<?>> evt) {
        evt.getRegistry().registerAll(BlockEntities.getBlockEntitys());
    }

    @SubscribeEvent
    public static void registerMenus(RegistryEvent.Register<MenuType<?>> event){
        event.getRegistry().registerAll(Menus.getMenuTypes());
    }

    //public static void registerScreens(RegistryEvent.Register)
}
