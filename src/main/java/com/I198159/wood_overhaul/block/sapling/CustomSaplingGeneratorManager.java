package com.I198159.wood_overhaul.block.sapling;

import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class CustomSaplingGeneratorManager {
    private SaplingGenerator generator;
    public CustomSaplingGeneratorManager(String id){
        switch(id){
            case "blackwood":
                generator = new BlackwoodSaplingGenerator();
            case "cedar":
                generator = new CedarSaplingGenerator();
            case "cherry":
                generator = new CherrySaplingGenerator();
            case "cypress":
                generator = new CypressSaplingGenerator();
            case "ebony":
                generator = new EbonySaplingGenerator();
            case "fir":
                generator = new FirSaplingGenerator();
            case "ironwood":
                generator = new IronwoodSaplingGenerator();
            case "maple":
                generator = new MapleSaplingGenerator();
            case "pine":
                generator = new PineSaplingGenerator();
            case "poplar":
                generator = new PoplarSaplingGenerator();
            case "walnut":
                generator = new WalnutSaplingGenerator();
            default:
                generator = new OakSaplingGenerator();
        }
    }
    public SaplingGenerator getGenerator(){
        return generator;
    }
}
