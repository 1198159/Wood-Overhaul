package com.I198159.wood_overhaul.block;

public class WoodOverhaulModBlocks {
    public static final CustomBlockManager BLACKWOOD;
    public static final CustomBlockManager CEDAR;
    public static final CustomBlockManager CHERRY;
    public static final CustomBlockManager CYPRESS;
    public static final CustomBlockManager EBONY;
    public static final CustomBlockManager FIR;
    public static final CustomBlockManager IRONWOOD;
    public static final CustomBlockManager MAPLE;
    public static final CustomBlockManager PINE;
    public static final CustomBlockManager POPLAR;
    public static final CustomBlockManager WALNUT;

    static {
        BLACKWOOD = new CustomBlockManager("blackwood");
        CEDAR = new CustomBlockManager("cedar");
        CHERRY = new CustomBlockManager("cherry");
        CYPRESS = new CustomBlockManager("cypress");
        EBONY = new CustomBlockManager("ebony");
        FIR = new CustomBlockManager("fir");
        IRONWOOD = new CustomBlockManager("ironwood");
        MAPLE = new CustomBlockManager("maple");
        PINE = new CustomBlockManager("pine");
        POPLAR = new CustomBlockManager("poplar");
        WALNUT = new CustomBlockManager("walnut");
    }
}
