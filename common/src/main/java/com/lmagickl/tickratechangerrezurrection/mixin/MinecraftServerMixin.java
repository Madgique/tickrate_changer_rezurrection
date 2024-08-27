package com.lmagickl.tickratechangerrezurrection.mixin;

import com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrection;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @ModifyConstant(method = "runServer", constant = @Constant(longValue = 50L))
    private long patchServerTickrate(long original){
        return TickrateChangerRezurrection.MILISECONDS_PER_TICK;
    }
}
