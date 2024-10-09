package com.madgique.tickratechangerrezurrection.config;


import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = TickrateChangerRezurrection.MOD_ID)
public class TickrateChangerRezurrectionConfig implements ConfigData {
    @Comment("Default tickrate. The game will always initialize with this value.")
    public float defaultTickrate = TickrateChangerRezurrection.DEFAULT_VALUE_DEFAULT_TICKRATE;
    @Comment("Maximum tickrate from servers. Prevents really high tickrate values.")
    public float maxTickrate = TickrateChangerRezurrection.DEFAULT_VALUE_MAX_TICKRATE;
    @Comment("Minimum tickrate from servers. Prevents really low tickrate values.")
    public float minTickrate = TickrateChangerRezurrection.DEFAULT_VALUE_MIN_TICKRATE;
    @Comment("Whether it will change the sound speed")
    public boolean changeSound = TickrateChangerRezurrection.DEFAULT_VALUE_CHANGE_SOUND;
//    @Comment("Whether it will have special keys for setting the tickrate")
//    public boolean keyBindings = TickrateChangerRezurrection.KEY;
    @Comment("Whether it will show log messages in the console and the game")
    public boolean showMessages= TickrateChangerRezurrection.DEFAULT_VALUE_SHOW_MESSAGES;

    
}
