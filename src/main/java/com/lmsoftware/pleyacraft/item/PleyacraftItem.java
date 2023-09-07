package com.lmsoftware.pleyacraft.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class PleyacraftItem  extends Item{
    String description;

    public PleyacraftItem(Properties p_41383_, String description) {
        super(p_41383_);
        this.description = description;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_,
            TooltipFlag p_41424_) {
        
        if(Screen.hasShiftDown()) {
            p_41423_.add(Component.literal(description).withStyle(ChatFormatting.AQUA));
        } else {
            p_41423_.add(Component.literal("Apretá SHIFT para mostrar información").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }
}
