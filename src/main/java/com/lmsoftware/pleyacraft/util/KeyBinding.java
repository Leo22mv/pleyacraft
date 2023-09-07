package com.lmsoftware.pleyacraft.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBinding {
    public static final String KEY_CATEGORY_PLEYACRAFT = "key.category.pleyacraft.pleyacraft";
    public static final String KEY_SPELL_MODE = "key.pleyacraft.spell_mode";
    public static final String KEY_TRAVEL = "key.pleyacraft.travel";

    public static final KeyMapping DRINKING_KEY = new KeyMapping(KEY_SPELL_MODE, KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_PLEYACRAFT);

    public static final KeyMapping TRAVEL_KEY = new KeyMapping(KEY_TRAVEL, KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_I, KEY_CATEGORY_PLEYACRAFT);
}
