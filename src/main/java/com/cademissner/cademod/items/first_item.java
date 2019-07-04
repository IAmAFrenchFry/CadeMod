package com.cademissner.cademod.items;

import com.cademissner.cademod.CadeMod;

import net.minecraft.item.Item;

public class first_item extends Item {

	public first_item() {
		super(new Item.Properties().maxStackSize(1).group(CadeMod.setup.itemGroup));
		setRegistryName("first_item");
	}
}
