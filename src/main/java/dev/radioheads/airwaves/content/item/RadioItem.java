package dev.radioheads.airwaves.content.item;

import dev.radioheads.airwaves.api.annotations.NothingNullByDefault;
import dev.radioheads.airwaves.api.item.Tunable;
import dev.radioheads.airwaves.api.radio.RadioBand;
import dev.radioheads.airwaves.api.registry.AirwaveRegistries;
import dev.radioheads.airwaves.api.util.ColorUtil;
import dev.radioheads.airwaves.registry.AirwaveDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

@NothingNullByDefault
public class RadioItem extends BlockItem implements Tunable {
    public RadioItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        var data = stack.get(AirwaveDataComponents.TUNING);
        if (data == null) return;
        RadioBand band = data.band().value();
        tooltipComponents.add(Component.literal(band.display(data.frequency(), AirwaveRegistries.RADIO_BAND_REGISTRY.getKey(band))).withColor(ColorUtil.colorFromTune(data)));
    }
}
