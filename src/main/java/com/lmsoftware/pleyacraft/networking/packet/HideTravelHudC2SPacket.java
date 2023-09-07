package com.lmsoftware.pleyacraft.networking.packet;

import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.travel.PlayerTravelProvider;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class HideTravelHudC2SPacket {
    public HideTravelHudC2SPacket() {

    }

    public HideTravelHudC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            player.getCapability(PlayerTravelProvider.PLAYER_TRAVEL).ifPresent(travel -> {
                travel.setOnRocket(false);
                int destinationId = 0;

                    switch (travel.getDestination()) {
                        case "earth":
                            destinationId = 1;
                            break;

                        case "atlas":
                            destinationId = 2;
                            break;

                        case "rigel":
                            destinationId = 3;
                            break;
                    
                        default:
                            break;
                    }

                    ModMessages.sendToPlayer(new TravelDataSyncS2CPacket(travel.isOnRocket(), destinationId), player);
            });
        });
        return true;
    }
}
