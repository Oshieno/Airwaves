package dev.radioheads.airwaves.api.registry.board;

import dev.radioheads.airwaves.api.content.item.BoardItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public record BoardPart(Supplier<? extends BoardItem> item, boolean standalone) {}