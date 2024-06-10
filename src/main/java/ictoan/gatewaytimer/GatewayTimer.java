package ictoan.gatewaytimer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GatewayTimer implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("gatewaytimer");
    public static int gatewayCooldown;
    public static boolean isInGateway;
    public static String MOD_ID = "gatewaytimer";

    @Override
    public void onInitialize() {
        LOGGER.info("hello :)");
    }
}
