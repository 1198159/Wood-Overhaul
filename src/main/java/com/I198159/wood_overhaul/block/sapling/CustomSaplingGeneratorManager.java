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
            default:
                generator = new OakSaplingGenerator();
        }
    }
    public SaplingGenerator getGenerator(){
        return generator;
    }
}
