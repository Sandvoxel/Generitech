package com.grapevoxel.generitech.blockentitys.inventory;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class ItemContainer implements Container {
    private final ItemStack[] items;
    private final int MAX_STACK_SIZE = 64;

    public ItemContainer(int size) {
        this.items = new ItemStack[size];
        Arrays.fill(items, ItemStack.EMPTY);
    }

    @Override
    public int getContainerSize(){
        return items.length;
    }

    @Override
    public boolean isEmpty(){
        return Arrays.stream(items).allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(int index){
        return items[index];
    }

    @Override
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

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int index){
        ItemStack removedItem = items[index];
        items[index] = ItemStack.EMPTY;
        return removedItem;
    }

    @Override
    public void setItem(int index, @NotNull ItemStack itemStack){
        items[index] = itemStack;
    }

    public void clearSlot(int index){
        setItem(index, ItemStack.EMPTY);
    }

    public void addItemStack(int index, ItemStack itemStack){
        addItemStack(index, index+1, itemStack);
    }


    /**
     * Must Call <code>canPlaceStack</code> before this to make sure will su
     * @param startIndex - starting index in the inventory
     * @param endIndex - ending index of the inventory
     * @param itemStack - the stack to place in the provided range of slots
     */
    public boolean addItemStack(int startIndex, int endIndex, ItemStack itemStack){
        if(!canPlaceStack(startIndex,endIndex,itemStack))
            return false;

        Item item =  itemStack.getItem();
        for (int i = startIndex; i < endIndex; i++){
            if(items[i].isEmpty()){
                items[i] = itemStack;
                return true;
            }
            if(items[i].getItem() == item){
                int freeStackSpace = itemStack.getMaxStackSize() - items[i].getCount();
                items[i].setCount((freeStackSpace - itemStack.getCount()) + items[i].getCount());
                itemStack.setCount(itemStack.getMaxStackSize() - (freeStackSpace - itemStack.getCount()));
            }
        }
        return true;
    }

    public ItemStack decrementItem(int index){
        return removeItem(index,1);
    }

    public boolean canPlaceStack(int startIndex, int endIndex, ItemStack itemStack){
        int itemSpace = 0;

        for (int i = startIndex; i < endIndex; i++) {
            if(getItem(i).isEmpty() || getItem(i).sameItem(itemStack)){
                itemSpace += itemStack.getMaxStackSize() - itemStack.getCount();
            }
        }

        return itemSpace <= itemStack.getCount();
    }

    @Override
    public int getMaxStackSize(){
        return MAX_STACK_SIZE;
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(Player p_18946_) {
        return false;
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
