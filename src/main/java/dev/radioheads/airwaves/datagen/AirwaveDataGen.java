package dev.radioheads.airwaves.datagen;

import dev.radioheads.airwaves.Airwaves;
import dev.radioheads.airwaves.datagen.recipe.create.SandpaperRecipeGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Airwaves.MOD_ID)
public class AirwaveDataGen {
    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        var registries = event.getLookupProvider();

        event.addProvider(new SandpaperRecipeGen(output, registries));
        event.addProvider(new AirwaveGeneratedEntriesProvider(output, registries));
    }
}
