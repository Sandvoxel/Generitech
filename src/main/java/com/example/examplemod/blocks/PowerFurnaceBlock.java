package com.example.examplemod.blocks;

import com.example.examplemod.blockentitys.PowerFurnaceEntity;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;

public class PowerFurnaceBlock extends BlockEntityBase implements Wearable {

    //TODO Wearable machines (on head)

    public PowerFurnaceBlock() {
        super(Properties.of(Material.METAL), "power_furnace", PowerFurnaceEntity::new);
    }

}
