package tv.tallstickman.betterpies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TallStickMansBetterPies implements ModInitializer {

	// %%% MOD BLOCKS %%% //
	
	// %%% MOD ITEMS %%% //

	// Activate the static members of the various classes of foods.
	public static final Fruits FRUITS = new Fruits();
	public static final Pies PIES = new Pies();

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MODID_STRING);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.#
		// However, some things (like resources) may still be uninitialized.s
		// Proceed with mild caution.

		LOGGER.info("Baking up better pies.");

		// Add cherry drops to the Minecraft Cherry Blossom Leaves block.
		final Identifier CHERRY_LEAVES_LOOT_TABLE_ID = Blocks.CHERRY_LEAVES.getLootTableId();
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() && CHERRY_LEAVES_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
				.rolls(UniformLootNumberProvider.create(1, 3))
				.conditionally(RandomChanceLootCondition.builder(0.05F))
                .with(ItemEntry.builder(Fruits.CHERRIES_ITEM));
 
                tableBuilder.pool(poolBuilder.build());
		
            }
        });

		Registry.register(Registries.BLOCK, new Identifier(Constants.MODID_STRING, Constants.BLOCK_BLUEBERRY_BUSH_STRING), Fruits.BLUEBERRY_BUSH_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(Constants.MODID_STRING, Constants.BLOCK_BLACKBERRY_BUSH_STRING), Fruits.BLACKBERRY_BUSH_BLOCK);

	}
}