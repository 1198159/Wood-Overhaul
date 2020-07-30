package com.I198159.wood_overhaul.item;

import com.I198159.wood_overhaul.block.CustomBlockManager;
import com.I198159.wood_overhaul.block.WoodOverhaulModBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.item.TallBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CustomItemManager {
    public final Item PLANKS;
    public final Item SAPLING;
    public final Item LOG;
    public final Item STRIPPED_LOG;
    public final Item WOOD;
    public final Item STRIPPED_WOOD;
    public final Item LEAVES;
    public final Item SIGN;
    public final Item PRESSURE_PLATE;
    public final Item FENCE;
    public final Item FENCE_GATE;
    public final Item DOOR;
    public final Item TRAPDOOR;
    public final Item STAIRS;
    public final Item SLAB;
    public final Item BUTTON;

    public CustomBlockManager manager;
    public final String ID;

    public CustomItemManager(CustomBlockManager m){
        ID = m.ID;
        manager = m;
        PLANKS = register(m.PLANKS, ItemGroup.BUILDING_BLOCKS, "planks");
        SAPLING = register(m.SAPLING, ItemGroup.DECORATIONS, "sapling");
        LOG = register(m.LOG, ItemGroup.BUILDING_BLOCKS, "log");
        STRIPPED_LOG = register(m.STRIPPED_LOG, ItemGroup.BUILDING_BLOCKS, "stripped", "log");
        STRIPPED_WOOD = register(m.STRIPPED_WOOD, ItemGroup.BUILDING_BLOCKS, "stripped", "wood");
        WOOD = register(m.WOOD, ItemGroup.BUILDING_BLOCKS, "wood");
        LEAVES = register(m.LEAVES, ItemGroup.DECORATIONS, "leaves");
        SLAB = register(m.SLAB, ItemGroup.BUILDING_BLOCKS, "slab");
        STAIRS = register(m.STAIRS, ItemGroup.BUILDING_BLOCKS, "stairs");
        PRESSURE_PLATE = register(m.PRESSURE_PLATE, ItemGroup.REDSTONE, "pressure_plate");
        FENCE = register(m.FENCE, ItemGroup.DECORATIONS, "fence");
        TRAPDOOR = register(m.TRAPDOOR, ItemGroup.REDSTONE, "trapdoor");
        FENCE_GATE = register(m.FENCE_GATE, ItemGroup.REDSTONE, "fence_gate");
        BUTTON = register(m.BUTTON, ItemGroup.REDSTONE, "button");
        DOOR = register((BlockItem)(new TallBlockItem(m.DOOR, (new Item.Settings()).group(ItemGroup.REDSTONE))), "door");
        SIGN = register(new Identifier("wood_overhaul", m.ID+"_sign"), (Item)(new SignItem((new Item.Settings()).maxCount(16).group(ItemGroup.DECORATIONS), m.SIGN, m.WALL_SIGN)));

    }
    private Item register(Block block, ItemGroup group, String b) {
        return register(new BlockItem(block, (new Item.Settings()).group(group)), "", b);
    }
    private Item register(Block block, ItemGroup group, String a, String b) {
        return register(new BlockItem(block, (new Item.Settings()).group(group)), a, b);
    }
    private Item register(BlockItem item, String a){
        return register(item, "", a);
    }
    private Item register(BlockItem item, String a, String b) {

        return register(new Identifier("wood_overhaul", (a.equals("") ? a : a+"_")+ manager.ID+"_"+b), item);
    }

    private Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item)Registry.register(Registry.ITEM, (Identifier)id, item);
    }
}
