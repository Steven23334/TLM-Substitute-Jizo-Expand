package com.steven23334.tlm_substitute_jizo_expand.init;

import com.steven23334.tlm_substitute_jizo_expand.TlmSubstituteJizoExpand;
import com.steven23334.tlm_substitute_jizo_expand.item.ReverseSubstituteJizo;
import com.steven23334.tlm_substitute_jizo_expand.item.SubstituteJizo;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TlmSubstituteJizoExpand.MODID);

    // 使用 register，而不是 registerSimpleItem
    public static final DeferredItem<Item> SUBSTITUTE_JIZO =
            ITEMS.register("substitute_jizo", SubstituteJizo::new);

    public static final DeferredItem<Item> REVERSE_SUBSTITUTE_JIZO =
            ITEMS.register("reverse_substitute_jizo", ReverseSubstituteJizo::new);
}