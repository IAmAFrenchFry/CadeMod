package com.cademissner.cademod.blocks;

import com.cademissner.cademod.tileentites.FirstBlockTile;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

	@ObjectHolder("cademod:firstblock")
	public static FirstBlock FIRSTBLOCK;

	@ObjectHolder("cademod:firstblock")
	public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;
}
