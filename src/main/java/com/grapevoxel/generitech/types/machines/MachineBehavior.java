package com.grapevoxel.generitech.types.machines;

import com.grapevoxel.generitech.api.PartItem;

//TODO: Figure out how I would like to define multi part behavior
public class MachineBehavior {
    private PartItem[] partItems;

    public MachineBehavior(PartItem... partItems) {
        this.partItems = partItems;
        this.init();
    }

    private void init(){

    }



}
