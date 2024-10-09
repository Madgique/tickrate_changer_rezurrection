package com.madgique.tickratechangerrezurrection.forge;

import com.madgique.tickratechangerrezurrection.config.ClothConfigGUIBuilder;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;

public class ClothConfigForge {
    public static void registerConfig() {
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> (client, parent) -> {
            return ClothConfigGUIBuilder.getConfigBuilder().setParentScreen(parent).build();
        });
    }
}