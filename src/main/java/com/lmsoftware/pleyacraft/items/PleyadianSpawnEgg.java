package com.lmsoftware.pleyacraft.items;

import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.utils.Summon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ThrowablePotionItem;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;

// public class PleyadianSpawnEgg extends ThrowablePotionItem {
// public class PleyadianSpawnEgg extends SpawnEggItem {
public class PleyadianSpawnEgg extends ForgeSpawnEggItem {

    // public PleyadianSpawnEgg(EntityType<? extends Mob> p_43207_, int p_43208_, int p_43209_, Properties p_43210_) {
    //     super(p_43207_, p_43208_, p_43209_, p_43210_);
    //     //TODO Auto-generated constructor stub
    // }

    // public PleyadianSpawnEgg(Properties p_43301_) {
    //     super(p_43301_);
    //     //TODO Auto-generated constructor stub
    // }

    public PleyadianSpawnEgg(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor,
            int highlightColor, Properties props) {
        super(type, backgroundColor, highlightColor, props);
        //TODO Auto-generated constructor stub
    }

    // @Override
    // public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interact) {
    //     var result = super.use(level, player, interact);
    //     Summon.summonEntity("pleyacraft:pleyadian", player);
    //     return result;
    // }
    
}
