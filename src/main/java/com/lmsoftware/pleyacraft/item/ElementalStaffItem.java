package com.lmsoftware.pleyacraft.item;

import java.util.ArrayList;

import com.lmsoftware.pleyacraft.init.InitItems;
import com.lmsoftware.pleyacraft.mana.PlayerManaProvider;
import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.networking.packet.ManaDataSyncS2CPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ElementalStaffItem extends Item {

    public ElementalStaffItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {

        p_41433_.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
            if(mana.getMana() > 0) {
                var pos = p_41433_.position();

                BlockPos pos1 = new BlockPos(pos.x, pos.y - 1, pos.z);
                BlockPos pos2 = new BlockPos(pos.x - 1, pos.y - 1, pos.z);
                BlockPos pos3 = new BlockPos(pos.x - 1, pos.y - 1, pos.z - 1);
                BlockPos pos4 = new BlockPos(pos.x, pos.y - 1, pos.z - 1);
                BlockPos pos5 = new BlockPos(pos.x + 1, pos.y - 1, pos.z - 1);
                BlockPos pos6 = new BlockPos(pos.x + 1, pos.y - 1, pos.z);
                BlockPos pos7 = new BlockPos(pos.x + 1, pos.y - 1, pos.z + 1);
                BlockPos pos8 = new BlockPos(pos.x, pos.y - 1, pos.z + 1);
                BlockPos pos9 = new BlockPos(pos.x - 1, pos.y - 1, pos.z + 1);

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

                boolean substractedMana = false;

                for (BlockPos blockPos : blockPositions) {
                    Level level = Minecraft.getInstance().level;
                    BlockState blockState = level.getBlockState(blockPos);
                    if (blockState.getBlock() == Blocks.AIR || blockState.getBlock() == Blocks.WATER) {
                        level.setBlockAndUpdate(blockPos, Blocks.ICE.defaultBlockState());
                        if (!substractedMana) {
                            if (!p_41433_.isCreative()) {
                                mana.subMana(1);
                                ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), (ServerPlayer) p_41433_);
                            }
                            ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), (ServerPlayer) p_41433_);
                            p_41433_.getCooldowns().addCooldown(this, 15);
                            substractedMana = true;
                        }
                    }
                }
            }
        });

        return super.use(p_41432_, p_41433_, p_41434_);
    }
}
