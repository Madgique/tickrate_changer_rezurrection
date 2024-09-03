package com.lmagickl.tickratechangerrezurrection.mixin;

import com.lmagickl.tickratechangerrezurrection.TickrateChanger;
import net.minecraft.client.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Timer.class)
public class TimerMixin implements TickrateChanger {
    @Shadow
    @Mutable
    private float msPerTick;

    public void changeClientTickrate(float f, long l){
        TimerAccessor accessor = (TimerAccessor) (Object) this;
        accessor.setMsPerTick(1000.0F / f);
        accessor.setLastMs(l);
    }
}
