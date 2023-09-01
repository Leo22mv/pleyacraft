package com.lmsoftware.pleyacraft.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FireStoneItem extends Item{

    public FireStoneItem(Properties p_41383_) {
        super(p_41383_);
        //TODO Auto-generated constructor stub
    }
    
    public InteractionResultHolder<ItemStack> use(Level p_41190_, Player p_41191_, InteractionHand p_41192_) {
      ItemStack itemstack = p_41191_.getItemInHand(p_41192_);
      p_41190_.playSound((Player)null, p_41191_.getX(), p_41191_.getY(), p_41191_.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (p_41190_.getRandom().nextFloat() * 0.4F + 0.8F));
      p_41191_.getCooldowns().addCooldown(this, 50);
      if (!p_41190_.isClientSide) {
         ThrownFireStone ThrownFireStone = new ThrownFireStone(p_41191_, p_41190_);
         ThrownFireStone.setItem(itemstack);
         ThrownFireStone.shootFromRotation(p_41191_, p_41191_.getXRot(), p_41191_.getYRot(), 0.0F, 1.5F, 1.0F);
         p_41190_.addFreshEntity(ThrownFireStone);
      }

      p_41191_.awardStat(Stats.ITEM_USED.get(this));
      if (!p_41191_.getAbilities().instabuild) {
         itemstack.shrink(1);
      }

      return InteractionResultHolder.sidedSuccess(itemstack, p_41190_.isClientSide());
   }
}
