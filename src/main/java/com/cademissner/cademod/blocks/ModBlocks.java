package com.cademissner.cademod.blocks;

import com.cademissner.cademod.containers.FirstBlockContainer;
import com.cademissner.cademod.tileentites.FirstBlockTile;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

	@ObjectHolder("cademod:firstblock")
	public static FirstBlock FIRSTBLOCK;

	@ObjectHolder("cademod:firstblock")
	public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;

	@ObjectHolder("cademod:firstblock")
	public static ContainerType<FirstBlockContainer> FIRSTBLOCK_CONTAINER;
}
