package com.cademissner.cademod.items;

import com.cademissner.cademod.CadeMod;

import net.minecraft.item.Item;

public class FirstItem extends Item {

	public FirstItem() {
		super(new Item.Properties().maxStackSize(1).group(CadeMod.setup.itemGroup));
		setRegistryName("firstitem");
	}
}
