package com.I198159.wood_overhaul;

import com.I198159.wood_overhaul.block.CustomBlockManager;
import com.I198159.wood_overhaul.block.WoodOverhaulModBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.SaplingBlock;
import net.minecraft.client.render.RenderLayer;

public class WoodOverhaulClientMod implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerWoodAsTransparent(WoodOverhaulModBlocks.BLACKWOOD);
	}

	private void registerWoodAsTransparent(CustomBlockManager c){
		registerBlockAsTransparent(c.SAPLING);
		registerBlockAsTransparent(c.DOOR);
		registerBlockAsTransparent(c.TRAPDOOR);
		registerBlockAsTransparent(c.POTTED_SAPLING);
	}

	private void registerBlockAsTransparent(Block b){
		BlockRenderLayerMap.INSTANCE.putBlock(b, RenderLayer.getCutout());
	}
}
