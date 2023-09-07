package com.lmsoftware.pleyacraft.util;

import com.lmsoftware.pleyacraft.Pleyacraft;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ATLAS_PORTAL_FRAME_BLOCKS
                = tag("atlas_portal_frame_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Pleyacraft.MODID, name));
        }
    }
}