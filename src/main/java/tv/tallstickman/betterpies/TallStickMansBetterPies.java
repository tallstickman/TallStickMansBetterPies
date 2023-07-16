package tv.tallstickman.betterpies;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TallStickMansBetterPies implements ModInitializer {

	// Activate the static members of the various classes of foods.
	public static final Fruits FRUITS          = new Fruits();
	public static final Pies PIES              = new Pies();
	public static final OtherFoods OTHER_FOODS = new OtherFoods();
	public static final IceCream ICE_CREAM     = new IceCream();

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MODID_STRING);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.#
		// However, some things (like resources) may still be uninitialized.s
		// Proceed with mild caution.


		LOGGER.info("Growing new fruits...");
		Fruits.initialize();
		LOGGER.info("Baking up better pies...");
		Pies.initialize();
		LOGGER.info("Acquiring other new foods...");
		OtherFoods.initialize();
		LOGGER.info("Churning up ice cream...");
		IceCream.initialize();
	}
}