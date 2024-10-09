package com.madgique.tickratechangerrezurrection.mixin;

import com.madgique.tickratechangerrezurrection.TickrateChanger;
import net.minecraft.client.Timer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Timer.class)
public class TimerMixin implements TickrateChanger {
    public void changeClientTickrate(float f, long l){
        TimerAccessor accessor = (TimerAccessor) (Object) this;
        accessor.setMsPerTick(1000.0F / f);
        accessor.setLastMs(l);
    }
}
