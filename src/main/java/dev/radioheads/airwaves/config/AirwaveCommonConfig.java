package dev.radioheads.airwaves.config;

import dev.radioheads.airwaves.config.common.AirwaveWorldGenConfig;
import net.createmod.catnip.config.ConfigBase;

public class AirwaveCommonConfig extends ConfigBase {
    public final AirwaveWorldGenConfig worldGen = nested(0, AirwaveWorldGenConfig::new, "Config options for Airwaves World Generation");

    @Override
    public String getName() {
        return "common";
    }
}
