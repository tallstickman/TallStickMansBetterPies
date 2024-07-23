package tv.tallstickman.betterpies;

import java.util.List;
import java.util.Set;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class Fruits {
    
    // Blackberries for blackberry pie.
	//   This block is initialized in the main mod initializer so that its declaration here can be referenced by the related item here.
	// public static final Block BLACKBERRY_BUSH_BLOCK = new BlackberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY).nonOpaque());
	public static final Block BLACKBERRY_BUSH_BLOCK = new BlackberryBushBlock(AbstractBlock.Settings.of(Material.PLANT, MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
	public static final FoodComponent BLACKBERRIES_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).snack().build();
	public static final Item BLACKBERRIES_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_BLACKBERRIES_STRING), new BlockItem(BLACKBERRY_BUSH_BLOCK, new Item.Settings().food(BLACKBERRIES_FOOD_COMPONENT).group(ItemGroup.FOOD)));

    // Blueberries for blueberry pie.
	//   This block is initialized in the main mod initializer so that its declaration here can be referenced by the related item here.
	public static final Block BLUEBERRY_BUSH_BLOCK = new BlueberryBushBlock(AbstractBlock.Settings.of(Material.PLANT, MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
	public static final FoodComponent BLUEBERRIES_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).snack().build();
	public static final Item BLUEBERRIES_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_BLUEBERRIES_STRING), new BlockItem(BLUEBERRY_BUSH_BLOCK, new Item.Settings().food(BLUEBERRIES_FOOD_COMPONENT).group(ItemGroup.FOOD)));
	
	public static void initialize()
	{
		// Register new berry bush blocks.
		Registry.register(Registry.BLOCK, Identifier.of(Constants.MODID_STRING, Constants.BLOCK_BLUEBERRY_BUSH_STRING), Fruits.BLUEBERRY_BUSH_BLOCK);
		Registry.register(Registry.BLOCK, Identifier.of(Constants.MODID_STRING, Constants.BLOCK_BLACKBERRY_BUSH_STRING), Fruits.BLACKBERRY_BUSH_BLOCK);
		
		// Register new fruits as compostable.
		CompostingChanceRegistry.INSTANCE.add(BLACKBERRIES_ITEM, 0.3f);
		CompostingChanceRegistry.INSTANCE.add(BLUEBERRIES_ITEM, 0.3f);

		Set<Identifier> itemKeys = Registry.ITEM.getIds();

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
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Identifier.of(Constants.MODID_STRING, Constants.PLACED_FEATURE_BLUEBERRY_BUSH_PATCH_STRING))
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
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, Identifier.of(Constants.MODID_STRING, Constants.PLACED_FEATURE_BLACKBERRY_BUSH_PATCH_STRING))
		);
	}
}
