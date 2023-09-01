package com.lmsoftware.pleyacraft.items;

import com.lmsoftware.pleyacraft.init.InitItems;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownIceStone extends ThrowableItemProjectile{

    

    public ThrownIceStone(LivingEntity p_37439_, Level p_37440_) {
        super(EntityType.SNOWBALL, p_37439_, p_37440_);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Item getDefaultItem() {
        return Items.SNOWBALL;
    }

    protected void onHitEntity(EntityHitResult p_37404_) {
      super.onHitEntity(p_37404_);
      Entity entity = p_37404_.getEntity();
      int i = entity instanceof Blaze ? 3 : 1;
      entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);

      var server = p_37404_.getEntity().getServer();
            if(server != null) {
                var stack = server.createCommandSourceStack();
                // var pos = event.getEntity().position();
                var pos = p_37404_.getEntity().position();
                var command = "fill " + (int)(pos.x - 1) + " " + (int)(pos.y - 1) + " " + (int)(pos.z - 1) + " " + (int)(pos.x + 1) + " " + (int)(pos.y + 2) + " " + (int)(pos.z + 1) + " minecraft:ice";
                server.getCommands().performCommand(
                        stack,
                        command
                );
            }
    }

    protected void onHit(HitResult p_37406_) {
        var pos = p_37406_.getLocation();
        var server = this.getServer();

        if(server != null) {
            var stack = server.createCommandSourceStack();
            var command = "fill " + (int)(pos.x - 1) + " " + (int)(pos.y - 1) + " " + (int)(pos.z - 1) + " " + (int)(pos.x + 1) + " " + (int)(pos.y + 2) + " " + (int)(pos.z + 1) + " minecraft:ice";
            server.getCommands().performCommand(
                    stack,
                    command
            );
        }

        super.onHit(p_37406_);
        if (!this.level.isClientSide) {
           this.level.broadcastEntityEvent(this, (byte)3);
           this.discard();
        }

    }
    
}
