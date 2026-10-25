package dev.radioheads.airwaves.api.manager;

import dev.radioheads.airwaves.api.radio.RadioBand;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO
// Pretty much store sources of radio bands in areas
// So a block pos would know what bands are present there
// and other stuff
public final class RadioBandManager {
    private RadioBandManager() {}
//
//    private static final Map<ResourceKey<Level>, Map<BlockPos, List<RadioBand>>> RADIO_BANDS = new HashMap<>();
//
//    public static Map<BlockPos, List<RadioBand>> getRadioBands(ResourceKey<Level> level, BlockPos pos) {
//        if(!RADIO_BANDS.containsKey(level)) {
//            RADIO_BANDS.put(level, new HashMap<>());
//        }
//        return RADIO_BANDS.get(level);
//    }
//
//    public static void registerRadioBand(ResourceKey<Level> level, BlockPos pos, RadioBand radioBand) {
//        getRadioBands(level).put(pos, radioBand);
//    }
}
