package com.lmsoftware.pleyacraft.networking.packet;

import java.util.List;
import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.travel.PlayerTravelProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ChangeDestinationC2SPacket {

    public ChangeDestinationC2SPacket() {

    }

    public ChangeDestinationC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            player.getCapability(PlayerTravelProvider.PLAYER_TRAVEL).ifPresent(travel -> {
                if (travel.isOnRocket()) {
                    List<String> avaliableDestinations = travel.getAvaliableDestinations();
                    String actualDestination = travel.getDestination();
                    String newDestination;
                    if (avaliableDestinations.indexOf(actualDestination)==avaliableDestinations.size()-1) {
                        newDestination = avaliableDestinations.get(0);
                    } else {
                        newDestination = avaliableDestinations.get(avaliableDestinations.indexOf(actualDestination) + 1);
                    }
                    travel.setDestination(newDestination);

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
                    
                    ModMessages.sendToPlayer(new TravelDataSyncS2CPacket(true, destinationId), player);
                }
            });
        });
        return true;
    }
}
