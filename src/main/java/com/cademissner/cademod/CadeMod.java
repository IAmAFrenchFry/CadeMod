package com.cademissner.cademod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cademissner.cademod.blocks.FirstBlock;
import com.cademissner.cademod.blocks.ModBlocks;
import com.cademissner.cademod.containers.FirstBlockContainer;
import com.cademissner.cademod.items.FirstItem;
import com.cademissner.cademod.setup.ClientProxy;
import com.cademissner.cademod.setup.IProxy;
import com.cademissner.cademod.setup.ModSetup;
import com.cademissner.cademod.setup.ServerProxy;
import com.cademissner.cademod.tileentites.FirstBlockTile;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cademod")
public class CadeMod {

	public static final String MODID = "cademod";

	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

	public static ModSetup setup = new ModSetup();

	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

	public CadeMod() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}

	private void setup(final FMLCommonSetupEvent event) {
		setup.init();
		proxy.init();
	}

	// You can use EventBusSubscriber to automatically subscribe events on the
	// contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
			event.getRegistry().register(new FirstBlock());
		}

		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
			Item.Properties properties = new Item.Properties().group(setup.itemGroup);
			event.getRegistry().register(new BlockItem(ModBlocks.FIRSTBLOCK, properties).setRegistryName("firstblock"));
			event.getRegistry().register(new FirstItem());
		}

		@SubscribeEvent
		public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
//			TileEntityType.Builder.func_223042_a() is obfusticated. It is the same as TileEntityType.Builder.create()
			event.getRegistry().register(TileEntityType.Builder.func_223042_a(FirstBlockTile::new, ModBlocks.FIRSTBLOCK)
					.build(null).setRegistryName("firstblock"));
		}

		public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new FirstBlockContainer(windowId, CadeMod.proxy.getClientWorld(), pos, inv,
						CadeMod.proxy.getClientPlayer());
			}).setRegistryName("firstblock"));
		}
	}
}
