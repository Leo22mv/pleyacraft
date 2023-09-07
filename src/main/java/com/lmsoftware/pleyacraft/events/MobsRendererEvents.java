package com.lmsoftware.pleyacraft.events;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.models.PleyadianModel;
import com.lmsoftware.pleyacraft.client.models.RigelianModel;
import com.lmsoftware.pleyacraft.client.models.RocketModel;
import com.lmsoftware.pleyacraft.client.models.UpperPleyadianModel;
import com.lmsoftware.pleyacraft.client.models.UpperRigelianModel;
import com.lmsoftware.pleyacraft.client.renderer.PleyadianRenderer;
import com.lmsoftware.pleyacraft.client.renderer.RigelianRenderer;
import com.lmsoftware.pleyacraft.client.renderer.RocketRenderer;
import com.lmsoftware.pleyacraft.client.renderer.UpperPleyadianRenderer;
import com.lmsoftware.pleyacraft.client.renderer.UpperRigelianRenderer;
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
        event.registerEntityRenderer(InitMobs.RIGELIAN.get(), RigelianRenderer::new);
        event.registerEntityRenderer(InitMobs.UPPER_PLEYADIAN.get(), UpperPleyadianRenderer::new);
        event.registerEntityRenderer(InitMobs.UPPER_RIGELIAN.get(), UpperRigelianRenderer::new);
        event.registerEntityRenderer(InitMobs.ROCKET.get(), RocketRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PleyadianModel.LAYER_LOCATION, PleyadianModel::createBodyLayer);
        event.registerLayerDefinition(RigelianModel.LAYER_LOCATION, RigelianModel::createBodyLayer);
        event.registerLayerDefinition(UpperPleyadianModel.LAYER_LOCATION, UpperPleyadianModel::createBodyLayer);
        event.registerLayerDefinition(UpperRigelianModel.LAYER_LOCATION, UpperRigelianModel::createBodyLayer);
        event.registerLayerDefinition(RocketModel.LAYER_LOCATION, RocketModel::createBodyLayer);
    }
}