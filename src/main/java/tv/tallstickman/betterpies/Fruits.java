package tv.tallstickman.betterpies;

import java.util.List;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class Fruits {
    
    // Blackberries for blackberry pie.
	//   This block is initialized in the main mod initializer so that its declaration here can be referenced by the related item here.
	public static final Block BLACKBERRY_BUSH_BLOCK = new BlackberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY).nonOpaque());
	public static final FoodComponent BLACKBERRIES_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).build();
	public static final Item BLACKBERRIES_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_BLACKBERRIES_STRING), new BlockItem(BLACKBERRY_BUSH_BLOCK, new Item.Settings().food(BLACKBERRIES_FOOD_COMPONENT)));

    // Blueberries for blueberry pie.
	//   This block is initialized in the main mod initializer so that its declaration here can be referenced by the related item here.
	public static final Block BLUEBERRY_BUSH_BLOCK = new BlueberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY).nonOpaque());
	public static final FoodComponent BLUEBERRIES_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).build();
	public static final Item BLUEBERRIES_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_BLUEBERRIES_STRING), new BlockItem(BLUEBERRY_BUSH_BLOCK, new Item.Settings().food(BLUEBERRIES_FOOD_COMPONENT)));

    // Cherries for cherry pie.
	public static final FoodComponent CHERRIES_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.3F).build();
	public static final Item CHERRIES_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_CHERRIES_STRING), new Item(new Item.Settings().food(CHERRIES_FOOD_COMPONENT)));

	public static void initialize()
	{
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

		// Register new berry bush blocks.
		Registry.register(Registries.BLOCK, new Identifier(Constants.MODID_STRING, Constants.BLOCK_BLUEBERRY_BUSH_STRING), Fruits.BLUEBERRY_BUSH_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(Constants.MODID_STRING, Constants.BLOCK_BLACKBERRY_BUSH_STRING), Fruits.BLACKBERRY_BUSH_BLOCK);
		// Create and register berry patch terrain Features
		final List<RegistryKey<Biome>> BLUEBERRY_BIOMES = List.of(
			BiomeKeys.WINDSWEPT_GRAVELLY_HILLS,
			BiomeKeys.WINDSWEPT_HILLS,
			BiomeKeys.WINDSWEPT_FOREST,
			BiomeKeys.SNOWY_TAIGA,
			BiomeKeys.SNOWY_SLOPES,
			BiomeKeys.TAIGA,
			BiomeKeys.OLD_GROWTH_PINE_TAIGA,
			BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA
		);
        BiomeModifications.addFeature(
			BiomeSelectors.includeByKey(BLUEBERRY_BIOMES),
			GenerationStep.Feature.VEGETAL_DECORATION,
			RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Constants.MODID_STRING, Constants.PLACED_FEATURE_BLUEBERRY_BUSH_PATCH_STRING))
		);
		final List<RegistryKey<Biome>> BLACKBERRY_BIOMES = List.of(
			BiomeKeys.SAVANNA,
			BiomeKeys.SAVANNA_PLATEAU,
			BiomeKeys.WINDSWEPT_SAVANNA,
			BiomeKeys.WOODED_BADLANDS
		);
         BiomeModifications.addFeature(
			BiomeSelectors.includeByKey(BLACKBERRY_BIOMES),
			GenerationStep.Feature.VEGETAL_DECORATION,
			RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Constants.MODID_STRING, Constants.PLACED_FEATURE_BLACKBERRY_BUSH_PATCH_STRING))
		);

		// Add food items to the "Food and Drink" Item Group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			// Fruits
			content.add(Fruits.BLACKBERRIES_ITEM);
			content.add(Fruits.BLUEBERRIES_ITEM);
			content.add(Fruits.CHERRIES_ITEM);
		});
	}
}
