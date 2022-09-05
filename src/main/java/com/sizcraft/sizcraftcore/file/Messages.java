package com.sizcraft.sizcraftcore.file;

import com.sizcraft.sizcraftcore.SizCraftCore;

public class Messages extends CustomFile {

    private final SizCraftCore sizCraftCore;

    public Messages(SizCraftCore sizCraftCore) {
        super("messages.yml", sizCraftCore);

        this.sizCraftCore = sizCraftCore;
    }

}
