package com.cademissner.cademod.tileentites;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import static com.cademissner.cademod.blocks.ModBlocks.FIRSTBLOCK_TILE;

public class first_blockTile extends TileEntity implements ITickableTileEntity {

	public first_blockTile() {
		super(FIRSTBLOCK_TILE);
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			System.out.println("first_blockTile.tick");
		}

	}

}
