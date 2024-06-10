package ictoan.gatewaytimer.mixin.client;

import ictoan.gatewaytimer.GatewayTimer;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(EndGatewayBlockEntity.class)
public class EndGatewayBlockEntityMixin {
    @Inject(at = @At("HEAD"), method = "clientTick")
    private static void inject(World world, BlockPos pos, BlockState state, EndGatewayBlockEntity blockEntity, CallbackInfo ci) {
        List<ClientPlayerEntity> list = world.getEntitiesByClass(ClientPlayerEntity.class, new Box(pos), EndGatewayBlockEntity::canTeleport);
        if (list.size() > 0) {
            GatewayTimer.isInGateway = true;
        }
    }
}
