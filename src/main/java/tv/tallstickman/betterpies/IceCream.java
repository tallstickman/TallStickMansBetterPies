package tv.tallstickman.betterpies;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

public class IceCream {

	// Vanilla -- The original
	public static final FoodComponent VANILLA_ICE_CREAM_COMPONENT = (new FoodComponent.Builder())
			.nutrition(8)
			.saturationModifier(0.3F)
			.build();
	public static final Item VANILLA_ICE_CREAM_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_VANILLA_ICE_CREAM_STRING,
			Item::new,
			new Item.Settings().food(VANILLA_ICE_CREAM_COMPONENT));

	public static final FoodComponent BERRY_ICE_CREAM_COMPONENT = (new FoodComponent.Builder())
			.nutrition(8)
			.saturationModifier(0.3F)
			.build();
	public static final Item BERRY_CREAM_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_BERRY_ICE_CREAM_STRING,
			Item::new,
			new Item.Settings().food(BERRY_ICE_CREAM_COMPONENT));

	public static final FoodComponent CHOCOLATE_ICE_CREAM_COMPONENT = (new FoodComponent.Builder())
			.nutrition(8)
			.saturationModifier(0.3F)
			.build();
	public static final Item CHOCOLATE_ICE_CREAM_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_CHOCOLATE_ICE_CREAM_STRING,
			Item::new,
			new Item.Settings().food(CHOCOLATE_ICE_CREAM_COMPONENT));

	public static final FoodComponent NEAPOLITAN_ICE_CREAM_COMPONENT = (new FoodComponent.Builder())
			.nutrition(8)
			.saturationModifier(0.3F)
			.build();
	public static final Item NEAPOLITAN_ICE_CREAM_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_NEAPOLITAN_ICE_CREAM_STRING,
			Item::new,
			new Item.Settings().food(NEAPOLITAN_ICE_CREAM_COMPONENT));

	public static final FoodComponent COOKIES_AND_CREAM_ICE_CREAM_COMPONENT = (new FoodComponent.Builder())
			.nutrition(8)
			.saturationModifier(0.3F)
			.build();
	public static final Item COOKIES_AND_CREAM_ICE_CREAM_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_COOKIES_AND_CREAM_ICE_CREAM_STRING,
			Item::new,
			new Item.Settings().food(COOKIES_AND_CREAM_ICE_CREAM_COMPONENT));

	public static final FoodComponent MINT_CHIP_ICE_CREAM_COMPONENT = (new FoodComponent.Builder())
			.nutrition(8)
			.saturationModifier(0.3F)
			.build();
	public static final Item MINT_CHIP_ICE_CREAM_ITEM = TallStickMansBetterPies.registerItem(
			Constants.ITEM_MINT_CHIP_ICE_CREAM_STRING,
			Item::new,
			new Item.Settings().food(MINT_CHIP_ICE_CREAM_COMPONENT));

	public static void initialize() {
		// Add food items to the "Food and Drink" Item Group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.add(VANILLA_ICE_CREAM_ITEM);
			content.add(BERRY_CREAM_ITEM);
			content.add(CHOCOLATE_ICE_CREAM_ITEM);
			content.add(NEAPOLITAN_ICE_CREAM_ITEM);
			content.add(COOKIES_AND_CREAM_ICE_CREAM_ITEM);
			content.add(MINT_CHIP_ICE_CREAM_ITEM);
		});
	}
}
