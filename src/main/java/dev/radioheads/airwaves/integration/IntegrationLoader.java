package dev.radioheads.airwaves.integration;

import net.createmod.catnip.data.Pair;
import net.neoforged.bus.api.IEventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class IntegrationLoader {
    private static List<Pair<String, Consumer<IEventBus>>> integrations = new ArrayList<>();
    private static boolean constructed = false;

    private static void add(String name, Consumer<IEventBus> consumer) {
        integrations.add(Pair.of(name, consumer));
    }

    private static void construct() {
        //TODO: the mods
    }

    public static void init(IEventBus bus) {
        if (constructed) {
            throw new IllegalStateException("IntegrationLoader has already been initialized.");
        }
        constructed = true;
        construct();
        for (var pair : integrations) {
            if (IntegratedMods.isModLoaded(pair.getFirst())) {
                pair.getSecond().accept(bus);
            }
        }

        integrations.clear();
        integrations = null;
    }
}
