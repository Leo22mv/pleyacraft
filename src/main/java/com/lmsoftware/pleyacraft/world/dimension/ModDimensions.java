package com.lmsoftware.pleyacraft.world.dimension;

import com.lmsoftware.pleyacraft.Pleyacraft;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> ATLASDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Pleyacraft.MODID, "atlasdim"));
    public static final ResourceKey<DimensionType> ATLASDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, ATLASDIM_KEY.registry());


    public static final ResourceKey<Level> RIGELDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Pleyacraft.MODID, "rigeldim"));
    public static final ResourceKey<DimensionType> RIGELDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, RIGELDIM_KEY.registry());

    public static void register() {
        System.out.println("Registering ModDimensions for " + Pleyacraft.MODID);
    }
}
