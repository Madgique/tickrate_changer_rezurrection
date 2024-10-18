package com.madgique.tickratechangerrezurrection.mixin;

import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @ModifyConstant(method = "runServer", constant = @Constant(longValue = 50L))
    private long patchServerTickrate(long original){
        return TickrateChangerRezurrection.MILISECONDS_PER_TICK;
    }
}
