package com.steven23334.tlm_substitute_jizo_expand.item;

import com.steven23334.tlm_substitute_jizo_expand.init.ModItems; // 新增导入
import com.github.tartaricacid.touhoulittlemaid.api.event.InteractMaidEvent;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

// 删除 import com.github.tartaricacid.touhoulittlemaid.init.InitItems;

@EventBusSubscriber
public class SubstituteJizo extends Item {
    public SubstituteJizo() {
        super((new Properties()).stacksTo(1).rarity(Rarity.EPIC));
    }

    @SubscribeEvent
    public static void onEntityInteract(InteractMaidEvent event) {
        EntityMaid maid = event.getMaid();
        ItemStack stack = event.getStack();
        Player player = event.getPlayer();
        // 改用 ModItems 中的常量
        if (maid.isOwnedBy(player) && stack.getItem() == ModItems.SUBSTITUTE_JIZO.get() && !maid.getIsInvulnerable()) {
            maid.setEntityInvulnerable(true);
            player.getCooldowns().addCooldown(stack.getItem(), 40);
            stack.shrink(0);
            event.setCanceled(true);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack,
                                @Nullable TooltipContext worldIn,
                                @Nonnull List<Component> tooltip,
                                @Nonnull TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltips.tlm_substitute_jizo_expand.substitute_jizo.desc")
                .withStyle(ChatFormatting.GRAY));
    }

    @Override
    public boolean isFoil(@Nonnull ItemStack stack) {
        return true;
    }
}