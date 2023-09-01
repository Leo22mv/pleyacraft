package com.lmsoftware.pleyacraft.init;

import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.Pleyacraft;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class InitBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, Pleyacraft.MODID);

    public static final RegistryObject<Block> PLEYARITE_ORE_BLOCK = register(
        "pleyarite_ore_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2.5f).requiresCorrectToolForDrops()),
        new Item.Properties().tab(Pleyacraft.TAB));

    public static final RegistryObject<Block> PLEYARITE_BLOCK = register(
        "pleyarite_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3.0f).requiresCorrectToolForDrops()),
        new Item.Properties().tab(Pleyacraft.TAB).fireResistant());

    public static final RegistryObject<Block> RIGERITE_ORE_BLOCK = register(
        "rigerite_ore_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2.5f).requiresCorrectToolForDrops()),
        new Item.Properties().tab(Pleyacraft.TAB));

    public static final RegistryObject<Block> RIGERITE_BLOCK = register(
        "rigerite_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3.0f).requiresCorrectToolForDrops()),
        new Item.Properties().tab(Pleyacraft.TAB).fireResistant());

    private static <T extends Block> RegistryObject<T> register(
            String name,
            Supplier<T> supplier,
            Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        InitItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }

    // private static RegistryObject<Block> register(String name, Supplier<T> supplier, Properties tab) {
    //     return null;
    // }
    
}


