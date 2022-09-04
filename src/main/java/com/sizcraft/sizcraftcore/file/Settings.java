package com.sizcraft.sizcraftcore.file;

import com.sizcraft.sizcraftcore.SizCraftCore;

public class Settings extends CustomFile {

    private final SizCraftCore sizCraftCore;

    public Settings(SizCraftCore sizCraftCore) {
        super("config.yml", sizCraftCore);

        this.sizCraftCore = sizCraftCore;
    }

}
