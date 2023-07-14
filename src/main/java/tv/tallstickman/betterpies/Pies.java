package tv.tallstickman.betterpies;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Pies {
    
	// Apple Pie!
	public static final FoodComponent APPLE_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item APPLE_PIE_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_APPLE_PIE_STRING), new Item(new Item.Settings().food(APPLE_PIE_FOOD_COMPONENT)));

	// Berry Pie!
	public static final FoodComponent BERRY_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item BERRY_PIE_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_BERRY_PIE_STRING), new Item(new Item.Settings().food(BERRY_PIE_FOOD_COMPONENT)));

	// Blackberry Pie!
	public static final FoodComponent BLACKBERRY_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item BLACKBERRY_PIE_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_BLACKBERRY_PIE_STRING), new Item(new Item.Settings().food(BLACKBERRY_PIE_FOOD_COMPONENT)));

	// Blueberry Pie!
	public static final FoodComponent BLUEBERRY_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item BLUEBERRY_PIE_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_BLUEBERRY_PIE_STRING), new Item(new Item.Settings().food(BLUEBERRY_PIE_FOOD_COMPONENT)));

	// Cherry Pie!
	public static final FoodComponent CHERRY_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item CHERRY_PIE_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_CHERRY_PIE_STRING), new Item(new Item.Settings().food(CHERRY_PIE_FOOD_COMPONENT)));

	// Mud Pie!
	public static final FoodComponent MUD_PIE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item MUD_PIE_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_MUD_PIE_STRING), new Item(new Item.Settings().food(MUD_PIE_FOOD_COMPONENT)));

	// Cheesecake!
	public static final FoodComponent CHEESECAKE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item CHEESECAKE_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_CHEESECAKE_STRING), new Item(new Item.Settings().food(CHEESECAKE_FOOD_COMPONENT)));

	public static void initialize()
	{
		// Add food items to the "Food and Drink" Item Group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.add(Pies.APPLE_PIE_ITEM);
			content.add(Pies.BLACKBERRY_PIE_ITEM);
			content.add(Pies.BLUEBERRY_PIE_ITEM);
			content.add(Pies.CHERRY_PIE_ITEM);
			content.add(Pies.MUD_PIE_ITEM);
			content.add(Pies.BERRY_PIE_ITEM);	// These are "Sweet Berry Pies," so we place them alphabetically after "Mud Pies."
		});
	}
}
