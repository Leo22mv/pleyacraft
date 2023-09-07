package com.lmsoftware.pleyacraft.networking.packet;

import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.init.InitMobs;
import com.lmsoftware.pleyacraft.mana.PlayerManaProvider;
import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.travel.PlayerTravelProvider;
import com.lmsoftware.pleyacraft.world.dimension.ModDimensions;
import com.lmsoftware.pleyacraft.world.dimension.portal.ModTeleporter;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

public class TravelC2SPacket {
    public TravelC2SPacket() {

    }

    public TravelC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            Vec3 pos = player.position();

            player.getCapability(PlayerTravelProvider.PLAYER_TRAVEL).ifPresent(travel -> {
                if (travel.isOnRocket()) {
                    if (!player.isCrouching()) {
                        ServerLevel targetWorld = null;
                        Entity vehicle = player.getVehicle();
                        player.stopRiding();
                        vehicle.discard();
                        var availableDestinations = travel.getAvaliableDestinations();

                        switch (travel.getDestination()) {
                            case "earth":
                                targetWorld = player.getServer().getLevel(Level.OVERWORLD);
                                break;

                            case "atlas":
                                targetWorld = player.getServer().getLevel(ModDimensions.ATLASDIM_KEY);
                                break;

                            case "rigel":
                                targetWorld = player.getServer().getLevel(ModDimensions.RIGELDIM_KEY);
                                break;
                        
                            default:
                                break;
                        }

                        if (targetWorld != null) {
                            player.changeDimension(targetWorld, new ModTeleporter(new BlockPos(pos), false));
                            EntityType<?> entityType = InitMobs.ROCKET.get();
                            Entity entity = entityType.create(player.level);
                            entity.setPos(player.position());
                            player.level.addFreshEntity(entity);
                        }
                    }
                }
            });
        });
        return true;
    }
}
