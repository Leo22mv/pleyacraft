package com.lmsoftware.pleyacraft.init;

import java.util.List;

import com.lmsoftware.pleyacraft.Pleyacraft;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlaceFeature {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Pleyacraft.MODID);

    public static final RegistryObject<PlacedFeature> PLEYARITE_ORE = PLACED_FEATURE.register(
            "pleyarite_ore",
            () -> new PlacedFeature(InitFeatures.PLEYARITE_ORE.getHolder().get(),
                    commonOrePlacement(60, HeightRangePlacement.triangle(
                            VerticalAnchor.bottom(),
                            VerticalAnchor.absolute(100)
                    )))
    );

    public static final RegistryObject<PlacedFeature> RIGERITE_ORE = PLACED_FEATURE.register(
            "rigerite_ore",
            () -> new PlacedFeature(InitFeatures.RIGERITE_ORE.getHolder().get(),
                    commonOrePlacement(20, HeightRangePlacement.triangle(
                            VerticalAnchor.bottom(),
                            VerticalAnchor.absolute(40)
                    )))
    );

    public static final RegistryObject<PlacedFeature> COPPER_ORE = PLACED_FEATURE.register(
            "copper_ore",
            () -> new PlacedFeature(InitFeatures.COPPER_ORE.getHolder().get(),
                    commonOrePlacement(100, HeightRangePlacement.triangle(
                            VerticalAnchor.bottom(),
                            VerticalAnchor.absolute(100)
                    )))
    );

    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return List.of(CountPlacement.of(countPerChunk), InSquarePlacement.spread(), height, BiomeFilter.biome());
    }
}
