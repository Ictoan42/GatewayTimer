package ictoan.gatewaytimer.client;

import ictoan.gatewaytimer.GatewayTimer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.util.Identifier;


public class GatewayTimerClient implements ClientModInitializer {
    public static int BAR_X = 244;
    public static int BAR_Y = 35;
    public static int BAR_W = 6;
    public static int BAR_H = 22;
    public static int BAR_SEGMENT_X = BAR_X + 1;
    public static int BAR_SEGMENT_Y_START = BAR_Y + 1;
    public static int BAR_SEGMENT_W = 4;
    public static int BAR_SEGMENT_H = 1;
    public static Identifier barOutline = new Identifier(GatewayTimer.MOD_ID, "bar_outline");
    public static Identifier barSegment = new Identifier(GatewayTimer.MOD_ID, "bar_segment");
    @Override
    public void onInitializeClient() {
        GatewayTimer.gatewayCooldown = 0;
        ClientTickEvents.START_CLIENT_TICK.register((mc) -> {
            GatewayTimer.isInGateway = false;
        });
        ClientTickEvents.END_CLIENT_TICK.register((mc) -> {
            if (GatewayTimer.isInGateway) {
                GatewayTimer.gatewayCooldown = 20;
            } else {
                if (GatewayTimer.gatewayCooldown > 0) {
                    --GatewayTimer.gatewayCooldown;
                }
            }
        });
        // pebis
    }
}
