package com.cademissner.cademod.blocks;

import com.cademissner.cademod.tileentites.first_blockTile;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

	@ObjectHolder("cademod:first_block")
	public static first_block FIRSTBLOCK;

	@ObjectHolder("cademod:first_block")
	public static TileEntityType<first_blockTile> FIRSTBLOCK_TILE;
}
