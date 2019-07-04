package com.cademissner.cademod.setup;

import com.cademissner.cademod.blocks.ModBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

	public ItemGroup itemGroup = new ItemGroup("cademod") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.FIRSTBLOCK);
		}
	};

	public void init() {

	}
}
