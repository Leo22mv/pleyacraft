package com.lmsoftware.pleyacraft.networking;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.networking.packet.ChangeDestinationC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.FillManaC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.HideTravelHudC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.ManaDataSyncS2CPacket;
import com.lmsoftware.pleyacraft.networking.packet.ShowTravelHudC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.TravelC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.TravelDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(Pleyacraft.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ManaDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ManaDataSyncS2CPacket::new)
                .encoder(ManaDataSyncS2CPacket::toBytes)
                .consumerMainThread(ManaDataSyncS2CPacket::handle)
                .add();

        net.messageBuilder(FillManaC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(FillManaC2SPacket::new)
                .encoder(FillManaC2SPacket::toBytes)
                .consumerMainThread(FillManaC2SPacket::handle)
                .add();

        net.messageBuilder(TravelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TravelDataSyncS2CPacket::new)
                .encoder(TravelDataSyncS2CPacket::toBytes)
                .consumerMainThread(TravelDataSyncS2CPacket::handle)
                .add();

        net.messageBuilder(ShowTravelHudC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ShowTravelHudC2SPacket::new)
                .encoder(ShowTravelHudC2SPacket::toBytes)
                .consumerMainThread(ShowTravelHudC2SPacket::handle)
                .add();

        net.messageBuilder(HideTravelHudC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(HideTravelHudC2SPacket::new)
                .encoder(HideTravelHudC2SPacket::toBytes)
                .consumerMainThread(HideTravelHudC2SPacket::handle)
                .add();

        net.messageBuilder(TravelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(TravelC2SPacket::new)
                .encoder(TravelC2SPacket::toBytes)
                .consumerMainThread(TravelC2SPacket::handle)
                .add();

        net.messageBuilder(ChangeDestinationC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ChangeDestinationC2SPacket::new)
                .encoder(ChangeDestinationC2SPacket::toBytes)
                .consumerMainThread(ChangeDestinationC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
         INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}