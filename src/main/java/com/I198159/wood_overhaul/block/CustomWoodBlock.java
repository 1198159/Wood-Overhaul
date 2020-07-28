package com.I198159.wood_overhaul.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

public class CustomWoodBlock{
    public final Block PLANKS = null;
    public final Block SAPLING = null;
    public final Block LOG = null;
    public final Block STRIPPED_LOG = null;
    public final Block WOOD;
    public final Block STRIPPED_WOOD = null;
    public final Block LEAVES = null;
    public final Block SIGN = null;
    public final Block WALL_SIGN = null;
    public final Block PRESSURE_PLATE = null;
    public final Block FENCE = null;
    public final Block FENCE_GATE = null;
    public final Block DOOR = null;
    public final Block TRAPDOOR = null;
    public final Block STAIRS = null;
    public final Block SLAB = null;
    public final Block BUTTON = null;

    public final String ID;

    public CustomWoodBlock(String woodID){
        ID = woodID;
        WOOD = register(woodID+"_wood", new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
    }
    private static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> {
            return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }
    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier("wood_overhaul", id), block);
    }
    public Block getWoodBlock(){
        return WOOD;
    }
}
