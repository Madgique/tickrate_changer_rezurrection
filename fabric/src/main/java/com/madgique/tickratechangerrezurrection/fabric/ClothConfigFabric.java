package com.madgique.tickratechangerrezurrection.fabric;

import com.madgique.tickratechangerrezurrection.config.ClothConfigGUIBuilder;
import com.madgique.tickratechangerrezurrection.config.TickrateChangerRezurrectionConfig;
import com.mojang.blaze3d.systems.RenderSystem;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.clothconfig2.ClothConfigDemo;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.gui.screens.Screen;

public class ClothConfigFabric implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> {
            if (RenderSystem.isOnRenderThread() && Screen.hasShiftDown()) return AutoConfig.getConfigScreen(TickrateChangerRezurrectionConfig.class, screen).get();
            return ClothConfigGUIBuilder.getConfigBuilder().setParentScreen(screen).build();
        };
    }
}
