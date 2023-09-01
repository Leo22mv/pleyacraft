package com.lmsoftware.pleyacraft.init;

import com.google.common.base.Suppliers;
import com.lmsoftware.pleyacraft.Pleyacraft;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class InitFeatures {

	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
			DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Pleyacraft.MODID);

	private static final Supplier<List<OreConfiguration.TargetBlockState>> PLEYARITE_OVERWORLD_REPLACE =
			Suppliers.memoize(() -> List.of(
					OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitBlocks.PLEYARITE_ORE_BLOCK.get().defaultBlockState()),
					OreConfiguration.target(new BlockMatchTest(Blocks.IRON_ORE), InitBlocks.PLEYARITE_ORE_BLOCK.get().defaultBlockState()),
					OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitBlocks.PLEYARITE_ORE_BLOCK.get().defaultBlockState())
			));

	private static final Supplier<List<OreConfiguration.TargetBlockState>> RIGERITE_OVERWORLD_REPLACE =
			Suppliers.memoize(() -> List.of(
				OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitBlocks.RIGERITE_ORE_BLOCK.get().defaultBlockState()),
				OreConfiguration.target(new BlockMatchTest(Blocks.IRON_ORE), InitBlocks.RIGERITE_ORE_BLOCK.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitBlocks.RIGERITE_ORE_BLOCK.get().defaultBlockState())
			));
	

	public static final RegistryObject<ConfiguredFeature<?, ?>> PLEYARITE_ORE = CONFIGURED_FEATURES.register(
			"pleyarite_ore",
			() -> new ConfiguredFeature<>(
				Feature.ORE,
				new OreConfiguration(PLEYARITE_OVERWORLD_REPLACE.get(), 8)
			)
	);

	public static final RegistryObject<ConfiguredFeature<?, ?>> RIGERITE_ORE = CONFIGURED_FEATURES.register(
			"rigerite_ore",
			() -> new ConfiguredFeature<>(
					Feature.ORE,
					new OreConfiguration(RIGERITE_OVERWORLD_REPLACE.get(), 4)
			)
	);
}
