package com.I198159.wood_overhaul.block;

import com.I198159.util.CustomSignType;
import com.I198159.wood_overhaul.block.sapling.CustomSaplingGeneratorManager;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SignBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class CustomBlockManager {
    public final Block PLANKS;
    public final Block SAPLING;
    public final Block POTTED_SAPLING;
    public final Block LOG;
    public final Block STRIPPED_LOG;
    public final Block WOOD;
    public final Block STRIPPED_WOOD;
    public final Block LEAVES;
    public final Block SIGN;
    public final Block WALL_SIGN;
    public final Block PRESSURE_PLATE;
    public final Block FENCE;
    public final Block FENCE_GATE;
    public final Block DOOR;
    public final Block TRAPDOOR;
    public final Block STAIRS;
    public final Block SLAB;
    public final Block BUTTON;

    public final String ID;

    public CustomBlockManager(String woodID){
        ID = woodID;
        SignType signType = new CustomSignType(woodID);

        PLANKS = register(woodID+"_planks", new Block(AbstractBlock.Settings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        STAIRS = register(woodID+"_stairs", new CustomStairsBlock(PLANKS.getDefaultState(), AbstractBlock.Settings.copy(PLANKS)));
        SLAB = register(woodID+"_slab", new SlabBlock(AbstractBlock.Settings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));

        PRESSURE_PLATE = register(woodID+"_pressure_plate", new CustomPressurePlateBlock(net.minecraft.block.PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD, PLANKS.getDefaultMaterialColor()).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD)));
        BUTTON = register(woodID+"_button", new CustomWoodButtonBlock(AbstractBlock.Settings.of(Material.SUPPORTED).noCollision().strength(0.5F).sounds(BlockSoundGroup.WOOD)));

        DOOR = register(woodID+"_door", new CustomDoorBlock(AbstractBlock.Settings.of(Material.WOOD, PLANKS.getDefaultMaterialColor()).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
        TRAPDOOR = register(woodID+"_trapdoor", new CustomTrapdoorBlock(AbstractBlock.Settings.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(CustomBlockManager::never)));

        SIGN = register(woodID+"_sign", new SignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD), signType));
        WALL_SIGN = register(woodID+"_wall_sign", new WallSignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(SIGN), signType));

        FENCE = register(woodID+"_fence", new FenceBlock(AbstractBlock.Settings.of(Material.WOOD, PLANKS.getDefaultMaterialColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
        FENCE_GATE = register(woodID+"_fence_gate", new FenceGateBlock(AbstractBlock.Settings.of(Material.WOOD, PLANKS.getDefaultMaterialColor()).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));

        LOG = register(woodID+"_log", createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD));
        WOOD = register(woodID+"_wood", new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        STRIPPED_LOG = register("stripped_"+woodID+"_log", createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD));
        STRIPPED_WOOD = register("stripped_"+woodID+"_wood", new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));

        LEAVES = register(woodID+"_leaves", createLeavesBlock());
        SAPLING = register(woodID+"_sapling", new CustomSaplingBlock(new CustomSaplingGeneratorManager(woodID).getGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)));
        POTTED_SAPLING = register("potted_"+woodID+"_sapling", new FlowerPotBlock(SAPLING, AbstractBlock.Settings.of(Material.SUPPORTED).breakInstantly().nonOpaque()));

    }

    private static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
            return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> {
            return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }

    private static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(CustomBlockManager::canSpawnOnLeaves).suffocates(CustomBlockManager::never).blockVision(CustomBlockManager::never));
    }

    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }
    private static boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier("wood_overhaul", id), block);
    }
}
