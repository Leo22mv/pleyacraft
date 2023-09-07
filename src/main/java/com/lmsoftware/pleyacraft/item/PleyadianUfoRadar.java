package com.lmsoftware.pleyacraft.item;

import com.lmsoftware.pleyacraft.util.Summon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PleyadianUfoRadar extends Item{
    
    public PleyadianUfoRadar(Properties p_41383_) {
        super(p_41383_);
        //TODO Auto-generated constructor stub
    }

    // @Override
    // public InteractionResultHolder<ItemStack> use(Player player) {
    //     var server = player.getServer();
    //     if (server != null) {
    //         var stack = server.createCommandSourceStack();
    //         var pos = player.position();
    //         server.getCommands().performCommand(
    //                 stack,
    //                 "locate structure pleyacraft:pleyadian_ufo");
    //     }
    // }
}
