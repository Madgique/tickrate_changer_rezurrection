package com.madgique.tickratechangerrezurrection.forge;

import com.madgique.tickratechangerrezurrection.config.TickrateChangerRezurrectionConfig;
import com.madgique.tickratechangerrezurrection.network.TickrateChangerRezurrectionNetwork;
import dev.architectury.platform.forge.EventBuses;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;


import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TickrateChangerRezurrection.MOD_ID)
public final class TickrateChangerRezurrectionForge {
    public TickrateChangerRezurrectionForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(TickrateChangerRezurrection.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        //Run our common setup.
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> TickrateChangerRezurrectionNetwork::registerPackets);
        AutoConfig.register(TickrateChangerRezurrectionConfig.class, Toml4jConfigSerializer::new);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClothConfigForge::registerConfig);
        new TickrateChangerRezurrection().init();
    }
}