package com.lmsoftware.pleyacraft.entities;

import com.lmsoftware.pleyacraft.init.InitItems;
import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.networking.packet.FillManaC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.HideTravelHudC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.ManaDataSyncS2CPacket;
import com.lmsoftware.pleyacraft.networking.packet.ShowTravelHudC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.TravelDataSyncS2CPacket;
import com.lmsoftware.pleyacraft.travel.PlayerTravelProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Pig;

// public class RocketEntity extends Entity implements PlayerRideable {
public class RocketEntity extends Mob implements PlayerRideable {
    public RocketEntity(EntityType<? extends Mob> p_21368_, Level p_21369_) {
        super(p_21368_, p_21369_);
    }

    public boolean hurt(DamageSource p_38319_, float p_38320_) {
      if (this.isInvulnerableTo(p_38319_)) {
         return false;
      } else if (!this.level.isClientSide && !this.isRemoved()) {
        if (p_38319_.msgId != "fall") {
            this.destroy(p_38319_);
            this.discard();   
        }
         return true;
      } else {
         return true;
      }
    }

    private void destroy(DamageSource p_38319_) {
        if (!Minecraft.getInstance().player.isCreative()) {
            this.spawnAtLocation(this.getDropItem());
        }
    }

    public Item getDropItem() {
        return InitItems.ROCKET.get();
    }

    @Override
    protected InteractionResult mobInteract(Player p_21472_, InteractionHand p_21473_) {
        p_21472_.startRiding(this);

        // p_21472_.getCapability(PlayerTravelProvider.PLAYER_TRAVEL).ifPresent(travel -> {
        //     travel.setOnRocket(true);
        //     ModMessages.sendToPlayer(new TravelDataSyncS2CPacket(travel.isOnRocket()), (ServerPlayer) p_21472_);
        // });

        ModMessages.sendToServer(new ShowTravelHudC2SPacket());

        return super.mobInteract(p_21472_, p_21473_);
    }

    public static AttributeSupplier.Builder getRocketEntityAttrs() {
        return Mob.createMobAttributes();
    }

    @Override
    protected void removePassenger(Entity p_20352_) {
        // ModMessages.sendToServer(new HideTravelHudC2SPacket());

        p_20352_.getCapability(PlayerTravelProvider.PLAYER_TRAVEL).ifPresent(travel -> {
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

            ModMessages.sendToPlayer(new TravelDataSyncS2CPacket(travel.isOnRocket(), destinationId), (ServerPlayer) p_20352_);
        });

        super.removePassenger(p_20352_);
    }
}