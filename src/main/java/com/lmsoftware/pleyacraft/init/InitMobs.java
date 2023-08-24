package com.lmsoftware.pleyacraft.init;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;

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
}
