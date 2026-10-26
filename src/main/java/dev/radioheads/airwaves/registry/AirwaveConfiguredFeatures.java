package dev.radioheads.airwaves.registry;

import dev.radioheads.airwaves.Airwaves;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class AirwaveConfiguredFeatures {
    private AirwaveConfiguredFeatures() {}

    public static final ResourceKey<ConfiguredFeature<?, ?>>
        SILVER_ORE = key("silver_ore");

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Airwaves.asResource(name));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
        RuleTest stoneOreReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> silverTargetStates = List.of(
                OreConfiguration.target(stoneOreReplaceable, AirwaveBlocks.SILVER_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(ctx, SILVER_ORE, Feature.ORE, new OreConfiguration(silverTargetStates, 9));
    }
}
