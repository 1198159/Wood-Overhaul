package com.I198159.wood_overhaul;

		import com.I198159.wood_overhaul.item.WoodOverhaulModItems;

		import net.fabricmc.api.ModInitializer;

public class WoodOverhaulMod implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		WoodOverhaulModItems.registerItems();
		System.out.println("Hello Fabric world!");
	}
}
