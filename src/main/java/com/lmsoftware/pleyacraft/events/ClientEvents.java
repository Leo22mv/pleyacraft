package com.lmsoftware.pleyacraft.events;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.ManaHudOverlay;
import com.lmsoftware.pleyacraft.client.TravelHudOverlay;
import com.lmsoftware.pleyacraft.init.InitItems;
import com.lmsoftware.pleyacraft.mana.PlayerManaProvider;
import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.networking.packet.ChangeDestinationC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.FillManaC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.ManaDataSyncS2CPacket;
import com.lmsoftware.pleyacraft.networking.packet.TravelC2SPacket;
import com.lmsoftware.pleyacraft.util.KeyBinding;
import com.lmsoftware.pleyacraft.world.dimension.ModDimensions;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.ForgeConfig.Server;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkEvent;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = Pleyacraft.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.DRINKING_KEY.consumeClick()) {
                ModMessages.sendToServer(new ChangeDestinationC2SPacket());
            }

            if(KeyBinding.TRAVEL_KEY.consumeClick()) {
                ModMessages.sendToServer(new TravelC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = Pleyacraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DRINKING_KEY);
            event.register(KeyBinding.TRAVEL_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("mana", ManaHudOverlay.HUD_MANA);
            event.registerAboveAll("travel", TravelHudOverlay.HUD_TRAVEL);
        }
    }
}
