package com.lmsoftware.pleyacraft.item;

import java.util.ArrayList;

import com.lmsoftware.pleyacraft.init.InitBlocks;
import com.lmsoftware.pleyacraft.init.InitItems;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownIceStone extends ThrowableItemProjectile {

    

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
                var pos = p_37404_.getEntity().position();

                freezeEntity(new BlockPos(pos));
            }
    }

    protected void onHit(HitResult p_37406_) {
        var server = this.getServer();
        if(server != null) {
            //  Verifica si el tipo de resultado es un bloque
            if (p_37406_.getType() == HitResult.Type.BLOCK) {
                BlockPos hitPos = ((BlockHitResult) p_37406_).getBlockPos(); // Obtiene la posición del bloque golpeado
                    
                freezeBlock(hitPos);
            }
        }

        super.onHit(p_37406_);
        if (!this.level.isClientSide) {
           this.level.broadcastEntityEvent(this, (byte)3);
           this.discard();
        }

    }

    private void freezeBlock(BlockPos pos) {
        BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        BlockPos pos5 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        BlockPos pos6 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        BlockPos pos7 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);

        BlockPos pos8 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ());
        BlockPos pos9 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
        BlockPos pos10 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ());
        BlockPos pos11 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());

        BlockPos pos12 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1);
        BlockPos pos13 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1);
        BlockPos pos14 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1);
        BlockPos pos15 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1);
        BlockPos pos16 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ() - 1);
        BlockPos pos17 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ() - 1);
        BlockPos pos18 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1);
        BlockPos pos19 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ() - 1);

        BlockPos pos20 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1);
        BlockPos pos21 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1);
        BlockPos pos22 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1);
        BlockPos pos23 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1);
        BlockPos pos24 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ() + 1);
        BlockPos pos25 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
        BlockPos pos26 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ() + 1);
        BlockPos pos27 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ() + 1);

        ArrayList<BlockPos> blockPositions = new ArrayList<BlockPos>();
        
        blockPositions.add(pos);
        blockPositions.add(pos2);
        blockPositions.add(pos3);
        blockPositions.add(pos4);
        blockPositions.add(pos5);
        blockPositions.add(pos6);
        blockPositions.add(pos7);
        blockPositions.add(pos8);
        blockPositions.add(pos9);
        blockPositions.add(pos10);
        blockPositions.add(pos11);
        blockPositions.add(pos12);
        blockPositions.add(pos13);
        blockPositions.add(pos14);
        blockPositions.add(pos15);
        blockPositions.add(pos16);
        blockPositions.add(pos17);
        blockPositions.add(pos18);
        blockPositions.add(pos19);
        blockPositions.add(pos20);
        blockPositions.add(pos21);
        blockPositions.add(pos22);
        blockPositions.add(pos23);
        blockPositions.add(pos24);
        blockPositions.add(pos25);
        blockPositions.add(pos26);
        blockPositions.add(pos27);

        for (BlockPos blockPos : blockPositions) {
            BlockState blockState = level.getBlockState(blockPos);
            if (blockState.getBlock() == Blocks.AIR || blockState.getBlock() == Blocks.WATER) {
                level.setBlockAndUpdate(blockPos, Blocks.ICE.defaultBlockState());
            }
        };


        // var stack = server.createCommandSourceStack();
        // var command = "fill " + (int)(pos.x - 1) + " " + (int)(pos.y - 1) + " " + (int)(pos.z - 1) + " " + (int)(pos.x + 1) + " " + (int)(pos.y + 2) + " " + (int)(pos.z + 1) + " minecraft:ice replace minecraft:air";
        // var command2 = "fill " + (int)(pos.x - 2) + " " + (int)(pos.y - 1) + " " + (int)(pos.z - 2) + " " + (int)(pos.x + 2) + " " + (int)(pos.y - 1) + " " + (int)(pos.z + 2) + " minecraft:ice replace minecraft:water";
        // server.getCommands().performCommand(
        //         stack,
        //         command
        // );
        // server.getCommands().performCommand(
        //         stack,
        //         command2
        // );
    }

    private void freezeEntity(BlockPos pos) {
        BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        BlockPos pos4 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        BlockPos pos5 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        BlockPos pos6 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        BlockPos pos7 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);

        BlockPos pos8 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ());
        BlockPos pos9 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
        BlockPos pos10 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ());
        BlockPos pos11 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());

        BlockPos pos12 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1);
        BlockPos pos13 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1);
        BlockPos pos14 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1);
        BlockPos pos15 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1);
        BlockPos pos16 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ() - 1);
        BlockPos pos17 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ() - 1);
        BlockPos pos18 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1);
        BlockPos pos19 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ() - 1);

        BlockPos pos20 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1);
        BlockPos pos21 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1);
        BlockPos pos22 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1);
        BlockPos pos23 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1);
        BlockPos pos24 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ() + 1);
        BlockPos pos25 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
        BlockPos pos26 = new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ() + 1);
        BlockPos pos27 = new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ() + 1);

        BlockPos pos28 = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ());
        BlockPos pos29 = new BlockPos(pos.getX() - 1, pos.getY() + 2, pos.getZ());
        BlockPos pos30 = new BlockPos(pos.getX() + 1, pos.getY() + 2, pos.getZ());
        BlockPos pos31 = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ() - 1);
        BlockPos pos32 = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ() + 1);
        BlockPos pos33 = new BlockPos(pos.getX() - 1, pos.getY() + 2, pos.getZ() - 1);
        BlockPos pos34 = new BlockPos(pos.getX() + 1, pos.getY() + 2, pos.getZ() - 1);
        BlockPos pos35 = new BlockPos(pos.getX() - 1, pos.getY() + 2, pos.getZ() + 1);
        BlockPos pos36 = new BlockPos(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 1);

        BlockPos pos37 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ());
        BlockPos pos38 = new BlockPos(pos.getX() - 1, pos.getY() + 3, pos.getZ());
        BlockPos pos39 = new BlockPos(pos.getX() + 1, pos.getY() + 3, pos.getZ());
        BlockPos pos40 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ() - 1);
        BlockPos pos41 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ() + 1);
        BlockPos pos42 = new BlockPos(pos.getX() - 1, pos.getY() + 3, pos.getZ() - 1);
        BlockPos pos43 = new BlockPos(pos.getX() + 1, pos.getY() + 3, pos.getZ() - 1);
        BlockPos pos44 = new BlockPos(pos.getX() - 1, pos.getY() + 3, pos.getZ() + 1);
        BlockPos pos45 = new BlockPos(pos.getX() + 1, pos.getY() + 3, pos.getZ() + 1);

        ArrayList<BlockPos> blockPositions = new ArrayList<BlockPos>();

        blockPositions.add(pos);
        blockPositions.add(pos2);
        blockPositions.add(pos3);
        blockPositions.add(pos4);
        blockPositions.add(pos5);
        blockPositions.add(pos6);
        blockPositions.add(pos7);
        blockPositions.add(pos8);
        blockPositions.add(pos9);
        blockPositions.add(pos10);
        blockPositions.add(pos11);
        blockPositions.add(pos12);
        blockPositions.add(pos13);
        blockPositions.add(pos14);
        blockPositions.add(pos15);
        blockPositions.add(pos16);
        blockPositions.add(pos17);
        blockPositions.add(pos18);
        blockPositions.add(pos19);
        blockPositions.add(pos20);
        blockPositions.add(pos21);
        blockPositions.add(pos22);
        blockPositions.add(pos23);
        blockPositions.add(pos24);
        blockPositions.add(pos25);
        blockPositions.add(pos26);
        blockPositions.add(pos27);
        blockPositions.add(pos28);
        blockPositions.add(pos29);
        blockPositions.add(pos30);
        blockPositions.add(pos31);
        blockPositions.add(pos32);
        blockPositions.add(pos33);
        blockPositions.add(pos34);
        blockPositions.add(pos35);
        blockPositions.add(pos36);
        blockPositions.add(pos37);
        blockPositions.add(pos38);
        blockPositions.add(pos39);
        blockPositions.add(pos40);
        blockPositions.add(pos41);
        blockPositions.add(pos42);
        blockPositions.add(pos43);
        blockPositions.add(pos44);
        blockPositions.add(pos45);

        for (BlockPos blockPos : blockPositions) {
            BlockState blockState = level.getBlockState(blockPos);
            if (blockState.getBlock() == Blocks.AIR || blockState.getBlock() == Blocks.WATER) {
                level.setBlockAndUpdate(blockPos, Blocks.ICE.defaultBlockState());
            }
        };
    }
    
}
