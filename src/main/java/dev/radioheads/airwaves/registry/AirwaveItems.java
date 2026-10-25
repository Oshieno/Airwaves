package dev.radioheads.airwaves.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import dev.radioheads.airwaves.Airwaves;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;

public final class AirwaveItems {
    private AirwaveItems() {}

    public static final ItemEntry<Item>
    POLISHED_AMETHYST = Airwaves.REGISTRATE.item("polished_amethyst", Item::new)
            .tag(Tags.Items.GEMS)
            .tag(Tags.Items.GEMS_AMETHYST)
            .register();

    public static void init() {}
}
