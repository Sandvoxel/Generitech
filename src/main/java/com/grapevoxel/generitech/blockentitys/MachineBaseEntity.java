package com.grapevoxel.generitech.blockentitys;

import com.grapevoxel.generitech.api.PartItem;
import com.grapevoxel.generitech.blockentitys.inventory.ItemContainerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public abstract class MachineBaseEntity extends ItemContainerEntity {

	private static final int[] PART_SLOTS = {2,3};


	public MachineBaseEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState blockState, int containerSize) {
		super(blockEntityType, pos, blockState, containerSize);
	}


	public PartItem[] getItemParts(){
		List<PartItem> partItems = new ArrayList<>();

		for (int i : PART_SLOTS) {
			if(itemContainer.getItem(i).getItem() instanceof PartItem part){
				partItems.add(part);
			}
		}
		return partItems.toArray(PartItem[]::new);
	}
}
