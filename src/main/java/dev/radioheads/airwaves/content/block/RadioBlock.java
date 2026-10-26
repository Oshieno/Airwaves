package dev.radioheads.airwaves.content.block;

import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class RadioBlock extends HorizontalKineticBlock {
    public RadioBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }
}
