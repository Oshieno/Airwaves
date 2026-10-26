package dev.radioheads.airwaves.config.common;

import dev.radioheads.airwaves.Airwaves;
import dev.radioheads.airwaves.api.annotations.NothingNullByDefault;
import dev.radioheads.airwaves.api.world.placement_modifier.BooleanConfigPlacementModifier;
import net.createmod.catnip.config.ConfigBase;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NothingNullByDefault
public class AirwaveWorldGenConfig extends ConfigBase {
    // bump this version to reset configured values.
    private static final int VERSION = 1;

    public static final List<ResourceLocation> DEFAULT_TOGGLES = List.of(
            Airwaves.asResource("silver_ore")
    );

    protected final Map<ResourceLocation, ModConfigSpec.ConfigValue<Boolean>> toggles = new HashMap<>();

    @Override
    public void registerAll(ModConfigSpec.Builder builder) {
        builder.push("toggles");
        builder.comment(Comments.toggles);

        for (ResourceLocation key : DEFAULT_TOGGLES) {
            toggles.put(key, builder.define(key.getPath(), true));
        }

        builder.pop();
        DEFAULT_TOGGLES.forEach(key -> BooleanConfigPlacementModifier.OPTIONS.put(key, () -> toggles.get(key).get()));

        super.registerAll(builder);
    }

    @Override
    public String getName() {
        return "worldgen.v" + VERSION;
    }

    private static class Comments {
        static String toggles = "Toggle individual world generation features.";
    }
}
