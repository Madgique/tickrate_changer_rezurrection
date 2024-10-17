package com.madgique.tickratechangerrezurrection.forge;

import com.madgique.tickratechangerrezurrection.config.ClothConfigGUIBuilder;
import me.shedaniel.clothconfig2.ClothConfigDemo;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.fml.ModLoadingContext;

public class ClothConfigForge {
    public static void registerConfig() {
        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((client, parent) -> {
            return ClothConfigGUIBuilder.getConfigBuilder().setParentScreen(parent).build();
        }));
    }
}