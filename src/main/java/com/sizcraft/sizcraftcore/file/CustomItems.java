package com.sizcraft.sizcraftcore.file;

import com.sizcraft.sizcraftcore.SizCraftCore;

public class CustomItems extends CustomFile {

    private final SizCraftCore sizCraftCore;

    public CustomItems(SizCraftCore sizCraftCore) {
        super("customitems.yml", sizCraftCore);

        this.sizCraftCore = sizCraftCore;
    }

}
