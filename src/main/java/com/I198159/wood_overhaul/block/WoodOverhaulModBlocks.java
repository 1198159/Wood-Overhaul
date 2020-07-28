package com.I198159.wood_overhaul.block;

import net.minecraft.block.Block;

public class WoodOverhaulModBlocks {
    public static final CustomWoodBlock BLACKWOOD;
    public static final CustomWoodBlock CEDAR;
    public static final CustomWoodBlock CHERRY;
    public static final CustomWoodBlock CYPRESS;
    public static final CustomWoodBlock FIR;
    public static final CustomWoodBlock PINE;
    public static final CustomWoodBlock POPLAR;
    public static final CustomWoodBlock WALNUT;

    static {
        BLACKWOOD = new CustomWoodBlock("blackwood");
        CEDAR = new CustomWoodBlock("cedar");
        CHERRY = new CustomWoodBlock("cherry");
        CYPRESS = new CustomWoodBlock("cypress");
        FIR = new CustomWoodBlock("fir");
        PINE = new CustomWoodBlock("pine");
        POPLAR = new CustomWoodBlock("poplar");
        WALNUT = new CustomWoodBlock("walnut");
    }
}