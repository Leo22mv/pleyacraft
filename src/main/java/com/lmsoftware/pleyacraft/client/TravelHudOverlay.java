package com.lmsoftware.pleyacraft.client;

import java.util.List;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.travel.PlayerTravelProvider;
import com.lmsoftware.pleyacraft.util.KeyBinding;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.network.chat.contents.TranslatableFormatException;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class TravelHudOverlay {
    public static final IGuiOverlay HUD_TRAVEL = ((gui, poseStack, partialTick, width, height) -> {
        int x = width;
        int y = height / 2;

        if (ClientTravelData.isOnRocket()) {
            Font fontRenderer = Minecraft.getInstance().font;

            int destination = ClientDestinationData.getDestination();
            String text2 = "Destino:";
            switch (destination) {
                case 1:
                    text2 = "Destino: Tierra";
                    break;
                case 2:
                    text2 = "Destino: Atlas";
                    break;
                case 3:
                    text2 = "Destino: Rigel";
                    break;
            
                default:
                    // text2 = "Destino: ella";
                    break;
            }
            int textWidth2 = fontRenderer.width(text2); // Obtiene el ancho del texto
            int textX2 = x - textWidth2;
            int textY2 = y - 30;
            fontRenderer.draw(poseStack, text2, textX2, textY2, 0xFFFFFFFF); // Renderiza el texto

            String key = KeyBinding.DRINKING_KEY.getKey().getName();
            String patron = "^key\\.keyboard\\."; // Esto busca el prefijo "key.keyboard."
            String patron2 = "^key\\.mouse\\.";
            String text3 = key.replaceAll(patron, "").replaceAll(patron2, "").toUpperCase() + " : Cambiar destino";
            int textWidth3 = fontRenderer.width(text3); // Obtiene el ancho del texto
            int textX3 = x - textWidth3;
            int textY3 = y - 20;
            fontRenderer.draw(poseStack, text3, textX3, textY3, 0xFFFFFF); // Renderiza el texto

            String key2 = KeyBinding.TRAVEL_KEY.getKey().getName();
            String text = key2.replaceAll(patron, "").replaceAll(patron2, "").toUpperCase() + " : Viajar";
            int textWidth = fontRenderer.width(text); // Obtiene el ancho del texto
            int textX = x - textWidth;
            int textY = y;
            fontRenderer.draw(poseStack, text, textX, textY, 0xFFFFFFFF); // Renderiza el texto
        }
    });
}
