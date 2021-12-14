package com.grapevoxel.generitech.items.parts;

import com.grapevoxel.generitech.api.PartItem;
import com.grapevoxel.generitech.items.GTItems;
import com.grapevoxel.generitech.items.ItemBase;
import com.grapevoxel.generitech.types.ComparableItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;

public class CrusherPartItem extends ItemBase implements PartItem {

	private static Map<ComparableItemStack, ItemStack> processMap = new HashMap<>();

	//TODO: change to use RecipeManager for crush-ables.

	public CrusherPartItem() {
		super(new Item.Properties(), "crusherpart");
		processMap.put(new ComparableItemStack(new ItemStack(Items.IRON_ORE, 1)),
				new ItemStack(GTItems.IRON_DUST.getItem(), 2));
	}

	@Override
	public ItemStack processResult(ItemStack itemStack, Level level) {
		return processMap.get(new ComparableItemStack(itemStack));
	}

	@Override
	public int processTicks(ItemStack itemStack) {
		return 20;
	}

	@Override
	public boolean canProcess(ItemStack itemStack, Level level) {
		return processMap.get(new ComparableItemStack(itemStack)) != null;
	}
}
