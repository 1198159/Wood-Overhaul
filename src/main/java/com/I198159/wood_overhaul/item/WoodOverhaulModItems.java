package com.I198159.wood_overhaul.item;

import com.I198159.wood_overhaul.block.CustomWoodBlock;
import com.I198159.wood_overhaul.block.WoodOverhaulModBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WoodOverhaulModItems {

    public static final Item.Settings WOOD_ITEM_SETTINGS = new Item.Settings().maxCount(64)
            .group(ItemGroup.BUILDING_BLOCKS);

    public static final Item BLACKWOOD_WOOD = registerWoodItem(WoodOverhaulModBlocks.BLACKWOOD);
    public static final Item CEDAR_WOOD = registerWoodItem(WoodOverhaulModBlocks.CEDAR);
    public static final Item CHERRY_WOOD = registerWoodItem(WoodOverhaulModBlocks.CHERRY);
    public static final Item CYPRESS_WOOD = registerWoodItem(WoodOverhaulModBlocks.CYPRESS);
    public static final Item EBONY_WOOD = registerWoodItem(WoodOverhaulModBlocks.EBONY);
    public static final Item FIR_WOOD = registerWoodItem(WoodOverhaulModBlocks.FIR);
    public static final Item IRONWOOD_WOOD = registerWoodItem(WoodOverhaulModBlocks.IRONWOOD);
    public static final Item MAPLE_WOOD = registerWoodItem(WoodOverhaulModBlocks.MAPLE);
    public static final Item PINE_WOOD = registerWoodItem(WoodOverhaulModBlocks.PINE);
    public static final Item POPLAR_WOOD = registerWoodItem(WoodOverhaulModBlocks.POPLAR);
    public static final Item WALNUT_WOOD = registerWoodItem(WoodOverhaulModBlocks.WALNUT);

    public static Item registerWoodItem(CustomWoodBlock woodBlock){
        return register(new Identifier("wood_overhaul", woodBlock.ID +"_wood"),
                new BlockItem(woodBlock.getWoodBlock(), WOOD_ITEM_SETTINGS));
    }

    public static void registerItems() {
    }

    private static Item register(BlockItem item) {
        return register(item.getBlock(), item);
    }

    protected static Item register(Block block, Item item) {
        return register(Registry.BLOCK.getId(block), item);
    }
    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registry.ITEM, id, item);
    }
}
