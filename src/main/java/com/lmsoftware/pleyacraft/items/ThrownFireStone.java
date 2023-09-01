package com.lmsoftware.pleyacraft.items;

import com.lmsoftware.pleyacraft.init.InitItems;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownFireStone extends ThrowableItemProjectile{

    

    public ThrownFireStone(LivingEntity p_37439_, Level p_37440_) {
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
        int i = entity instanceof Blaze ? 1 : 3;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);

        var position = entity.position();

        Vec3 pos = new Vec3(position.x, position.y-1, position.z);
        light(pos);

        Vec3 pos1 = new Vec3(position.x-1, position.y-1, position.z);
        light(pos1);

        Vec3 pos2 = new Vec3(position.x+1, position.y-1, position.z);
        light(pos2);

        Vec3 pos3 = new Vec3(position.x, position.y-1, position.z-1);
        light(pos3);

        Vec3 pos4 = new Vec3(position.x, position.y-1, position.z+1);
        light(pos4);

        Vec3 pos5 = new Vec3(position.x-1, position.y-1, position.z-1);
        light(pos5);

        Vec3 pos6 = new Vec3(position.x+1, position.y-1, position.z+1);
        light(pos6);

        Vec3 pos7 = new Vec3(position.x-1, position.y-1, position.z+1);
        light(pos7);

        Vec3 pos8 = new Vec3(position.x+1, position.y-1, position.z-1);
        light(pos8);
    }

    protected void onHit(HitResult p_37406_) {
        var player = Minecraft.getInstance().player;
        var level = Minecraft.getInstance().level;
        // player.sendSystemMessage(Component.literal(p_37406_.getType().toString()));
        if (p_37406_.getType().toString()=="BLOCK") {
            var pos = p_37406_.getLocation();
            light(pos);

            Vec3 pos1 = new Vec3(pos.x-1, pos.y, pos.z);
            light(pos1);

            Vec3 pos2 = new Vec3(pos.x+1, pos.y, pos.z);
            light(pos2);

            Vec3 pos3 = new Vec3(pos.x, pos.y, pos.z-1);
            light(pos3);

            Vec3 pos4 = new Vec3(pos.x, pos.y, pos.z+1);
            light(pos4);

            Vec3 pos5 = new Vec3(pos.x-1, pos.y, pos.z-1);
            light(pos5);

            Vec3 pos6 = new Vec3(pos.x+1, pos.y, pos.z+1);
            light(pos6);

            Vec3 pos7 = new Vec3(pos.x-1, pos.y, pos.z+1);
            light(pos7);

            Vec3 pos8 = new Vec3(pos.x+1, pos.y, pos.z-1);
            light(pos8);
        }
      super.onHit(p_37406_);
      if (!this.level.isClientSide) {
         this.level.broadcastEntityEvent(this, (byte)3);
         this.discard();
      }

    }
    
    private void light(Vec3 pos) {
        var player = Minecraft.getInstance().player;
        BlockPos blockpos = new BlockPos(pos);
        BlockState blockstate = level.getBlockState(blockpos);
        if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
            BlockState blockstate1 = BaseFireBlock.getState(level, blockpos);
            level.setBlock(blockpos, blockstate1, 11);
            level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
        }
    }
}
