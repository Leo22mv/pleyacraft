package com.lmsoftware.pleyacraft.item;

import java.util.logging.Level;

import com.lmsoftware.pleyacraft.entities.RocketEntity;
import com.lmsoftware.pleyacraft.init.InitMobs;
import com.lmsoftware.pleyacraft.util.Summon;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class RocketItem extends PleyacraftItem{

    public RocketItem(Properties p_41383_) {
        super(p_41383_, "Con este cohete podés viajar a otros planetas");
        //TODO Auto-generated constructor stub
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        var level = p_41427_.getLevel();
        EntityType<?> entityType = InitMobs.ROCKET.get();
        Entity entity = entityType.create(level);
        if (entity != null) {
            entity.setPos(p_41427_.getClickedPos().getX(), p_41427_.getClickedPos().getY() + 1, p_41427_.getClickedPos().getZ());
            level.addFreshEntity(entity);
        }

        // Summon.summonEntity("pleyacraft:rocket", p_41427_.getPlayer());
        p_41427_.getItemInHand().shrink(1);
        return InteractionResult.SUCCESS;
    }

    // @Override
    // public ActionResult<ItemStack> onItemUse(ItemUseContext context) {
    //     World world = context.getWorld();
    //     if (!world.isRemote()) {
    //         EntityType<?> entityType = EntityTypeInit.ROCKET_ENTITY.get(); // Reemplaza con tu EntityType adecuado
    //         Entity entity = entityType.create(world);
    //         if (entity != null) {
    //             entity.setPosition(context.getPos().getX(), context.getPos().getY() + 1, context.getPos().getZ());
    //             world.addEntity(entity, SpawnReason.SPAWN_EGG, null, null);
    //         }
    //     }
    //     return ActionResult.resultSuccess(context.getItem());
    // }
}
