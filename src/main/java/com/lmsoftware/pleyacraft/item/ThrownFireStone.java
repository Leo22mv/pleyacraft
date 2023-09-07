package com.lmsoftware.pleyacraft.item;

import java.util.ArrayList;

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
import net.minecraft.world.level.block.Blocks;
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

        light(position);
    }

    protected void onHit(HitResult p_37406_) {
        var player = Minecraft.getInstance().player;
        var level = Minecraft.getInstance().level;
        // player.sendSystemMessage(Component.literal(p_37406_.getType().toString()));
        if (p_37406_.getType().toString()=="BLOCK") {
            var pos = p_37406_.getLocation();
            light(pos);
        }
      super.onHit(p_37406_);
      if (!this.level.isClientSide) {
         this.level.broadcastEntityEvent(this, (byte)3);
         this.discard();
      }

    }
    
    private void light(Vec3 pos) {
        var player = Minecraft.getInstance().player;

        BlockPos pos1 = new BlockPos(pos.x, pos.y + 1, pos.z);
        BlockPos pos2 = new BlockPos(pos.x - 1, pos.y + 1, pos.z);
        BlockPos pos3 = new BlockPos(pos.x - 1, pos.y + 1, pos.z - 1);
        BlockPos pos4 = new BlockPos(pos.x, pos.y + 1, pos.z - 1);
        BlockPos pos5 = new BlockPos(pos.x + 1, pos.y + 1, pos.z - 1);
        BlockPos pos6 = new BlockPos(pos.x + 1, pos.y + 1, pos.z);
        BlockPos pos7 = new BlockPos(pos.x + 1, pos.y + 1, pos.z + 1);
        BlockPos pos8 = new BlockPos(pos.x, pos.y + 1, pos.z + 1);
        BlockPos pos9 = new BlockPos(pos.x - 1, pos.y + 1, pos.z + 1);

        ArrayList<BlockPos> blockPositions = new ArrayList<BlockPos>();
        
        blockPositions.add(pos1);
        blockPositions.add(pos2);
        blockPositions.add(pos3);
        blockPositions.add(pos4);
        blockPositions.add(pos5);
        blockPositions.add(pos6);
        blockPositions.add(pos7);
        blockPositions.add(pos8);
        blockPositions.add(pos9);


        for (BlockPos blockPos : blockPositions) {
            BlockState blockstate = level.getBlockState(blockPos);

            if (blockstate.getBlock() == Blocks.AIR) {
                if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
                    BlockState blockstate1 = BaseFireBlock.getState(level, blockPos);
                    level.setBlock(blockPos, blockstate1, 11);
                    level.gameEvent(player, GameEvent.BLOCK_PLACE, blockPos);
                }
            }
        }

        if (level.getBlockState(new BlockPos(pos)).getBlock() == Blocks.AIR) {
            BlockPos pos10 = new BlockPos(pos.x, pos.y, pos.z);
            BlockPos pos11 = new BlockPos(pos.x - 1, pos.y, pos.z);
            BlockPos pos12 = new BlockPos(pos.x - 1, pos.y, pos.z - 1);
            BlockPos pos13 = new BlockPos(pos.x, pos.y, pos.z - 1);
            BlockPos pos14 = new BlockPos(pos.x + 1, pos.y, pos.z - 1);
            BlockPos pos15 = new BlockPos(pos.x + 1, pos.y, pos.z);
            BlockPos pos16 = new BlockPos(pos.x + 1, pos.y, pos.z + 1);
            BlockPos pos17 = new BlockPos(pos.x, pos.y, pos.z + 1);
            BlockPos pos18 = new BlockPos(pos.x - 1, pos.y, pos.z + 1);

            ArrayList<BlockPos> blockPositions2 = new ArrayList<BlockPos>();
            
            blockPositions2.add(pos10);
            blockPositions2.add(pos11);
            blockPositions2.add(pos12);
            blockPositions2.add(pos13);
            blockPositions2.add(pos14);
            blockPositions2.add(pos15);
            blockPositions2.add(pos16);
            blockPositions2.add(pos17);
            blockPositions2.add(pos18);


            for (BlockPos blockPos : blockPositions2) {
                BlockState blockstate = level.getBlockState(blockPos);

                if (blockstate.getBlock() == Blocks.AIR) {
                    if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate) && !CandleCakeBlock.canLight(blockstate)) {
                        BlockState blockstate1 = BaseFireBlock.getState(level, blockPos);
                        level.setBlock(blockPos, blockstate1, 11);
                        level.gameEvent(player, GameEvent.BLOCK_PLACE, blockPos);
                    }
                }
            }
        }
    }
}
