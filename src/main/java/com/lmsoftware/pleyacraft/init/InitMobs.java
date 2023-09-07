package com.lmsoftware.pleyacraft.init;

import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;
import com.lmsoftware.pleyacraft.entities.RigelianEntity;
import com.lmsoftware.pleyacraft.entities.RocketEntity;
import com.lmsoftware.pleyacraft.entities.UpperPleyadianEntity;
import com.lmsoftware.pleyacraft.entities.UpperRigelianEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitMobs {
    public static final DeferredRegister<EntityType<?>> MOBS = 
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Pleyacraft.MODID);

    public static final RegistryObject<EntityType<PleyadianEntity>> PLEYADIAN =
        MOBS.register("pleyadian", () -> EntityType.Builder.of(PleyadianEntity::new, MobCategory.CREATURE)
        .build(Pleyacraft.MODID + ":pleyadian"));

    public static final RegistryObject<EntityType<RigelianEntity>> RIGELIAN = 
        MOBS.register("rigelian", () -> EntityType.Builder.of(RigelianEntity::new, MobCategory.MONSTER)
        .build(Pleyacraft.MODID + ":rigelian"));

    public static final RegistryObject<EntityType<UpperPleyadianEntity>> UPPER_PLEYADIAN =
        MOBS.register("upper_pleyadian", () -> EntityType.Builder.of(UpperPleyadianEntity::new, MobCategory.CREATURE)
        .build(Pleyacraft.MODID + ":upper_pleyadian"));

    public static final RegistryObject<EntityType<UpperRigelianEntity>> UPPER_RIGELIAN =
        MOBS.register("upper_rigelian", () -> EntityType.Builder.of(UpperRigelianEntity::new, MobCategory.MONSTER)
        .build(Pleyacraft.MODID + ":upper_rigelian"));

    public static final RegistryObject<EntityType<RocketEntity>> ROCKET =
        MOBS.register("rocket", () -> EntityType.Builder.of(RocketEntity::new, MobCategory.MISC)
        .build(Pleyacraft.MODID + ":rocket"));
}
