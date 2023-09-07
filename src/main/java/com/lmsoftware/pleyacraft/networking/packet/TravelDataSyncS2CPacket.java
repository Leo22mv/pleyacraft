package com.lmsoftware.pleyacraft.networking.packet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.client.ClientDestinationData;
import com.lmsoftware.pleyacraft.client.ClientTravelData;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.network.NetworkEvent;

public class TravelDataSyncS2CPacket {
    private final boolean isOnRocket;
    private final int destination;

    public TravelDataSyncS2CPacket(boolean isOnRocket, int destination) {
        this.isOnRocket = isOnRocket;
        this.destination = destination;
    }

    public TravelDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.isOnRocket = buf.readBoolean();
        this.destination = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(isOnRocket);
        buf.writeInt(destination);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientTravelData.setIsOnRocket(isOnRocket);
            // Minecraft.getInstance().player.sendSystemMessage(Component.literal(destination + ""));
            ClientDestinationData.setDestination(destination);
        });
        return true;
    }
}
