package tv.tallstickman.betterpies;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class Fruits {
    
    // Blueberries for blueberry pie.
	public static final Block BLUEBERRY_BUSH_BLOCK = new BlueberryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY).nonOpaque());
	public static final FoodComponent BLUEBERRIES_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).build();
	public static final Item BLUEBERRIES_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_BLUEBERRIES_STRING), new BlockItem(BLUEBERRY_BUSH_BLOCK, new Item.Settings().food(BLUEBERRIES_FOOD_COMPONENT)));

    // Cherries for cherry pie.
	public static final FoodComponent CHERRIES_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.3F).build();
	public static final Item CHERRIES_ITEM = Registry.register(Registries.ITEM, new Identifier(Constants.MODID_STRING, Constants.ITEM_CHERRIES_STRING), new Item(new Item.Settings().food(CHERRIES_FOOD_COMPONENT)));

}
