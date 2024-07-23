package tv.tallstickman.betterpies;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class IceCream {
    
    // Vanilla -- The original
	public static final FoodComponent VANILLA_ICE_CREAM_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item VANILLA_ICE_CREAM_ITEM = Registry.register(
		Registry.ITEM,
		Identifier.of(Constants.MODID_STRING, Constants.ITEM_VANILLA_ICE_CREAM_STRING),
		new Item(new Item.Settings().food(VANILLA_ICE_CREAM_COMPONENT).group(ItemGroup.FOOD))
	);

	public static final FoodComponent BERRY_ICE_CREAM_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item BERRY_CREAM_ITEM = Registry.register(
		Registry.ITEM,
		Identifier.of(Constants.MODID_STRING, Constants.ITEM_BERRY_ICE_CREAM_STRING),
		new Item(new Item.Settings().food(BERRY_ICE_CREAM_COMPONENT).group(ItemGroup.FOOD))
	);

	public static final FoodComponent CHOCOLATE_ICE_CREAM_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item CHOCOLATE_ICE_CREAM_ITEM = Registry.register(
		Registry.ITEM,
		Identifier.of(Constants.MODID_STRING, Constants.ITEM_CHOCOLATE_ICE_CREAM_STRING),
		new Item(new Item.Settings().food(CHOCOLATE_ICE_CREAM_COMPONENT).group(ItemGroup.FOOD))
	);

	public static final FoodComponent NEAPOLITAN_ICE_CREAM_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item NEAPOLITAN_ICE_CREAM_ITEM = Registry.register(
		Registry.ITEM,
		Identifier.of(Constants.MODID_STRING, Constants.ITEM_NEAPOLITAN_ICE_CREAM_STRING),
		new Item(new Item.Settings().food(NEAPOLITAN_ICE_CREAM_COMPONENT).group(ItemGroup.FOOD))
	);

	public static final FoodComponent COOKIES_AND_CREAM_ICE_CREAM_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item COOKIES_AND_CREAM_ICE_CREAM_ITEM = Registry.register(
		Registry.ITEM,
		Identifier.of(Constants.MODID_STRING, Constants.ITEM_COOKIES_AND_CREAM_ICE_CREAM_STRING),
		new Item(new Item.Settings().food(COOKIES_AND_CREAM_ICE_CREAM_COMPONENT).group(ItemGroup.FOOD))
	);

	public static final FoodComponent MINT_CHIP_ICE_CREAM_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item MINT_CHIP_ICE_CREAM_ITEM = Registry.register(
		Registry.ITEM,
		Identifier.of(Constants.MODID_STRING, Constants.ITEM_MINT_CHIP_ICE_CREAM_STRING),
		new Item(new Item.Settings().food(MINT_CHIP_ICE_CREAM_COMPONENT).group(ItemGroup.FOOD))
	);

	public static void initialize()
	{
		// Pass
	}
}
