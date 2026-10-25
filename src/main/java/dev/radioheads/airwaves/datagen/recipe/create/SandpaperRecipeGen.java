package dev.radioheads.airwaves.datagen.recipe.create;

import com.simibubi.create.api.data.recipe.PolishingRecipeGen;
import dev.radioheads.airwaves.Airwaves;
import dev.radioheads.airwaves.registry.AirwaveItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class SandpaperRecipeGen extends PolishingRecipeGen {
    public SandpaperRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Airwaves.MOD_ID);
    }

    GeneratedRecipe POLISHED_AMETHYST = create("polished_amethyst", b -> b
            .require(Items.AMETHYST_SHARD)
            .output(AirwaveItems.POLISHED_AMETHYST)
    );
}
