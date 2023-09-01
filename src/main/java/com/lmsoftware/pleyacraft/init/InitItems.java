package com.lmsoftware.pleyacraft.init;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;
import com.lmsoftware.pleyacraft.items.FireStoneItem;
import com.lmsoftware.pleyacraft.items.IceStoneItem;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, Pleyacraft.MODID
    );


    public static final RegistryObject<Item> PLEYARITE_SWORD = ITEMS.register(
        "pleyarite_sword", () -> new SwordItem(
                Tiers.IRON,
                3,
                -2.4f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_SHOVEL = ITEMS.register(
        "pleyarite_shovel", () -> new ShovelItem(
                Tiers.IRON,
                1.5F,
                -3.0F,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_PICKAXE = ITEMS.register(
        "pleyarite_pickaxe", () -> new PickaxeItem(
                Tiers.IRON,
                1,
                -2.8f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_AXE = ITEMS.register(
        "pleyarite_axe", () -> new AxeItem(
                Tiers.IRON,
                6.0f,
                -3.1f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_HOE = ITEMS.register(
        "pleyarite_hoe", () -> new HoeItem(
                Tiers.IRON,
                -2,
                -1.0f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> PLEYARITE_HELMET = ITEMS.register(
        "pleyarite_helmet", () -> new ArmorItem(ArmorMaterials.IRON, EquipmentSlot.HEAD, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));

    public static final RegistryObject<Item> PLEYARITE_CHESTPLATE = ITEMS.register(
        "pleyarite_chestplate", () -> new ArmorItem(ArmorMaterials.IRON, EquipmentSlot.CHEST, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));

    public static final RegistryObject<Item> PLEYARITE_LEGGINGS = ITEMS.register(
        "pleyarite_leggings", () -> new ArmorItem(ArmorMaterials.IRON, EquipmentSlot.LEGS, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));

    public static final RegistryObject<Item> PLEYARITE_BOOTS = ITEMS.register(
        "pleyarite_boots", () -> new ArmorItem(ArmorMaterials.IRON, EquipmentSlot.FEET, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));




    public static final RegistryObject<Item> RIGERITE_SWORD = ITEMS.register(
        "rigerite_sword", () -> new SwordItem(
                Tiers.DIAMOND,
                3,
                -2.4f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> RIGERITE_SHOVEL = ITEMS.register(
        "rigerite_shovel", () -> new ShovelItem(
                Tiers.DIAMOND,
                1.5F,
                -3.0F,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> RIGERITE_PICKAXE = ITEMS.register(
        "rigerite_pickaxe", () -> new PickaxeItem(
                Tiers.DIAMOND,
                1,
                -2.8f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> RIGERITE_AXE = ITEMS.register(
        "rigerite_axe", () -> new AxeItem(
                Tiers.DIAMOND,
                6.0f,
                -3.1f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> RIGERITE_HOE = ITEMS.register(
        "rigerite_hoe", () -> new HoeItem(
                Tiers.DIAMOND,
                -3,
                -0.0f,
                new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> RIGERITE_HELMET = ITEMS.register(
        "rigerite_helmet", () -> new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));

    public static final RegistryObject<Item> RIGERITE_CHESTPLATE = ITEMS.register(
        "rigerite_chestplate", () -> new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.CHEST, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));

    public static final RegistryObject<Item> RIGERITE_LEGGINGS = ITEMS.register(
        "rigerite_leggings", () -> new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.LEGS, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));

    public static final RegistryObject<Item> RIGERITE_BOOTS = ITEMS.register(
        "rigerite_boots", () -> new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.FEET, new Item.Properties().tab(Pleyacraft.TAB).fireResistant()));



    
    

    public static final RegistryObject<Item> PLEYADIAN_SPAWN_EGG = ITEMS.register(
            "pleyadian_spawn_egg", () -> new ForgeSpawnEggItem(
                InitMobs.PLEYADIAN,
            0xb90000,
            0x6b0000,
            (new Item.Properties()).tab(Pleyacraft.TAB))
    );

    public static final RegistryObject<Item> RIGELIAN_SPAWN_EGG = ITEMS.register(
            "rigelian_spawn_egg", () -> new ForgeSpawnEggItem(
                InitMobs.RIGELIAN,
            0x0000b9,
            0x00006b,
            (new Item.Properties()).tab(Pleyacraft.TAB))
    );

    public static final RegistryObject<Item> UPPER_PLEYADIAN_SPAWN_EGG = ITEMS.register(
            "upper_pleyadian_spawn_egg", () -> new ForgeSpawnEggItem(
                InitMobs.UPPER_PLEYADIAN,
            0xb90000,
            0xffffff,
            (new Item.Properties()).tab(Pleyacraft.TAB))
    );

    public static final RegistryObject<Item> UPPER_RIGELIAN_SPAWN_EGG = ITEMS.register(
            "upper_rigelian_spawn_egg", () -> new ForgeSpawnEggItem(
                InitMobs.RIGELIAN,
            0x0000b9,
            0xffffff,
            (new Item.Properties()).tab(Pleyacraft.TAB))
    );

    public static final RegistryObject<Item> PLEYARITE_INGOT = ITEMS.register(
        "pleyarite_ingot", () -> new Item(new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> RIGERITE_INGOT = ITEMS.register(
        "rigerite_ingot", () -> new Item(new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> ELEMENTAL_STAFF = ITEMS.register(
        "elemental_staff", () -> new Item(new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    public static final RegistryObject<Item> ICE_STONE = ITEMS.register(
        "ice_stone", () -> new IceStoneItem(new Item.Properties().tab(Pleyacraft.TAB))
    );

    public static final RegistryObject<Item> FIRE_STONE = ITEMS.register(
        "fire_stone", () -> new FireStoneItem(new Item.Properties().tab(Pleyacraft.TAB).fireResistant())
    );

    // public static final RegistryObject<Item> PLEYADIAN_UFO_RADAR = ITEMS.register(
    //         "pleyadian_ufo_radar", () -> new Item((new Item.Properties()).tab(Pleyacraft.TAB))
    // );

    // public static final RegistryObject<Item> RIGELIAN_UFO_RADAR = ITEMS.register(
    //         "rigelian_ufo_radar", () -> new Item((new Item.Properties()).tab(Pleyacraft.TAB))
    // );
}