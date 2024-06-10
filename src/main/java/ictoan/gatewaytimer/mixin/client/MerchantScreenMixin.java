package ictoan.gatewaytimer.mixin.client;

import ictoan.gatewaytimer.GatewayTimer;
import ictoan.gatewaytimer.client.GatewayTimerClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MerchantScreen.class)
public abstract class MerchantScreenMixin extends Screen {
    protected MerchantScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "drawForeground")
    private void init(DrawContext context, int mouseX, int mouseY, CallbackInfo ci) {
        MinecraftClient mc = MinecraftClient.getInstance();
        try {
            Identifier worldId = mc.player.getEntityWorld().getRegistryKey().getValue();
            if (worldId.toString().equals("minecraft:the_end")) {
                context.drawGuiTexture(
                        GatewayTimerClient.barOutline,
                        GatewayTimerClient.BAR_X,
                        GatewayTimerClient.BAR_Y,
                        GatewayTimerClient.BAR_W,
                        GatewayTimerClient.BAR_H
                );
                int cooldown = GatewayTimer.gatewayCooldown;
                for (int y = 0; y < cooldown; y++) {
                    int adjusted_y = ((GatewayTimerClient.BAR_Y + GatewayTimerClient.BAR_H) - y) - 2;
                    context.drawGuiTexture(
                            GatewayTimerClient.barSegment,
                            GatewayTimerClient.BAR_SEGMENT_X,
                            adjusted_y,
                            GatewayTimerClient.BAR_SEGMENT_W,
                            GatewayTimerClient.BAR_SEGMENT_H
                    );
                }
            }
        } catch(NullPointerException e) {
            // uhhhhh
        }
    }
}
