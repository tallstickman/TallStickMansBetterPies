package tv.tallstickman.betterpies;

import java.util.List;
import java.util.Optional;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class Fruits {

	// Blackberries for blackberry pie.
	// This block is initialized in the main mod initializer so that its declaration
	// here can be referenced by the related item here.
	public static final Block BLACKBERRY_BUSH_BLOCK = TallStickMansBetterPies.registerBlock(
			Constants.BLOCK_BLACKBERRY_BUSH_STRING,
			BlackberryBushBlock::new,
			AbstractBlock.Settings.create()
					.mapColor(MapColor.DARK_GREEN)
					.ticksRandomly()
					.noCollision()
					.sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
					.pistonBehavior(PistonBehavior.DESTROY)
					.nonOpaque());
	public static final FoodComponent BLACKBERRIES_FOOD_COMPONENT = (new FoodComponent.Builder())
			.nutrition(2)
			.saturationModifier(0.1F)
			.build();
	public static final Item BLACKBERRIES_ITEM = TallStickMansBetterPies.registerBlockItem(
			Constants.ITEM_BLACKBERRIES_STRING,
			BLACKBERRY_BUSH_BLOCK,
			new Item.Settings().food(BLACKBERRIES_FOOD_COMPONENT));

	// Blueberries for blueberry pie.
	// This block is initialized in the main mod initializer so that its declaration
	// here can be referenced by the related item here.
	public static final Block BLUEBERRY_BUSH_BLOCK = TallStickMansBetterPies.registerBlock(
			Constants.BLOCK_BLUEBERRY_BUSH_STRING,
			BlueberryBushBlock::new,
			AbstractBlock.Settings.create()
					.mapColor(MapColor.DARK_GREEN)
					.ticksRandomly()
					.noCollision()
					.sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
					.pistonBehavior(PistonBehavior.DESTROY)
					.nonOpaque());
	public static final FoodComponent BLUEBERRIES_FOOD_COMPONENT = (new FoodComponent.Builder())
			.nutrition(2)
			.saturationModifier(0.1F)
			.build();
	public static final Item BLUEBERRIES_ITEM = TallStickMansBetterPies.registerBlockItem(
			Constants.ITEM_BLUEBERRIES_STRING,
			BLUEBERRY_BUSH_BLOCK,
			new Item.Settings().food(BLUEBERRIES_FOOD_COMPONENT));

	// Cherries for cherry pie.
	public static final FoodComponent CHERRIES_FOOD_COMPONENT = (new FoodComponent.Builder())
			.nutrition(3)
			.saturationModifier(0.2F)
			.build();
	public static final Item CHERRIES_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_CHERRIES_STRING,
			Item::new,
			new Item.Settings().food(CHERRIES_FOOD_COMPONENT));

	// Peaches for peach pie.
	public static final FoodComponent PALE_PEACHES_FOOD_COMPONENT = (new FoodComponent.Builder())
			.nutrition(4)
			.saturationModifier(0.3F)
			.build();
	public static final Item PALE_PEACHES_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_PALE_PEACHES_STRING,
			Item::new,
			new Item.Settings().food(PALE_PEACHES_FOOD_COMPONENT));
			
	public static void initialize() {
		// Add cherry drops to the Minecraft Cherry Blossom Leaves block,
		// and peach drops to the Pale Oak Leaves block.
		final Optional<RegistryKey<LootTable>> CHERRY_LEAVES_LOOT_TABLE_ID = Blocks.CHERRY_LEAVES.getLootTableKey();
		final Optional<RegistryKey<LootTable>> PALE_OAK_LEAVES_LOOT_TABLE_ID = Blocks.PALE_OAK_LEAVES.getLootTableKey();
		// register event handler for modifying loot tables
		LootTableEvents.MODIFY.register((id, tableBuilder, source, wrapper) -> {
			// Add cherry drops to cherry leaves
			if (source.isBuiltin() && CHERRY_LEAVES_LOOT_TABLE_ID.isPresent()
					&& CHERRY_LEAVES_LOOT_TABLE_ID.get().equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(UniformLootNumberProvider.create(1, 3))
						.conditionally(RandomChanceLootCondition.builder(0.04F))
						.with(ItemEntry.builder(Fruits.CHERRIES_ITEM));

				tableBuilder.pool(poolBuilder.build());
			}
			// Add peach drops to pale oak leaves
			if (source.isBuiltin() && PALE_OAK_LEAVES_LOOT_TABLE_ID.isPresent()
					&& PALE_OAK_LEAVES_LOOT_TABLE_ID.get().equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(UniformLootNumberProvider.create(1, 1))
						.conditionally(RandomChanceLootCondition.builder(0.02F))
						.with(ItemEntry.builder(Fruits.PALE_PEACHES_ITEM));

				tableBuilder.pool(poolBuilder.build());
			}
		});

		// Register new fruits as compostable.
		CompostingChanceRegistry.INSTANCE.add(BLACKBERRIES_ITEM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(BLUEBERRIES_ITEM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(CHERRIES_ITEM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(PALE_PEACHES_ITEM, 0.3f);

		// Create and register berry patch terrain Features
		final List<RegistryKey<Biome>> BLUEBERRY_BIOMES = List.of(
				BiomeKeys.WINDSWEPT_GRAVELLY_HILLS,
				BiomeKeys.WINDSWEPT_HILLS,
				BiomeKeys.WINDSWEPT_FOREST,
				BiomeKeys.SNOWY_TAIGA,
				BiomeKeys.SNOWY_SLOPES,
				BiomeKeys.TAIGA,
				BiomeKeys.OLD_GROWTH_PINE_TAIGA,
				BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA);
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BLUEBERRY_BIOMES),
				GenerationStep.Feature.VEGETAL_DECORATION,
				RegistryKey.of(RegistryKeys.PLACED_FEATURE,
						Identifier.of(Constants.MODID_STRING, Constants.PLACED_FEATURE_BLUEBERRY_BUSH_PATCH_STRING)));
		final List<RegistryKey<Biome>> BLACKBERRY_BIOMES = List.of(
				BiomeKeys.SAVANNA,
				BiomeKeys.SAVANNA_PLATEAU,
				BiomeKeys.WINDSWEPT_SAVANNA,
				BiomeKeys.WOODED_BADLANDS);
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BLACKBERRY_BIOMES),
				GenerationStep.Feature.VEGETAL_DECORATION,
				RegistryKey.of(RegistryKeys.PLACED_FEATURE,
						Identifier.of(Constants.MODID_STRING, Constants.PLACED_FEATURE_BLACKBERRY_BUSH_PATCH_STRING)));

		// Add food items to the "Food and Drink" Item Group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			// Fruits
			content.add(Fruits.BLACKBERRIES_ITEM);
			content.add(Fruits.BLUEBERRIES_ITEM);
			content.add(Fruits.CHERRIES_ITEM);
			content.add(Fruits.PALE_PEACHES_ITEM);
		});

	}

}
