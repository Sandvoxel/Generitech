package com.example.examplemod.blockentitys;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;

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
            return new ItemStack(item,amount);
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

    public void clearSlot(int index){
        setItem(index, ItemStack.EMPTY);
    }

    public void addItemStack(int index, ItemStack itemStack){
        addItemStack(index, index+1, itemStack);
    }

    public void addItemStack(int start, int end, ItemStack itemStack){
        Item item =  itemStack.getItem();
        for (int i = start; i < end; i++){
            if(items[i].isEmpty()){
                items[i] = itemStack;
                return;
            }
            if(items[i].getItem() == item){
                int freeStackSpace = items[i].getCount() - MAX_STACK_SIZE;
                itemStack.setCount(itemStack.getCount() + freeStackSpace);
                items[i].setCount(MAX_STACK_SIZE);
            }

        }
    }

    public ItemStack decrementItem(int index){
        return removeItem(index,1);
    }

    public int getMaxStackSize(){
        return MAX_STACK_SIZE;
    }

    public void clearContent(){
        Arrays.fill(items, ItemStack.EMPTY);
    }

    public void loadAllItems(CompoundTag compoundTag) {
        ListTag listtag = compoundTag.getList("Items", 10);

        for(int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j < items.length) {
                setItem(j, ItemStack.of(compoundtag));
            }
        }

    }
    public CompoundTag saveAllItems(CompoundTag compoundTag) {
        ListTag listtag = new ListTag();

        for(int i = 0; i < items.length; ++i) {
            ItemStack itemstack = items[i];
            if (!itemstack.isEmpty()) {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putByte("Slot", (byte)i);
                itemstack.save(compoundtag);
                listtag.add(compoundtag);
            }
        }
        compoundTag.put("Items", listtag);


        return compoundTag;
    }



    public ItemStack[] getItems() {
        return Arrays.stream(items).filter(x -> !x.isEmpty()).toArray(ItemStack[]::new);
    }
}
