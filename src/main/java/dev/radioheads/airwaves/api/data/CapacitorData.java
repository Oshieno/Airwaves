package dev.radioheads.airwaves.api.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;

public record CapacitorData(int charge, int maxCharge) {
    public static final Codec<CapacitorData>  CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("charge", 0).forGetter(CapacitorData::charge),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("max_charge").forGetter(CapacitorData::maxCharge)
    ).apply(inst, CapacitorData::new));

    public static final StreamCodec<ByteBuf, CapacitorData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, CapacitorData::charge,
            ByteBufCodecs.VAR_INT, CapacitorData::maxCharge,
            CapacitorData::new
    );
}
