package com.madgique.tickratechangerrezurrection.config;

import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import me.shedaniel.autoconfig.AutoConfig;

public class ClothConfigGUIBuilder implements ConfigData {
    public ClothConfigGUIBuilder() {
    }

    public static ConfigBuilder getConfigBuilder() {
        ConfigBuilder builder = ConfigBuilder.create().setTitle(Component.literal("Tickrate Changer Rezurrection Config")).setSavingRunnable(() -> {
            AutoConfig.getConfigHolder(TickrateChangerRezurrectionConfig.class).save();
        });
        builder.setDefaultBackgroundTexture(new ResourceLocation("minecraft:textures/block/oak_planks.png"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory testing = builder.getOrCreateCategory(Component.literal("category pour tester"));

        // Tickrate related
        testing.addEntry(entryBuilder.startFloatField(Component.literal("Default Tickrate"), TickrateChangerRezurrection.CONFIG.defaultTickrate).setDefaultValue(TickrateChangerRezurrection.DEFAULT_VALUE_DEFAULT_TICKRATE).setSaveConsumer(newValue -> TickrateChangerRezurrection.CONFIG.defaultTickrate = newValue).build());
        testing.addEntry(entryBuilder.startFloatField(Component.literal("Min Tickrate"), TickrateChangerRezurrection.CONFIG.minTickrate).setDefaultValue(TickrateChangerRezurrection.DEFAULT_VALUE_MIN_TICKRATE).setSaveConsumer(newValue -> TickrateChangerRezurrection.CONFIG.minTickrate = newValue).build());
        testing.addEntry(entryBuilder.startFloatField(Component.literal("Max Tickrate"), TickrateChangerRezurrection.CONFIG.maxTickrate).setDefaultValue(TickrateChangerRezurrection.DEFAULT_VALUE_MAX_TICKRATE).setSaveConsumer(newValue -> TickrateChangerRezurrection.CONFIG.maxTickrate = newValue).build());

        // Booleans
        testing.addEntry(entryBuilder.startBooleanToggle(Component.literal("Change Sound"), TickrateChangerRezurrection.CONFIG.changeSound).setDefaultValue(TickrateChangerRezurrection.DEFAULT_VALUE_CHANGE_SOUND).setSaveConsumer(newValue -> TickrateChangerRezurrection.CONFIG.changeSound = newValue).build());
        //testing.addEntry(entryBuilder.startBooleanToggle(new TextComponent("Keys Availables"), true).setDefaultValue(keyBindings).build());
        testing.addEntry(entryBuilder.startBooleanToggle(Component.literal("Show Messages"), TickrateChangerRezurrection.CONFIG.showMessages).setDefaultValue(TickrateChangerRezurrection.DEFAULT_VALUE_SHOW_MESSAGES).setSaveConsumer(newValue -> TickrateChangerRezurrection.CONFIG.showMessages = newValue).build());

        return builder;
    }
}
