package tv.tallstickman.betterpies;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TallStickMansBetterPies implements ModInitializer {

	// Activate the static members of the various classes of foods.
	public static final Fruits FRUITS = new Fruits();
	public static final Pies PIES = new Pies();
	public static final OtherFoods OTHER_FOODS = new OtherFoods();
	public static final IceCream ICE_CREAM = new IceCream();

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MODID_STRING);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.#
		// However, some things (like resources) may still be uninitialized.s
		// Proceed with mild caution.

		LOGGER.info("Growing new fruits...");
		Fruits.initialize();
		LOGGER.info("Baking up better pies...");
		Pies.initialize();
		LOGGER.info("Acquiring other new foods...");
		OtherFoods.initialize();
		LOGGER.info("Churning up ice cream...");
		IceCream.initialize();
	}

	// Factory methods for fruit items and blocks

	public static Block registerBlock(String name, Function<Block.Settings, Block> blockFactory, Block.Settings settings) {
		// Create the block key.
		RegistryKey<Block> blockKey = keyOfBlock(name);
		// Create the block instance
		Block block = blockFactory.apply(settings.registryKey(blockKey));

		return Registry.register(Registries.BLOCK, blockKey, block);
	}

	// Block registerBlockItem(String blockName, String itemName, Function<Block.Settings, Block> blockFactory, Block.Settings settings) {
	// 	return this.registerBlockItem(blockName, itemName, blockFactory, settings, true);
	// }

	public static Item registerBlockItem(String itemName, Block block, Item.Settings settings) {
			// Items need to be registered with a different type of registry key, but the ID
			// can be the same.
			RegistryKey<Item> itemKey = keyOfItem(itemName);

			BlockItem blockItem = new BlockItem(block, settings.registryKey(itemKey));
			return Registry.register(Registries.ITEM, itemKey, blockItem);
	}

	public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		// Create the item key.
		RegistryKey<Item> itemKey = keyOfItem(name);

		// Create the item instance.
		Item item = itemFactory.apply(settings.registryKey(itemKey));

		// Register the item.
		Registry.register(Registries.ITEM, itemKey, item);

		return item;
	}

	private static RegistryKey<Block> keyOfBlock(String name) {
		return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Constants.MODID_STRING, name));
	}

	private static RegistryKey<Item> keyOfItem(String name) {
		return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Constants.MODID_STRING, name));
	}

}