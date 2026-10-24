package dev.radioheads.airwaves.integration;

import net.neoforged.fml.loading.LoadingModList;

import java.util.Locale;

public enum IntegratedMods {
    SABLE;

    public boolean isLoaded() {
        // English just in case
        return isModLoaded(name().toLowerCase(Locale.ENGLISH));
    }

    public static boolean isModLoaded(String modid) {
        return LoadingModList.get().getModFileById(modid) != null;
    }
}
