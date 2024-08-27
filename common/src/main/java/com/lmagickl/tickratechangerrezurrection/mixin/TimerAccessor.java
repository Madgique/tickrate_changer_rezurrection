package com.lmagickl.tickratechangerrezurrection.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.client.Timer;

@Mixin(Timer.class)
public interface TimerAccessor {
    @Accessor("msPerTick")
    void setMsPerTick(float msPerTick);

    @Accessor("lastMs")
    void setLastMs(long lastMs);
}
