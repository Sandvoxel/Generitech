package com.example.examplemod.registry;

import com.example.examplemod.blockentitys.BlockEntities;
import com.example.examplemod.blocks.Blocks;
import com.example.examplemod.inventory.Menus;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        blockRegistryEvent.getRegistry().registerAll(Blocks.getBlocks());
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> blockRegistryEvent) {
        blockRegistryEvent.getRegistry().registerAll(Blocks.getBlockItems());
    }


    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<BlockEntityType<?>> evt) {
        evt.getRegistry().registerAll(BlockEntities.getBlockEntitys());
    }

    @SubscribeEvent
    public static void registerMenus(RegistryEvent.Register<MenuType<?>> event){
        //TODO register menus
    }
}
