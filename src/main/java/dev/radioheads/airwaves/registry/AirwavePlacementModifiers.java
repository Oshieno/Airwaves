package dev.radioheads.airwaves.registry;

import dev.radioheads.airwaves.Airwaves;
import dev.radioheads.airwaves.api.world.placement_modifier.BooleanConfigPlacementModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class AirwavePlacementModifiers {
    private AirwavePlacementModifiers() {}

    public static final DeferredRegister<PlacementModifierType<?>> REGISTER = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, Airwaves.MOD_ID);

    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<BooleanConfigPlacementModifier>> CONFIG_BOOLEAN = REGISTER.register("config_boolean", () -> () -> BooleanConfigPlacementModifier.CODEC);
}
