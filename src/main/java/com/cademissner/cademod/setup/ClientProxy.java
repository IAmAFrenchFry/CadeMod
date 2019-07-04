package com.cademissner.cademod.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
