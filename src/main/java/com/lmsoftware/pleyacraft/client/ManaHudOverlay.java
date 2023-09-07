package com.lmsoftware.pleyacraft.client;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaHudOverlay {
    private static final ResourceLocation FILLED_MANA = new ResourceLocation(Pleyacraft.MODID,
            "textures/items/ice_stone.png");
    private static final ResourceLocation EMPTY_MANA = new ResourceLocation(Pleyacraft.MODID,
            "textures/items/fire_stone.png");

    public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        if (!Minecraft.getInstance().player.isCreative()) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, EMPTY_MANA);
            for(int i = 0; i < 10; i++) {
                GuiComponent.blit(poseStack,x + 79 - (i * 9), y - 51,0,0,12,12,
                        12,12);
            }

            RenderSystem.setShaderTexture(0, FILLED_MANA);
            for(int i = 0; i < 10; i++) {
                if(ClientManaData.getPlayerMana() > i) {
                    GuiComponent.blit(poseStack,x + 79 - (i * 9),y - 51,0,0,12,12,
                            12,12);
                } else {
                    break;
                }
            }
        }
    });
}
