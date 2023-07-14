package tv.tallstickman.betterpies;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IceCream {
    
    // Cheese used for making Cheesecake
	public static final FoodComponent VANILLA_ICE_CREAM_COMPONENT = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.3F).build();
	public static final Item VANILLA_ICE_CREAM_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_CHEESE_STRING), new DairyItem(new Item.Settings().maxCount(1).food(VANILLA_ICE_CREAM_COMPONENT)));

	public static void initialize()
	{
		// Add food items to the "Food and Drink" Item Group
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
			content.add(VANILLA_ICE_CREAM_ITEM);
		});
	}
}
