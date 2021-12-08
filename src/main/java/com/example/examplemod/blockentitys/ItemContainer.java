package com.example.examplemod.blockentitys;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.system.CallbackI;

import java.util.Arrays;
import java.util.Objects;

public class ItemContainer {
    private ItemStack[] items;
    private final int MAX_STACK_SIZE = 64;

    public ItemContainer(int size) {
        this.items = new ItemStack[size];
        Arrays.fill(items, ItemStack.EMPTY);
    }

    public int getContainerSize(){
        return items.length;
    }

    public boolean isEmpty(){
        return Arrays.stream(items).allMatch(ItemStack::isEmpty);
    }

    public ItemStack getItem(int index){
        return items[index];
    }

    public ItemStack removeItem(int index, int amount){
        int newItemstackCount = items[index].getCount() - amount;
        Item item = items[index].getItem();

        if(newItemstackCount <= 0){
            items[index] = ItemStack.EMPTY;
        }

        items[index].setCount(newItemstackCount);
        return new ItemStack(item,amount);
    }

    public ItemStack removeItemNoUpdate(int index){
        ItemStack removedItem = items[index];
        items[index] = ItemStack.EMPTY;
        return removedItem;
    }

    public void setItem(int index, ItemStack itemStack){
        items[index] = itemStack;
    }

    public int getMaxStackSize(){
        return MAX_STACK_SIZE;
    }

    public void clearContent(){
        Arrays.fill(items, ItemStack.EMPTY);
    }


}
