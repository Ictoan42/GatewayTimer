package ictoan.gatewaytimer.mixin.client;

import ictoan.gatewaytimer.GatewayTimer;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TeleportConfirmC2SPacket.class)
class TeleportConfirmC2SPacketMixin {
    @Inject(at = @At("HEAD"), method = "<init>")
    private static void inject(CallbackInfo ci) {
        GatewayTimer.gatewayCooldown = 20;
    }
}
