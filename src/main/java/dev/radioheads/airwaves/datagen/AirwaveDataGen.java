package dev.radioheads.airwaves.datagen;

import dev.radioheads.airwaves.Airwaves;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Airwaves.MOD_ID)
public class AirwaveDataGen {
    @SubscribeEvent
    public static void generate(GatherDataEvent event) {

    }
}
