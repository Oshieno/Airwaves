package dev.radioheads.airwaves.registry;

import dev.radioheads.airwaves.Airwaves;
import dev.radioheads.airwaves.api.world.placement_modifier.BooleanConfigPlacementModifier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public final class AirwavePlacedFeatures {
    private AirwavePlacedFeatures() {}

    public static final ResourceKey<PlacedFeature>
        SILVER_ORE = key("silver_ore");

    private static ResourceKey<PlacedFeature> key(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Airwaves.asResource(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> ctx) {
        HolderGetter<ConfiguredFeature<?, ?>> featureLookup = ctx.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> silverOre = featureLookup.getOrThrow(AirwaveConfiguredFeatures.SILVER_ORE);

        PlacementUtils.register(ctx, SILVER_ORE, silverOre, placement(CountPlacement.of(12), 85, 300, new BooleanConfigPlacementModifier(Airwaves.asResource("silver_ore"), true)));
    }

    private static List<PlacementModifier> placement(PlacementModifier frequency, int minHeight, int maxHeight, BooleanConfigPlacementModifier configPlacementModifier) {
        return List.of(
                frequency,
                InSquarePlacement.spread(),
                HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
                configPlacementModifier
        );
    }
}
