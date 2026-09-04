package com.steven23334.tlm_substitute_jizo_expand;

import com.steven23334.tlm_substitute_jizo_expand.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;


@Mod(TlmSubstituteJizoExpand.MODID)
public class TlmSubstituteJizoExpand {
    public static final String MODID = "tlm_substitute_jizo_expand";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.tlm_substitute_jizo_expand"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.SUBSTITUTE_JIZO.get().getDefaultInstance())
                    // ====== 修改点：所有物品始终显示，不再依赖配置 ======
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SUBSTITUTE_JIZO.get());
                        output.accept(ModItems.REVERSE_SUBSTITUTE_JIZO.get());
                        output.accept(ModItems.ONE_TIME_REVERSE_SUBSTITUTE_JIZO.get()); // 始终显示
                    })
                    .build());

    public TlmSubstituteJizoExpand(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        // ====== 移除以下代码 ======
        // modContainer.registerConfig(...);
        // if (FMLEnvironment.dist == Dist.CLIENT) { ModLoadingContext.get().registerExtensionPoint(...); }
    }
}