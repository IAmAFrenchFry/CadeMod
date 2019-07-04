package com.cademissner.cademod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cademissner.cademod.blocks.ModBlocks;
import com.cademissner.cademod.blocks.first_block;
import com.cademissner.cademod.items.first_item;
import com.cademissner.cademod.setup.ClientProxy;
import com.cademissner.cademod.setup.IProxy;
import com.cademissner.cademod.setup.ModSetup;
import com.cademissner.cademod.setup.ServerProxy;
import com.cademissner.cademod.tileentites.first_blockTile;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cademod")
public class CadeMod {

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
			event.getRegistry().register(new first_block());
		}

		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
			Item.Properties properties = new Item.Properties().group(setup.itemGroup);
			event.getRegistry()
					.register(new BlockItem(ModBlocks.FIRSTBLOCK, properties).setRegistryName("first_block"));
			event.getRegistry().register(new first_item());
		}

		@SubscribeEvent
		public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
			event.getRegistry().register(TileEntityType.Builder.create(first_blockTile::new, ModBlocks.FIRSTBLOCK)
					.build(null).setRegistryName("first_block"));
		}
	}
}
