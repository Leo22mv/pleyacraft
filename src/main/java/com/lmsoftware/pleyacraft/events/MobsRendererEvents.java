package com.lmsoftware.pleyacraft.events;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.models.PleyadianModel;
import com.lmsoftware.pleyacraft.client.renderer.PleyadianRenderer;
import com.lmsoftware.pleyacraft.init.InitMobs;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Pleyacraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MobsRendererEvents {
    @SubscribeEvent
    public static void entityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(InitMobs.PLEYADIAN.get(), PleyadianRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PleyadianModel.LAYER_LOCATION, PleyadianModel::createBodyLayer);
    }
}