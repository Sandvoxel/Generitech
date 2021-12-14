package com.grapevoxel.generitech.types;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.lwjgl.system.CallbackI;

public class ComparableItemStack {
	private Item item;
	private int stackSize;

	public ComparableItemStack(ItemStack itemStack) {
		this.item = itemStack.getItem();
		if(!itemStack.isEmpty())
			this.stackSize = itemStack.getCount();
	}

	public ComparableItemStack(Item item, int stackSize) {
		this.item = item;
		this.stackSize = stackSize;
	}

	public ItemStack getItemstack(){
		return item == Items.AIR ? ItemStack.EMPTY : new ItemStack(item,stackSize);
	}

	public boolean isItemEqual(ComparableItemStack comparableItemStack){
		return comparableItemStack.item == item;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof ComparableItemStack && isItemEqual((ComparableItemStack) o);
	}

	@Override
	public int hashCode() {
		return item.hashCode();
	}
}
