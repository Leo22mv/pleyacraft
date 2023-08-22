package com.lmsoftware.pleyacraft.init;

import com.lmsoftware.pleyacraft.Pleyacraft;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, Pleyacraft.MODID
    );

    public static final RegistryObject<Item> PLEYARITE_INGOT = ITEMS.register(
        "pleyarite_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_SWORD = ITEMS.register(
        "pleyarite_sword", () -> new SwordItem(
            Tiers.NETHERITE,
            5,
            -2.4f,
            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_SHOVEL = ITEMS.register(
        "pleyarite_shovel", () -> new ShovelItem(
            Tiers.NETHERITE,
            1.5F,
            -3.0F,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_PICKAXE = ITEMS.register(
        "pleyarite_pickaxe", () -> new PickaxeItem(
            Tiers.NETHERITE,
            2,
            -2.8f,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_AXE = ITEMS.register(
        "pleyarite_axe", () -> new AxeItem(
            Tiers.NETHERITE,
            5.0f,
            -3.0f,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_HOE = ITEMS.register(
        "pleyarite_hoe", () -> new HoeItem(
            Tiers.NETHERITE,
            -4,
            0.0f,
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant())
    );
}