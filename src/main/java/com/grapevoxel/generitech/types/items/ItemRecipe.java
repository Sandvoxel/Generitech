package com.grapevoxel.generitech.types.items;

import net.minecraft.world.item.ItemStack;

public class ItemRecipe {
	private ItemStack inputStack;
	private ItemStack outputStack;

	public ItemRecipe(ItemStack inputStack, ItemStack outputStack) {
		this.inputStack = inputStack;
		this.outputStack = outputStack;
	}


	public ItemStack getInputStack() {
		return inputStack;
	}

	public ItemStack getOutputStack() {
		return outputStack;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ItemRecipe that)) return false;

		return getInputStack() != null ? !getInputStack().equals(that.getInputStack()) : that.getInputStack() != null;
	}

	@Override
	public int hashCode() {
		return getInputStack() != null ? getInputStack().hashCode() : 0;
	}
}
