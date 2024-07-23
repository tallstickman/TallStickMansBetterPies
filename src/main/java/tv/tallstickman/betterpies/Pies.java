package tv.tallstickman.betterpies;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class Pies {
    
	// Apple Pie!
	public static final FoodComponent APPLE_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item APPLE_PIE_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_APPLE_PIE_STRING), new Item(new Item.Settings().food(APPLE_PIE_FOOD_COMPONENT).group(ItemGroup.FOOD)));

	// Berry Pie!
	public static final FoodComponent BERRY_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item BERRY_PIE_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_BERRY_PIE_STRING), new Item(new Item.Settings().food(BERRY_PIE_FOOD_COMPONENT).group(ItemGroup.FOOD)));

	// Blackberry Pie!
	public static final FoodComponent BLACKBERRY_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item BLACKBERRY_PIE_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_BLACKBERRY_PIE_STRING), new Item(new Item.Settings().food(BLACKBERRY_PIE_FOOD_COMPONENT).group(ItemGroup.FOOD)));

	// Blueberry Pie!
	public static final FoodComponent BLUEBERRY_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item BLUEBERRY_PIE_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_BLUEBERRY_PIE_STRING), new Item(new Item.Settings().food(BLUEBERRY_PIE_FOOD_COMPONENT).group(ItemGroup.FOOD)));

	// Mud Pie!
	public static final FoodComponent MUD_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item MUD_PIE_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_MUD_PIE_STRING), new Item(new Item.Settings().food(MUD_PIE_FOOD_COMPONENT).group(ItemGroup.FOOD)));

	// Cheesecake!
	public static final FoodComponent CHEESECAKE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item CHEESECAKE_ITEM = Registry.register(
		Registry.ITEM,
		Identifier.of(Constants.MODID_STRING, Constants.ITEM_CHEESECAKE_STRING),
		new DairyItem(new Item.Settings().food(CHEESECAKE_FOOD_COMPONENT).group(ItemGroup.FOOD))
	);

	public static void initialize()
	{
		// Register fruit pies as compostable.
		CompostingChanceRegistry.INSTANCE.add(APPLE_PIE_ITEM, 1.0f);
		CompostingChanceRegistry.INSTANCE.add(BERRY_PIE_ITEM, 1.0f);
		CompostingChanceRegistry.INSTANCE.add(BLACKBERRY_PIE_ITEM, 1.0f);
		CompostingChanceRegistry.INSTANCE.add(BLUEBERRY_PIE_ITEM, 1.0f);
	}
}
