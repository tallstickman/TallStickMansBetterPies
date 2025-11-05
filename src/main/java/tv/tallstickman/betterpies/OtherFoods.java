package tv.tallstickman.betterpies;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

public class OtherFoods {
    
    // Cheese used for making Cheesecake
	public static final FoodComponent CHEESE_FOOD_COMPONENT = (new FoodComponent.Builder())
	.nutrition(4)
	.saturationModifier(0.6F)
	.build();
	public static final Item CHEESE_ITEM = TallStickMansBetterPies.registerItem(
		Constants.ITEM_CHEESE_STRING,
		DairyItem::new,
		new Item.Settings().food(CHEESE_FOOD_COMPONENT));

	public static void initialize()
	{
		// Add food items to the "Food and Drink" Item Group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.add(CHEESE_ITEM);
		});
	}
}
