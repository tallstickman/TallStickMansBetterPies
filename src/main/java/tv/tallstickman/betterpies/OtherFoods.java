package tv.tallstickman.betterpies;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class OtherFoods {
    
    // Cheese used for making Cheesecake
	public static final FoodComponent CHEESE_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).build();
	public static final Item CHEESE_ITEM = Registry.register(Registry.ITEM, Identifier.of(Constants.MODID_STRING, Constants.ITEM_CHEESE_STRING), new DairyItem(new Item.Settings().food(CHEESE_FOOD_COMPONENT).group(ItemGroup.FOOD)));

	public static void initialize()
	{
		// Pass
	}
}
