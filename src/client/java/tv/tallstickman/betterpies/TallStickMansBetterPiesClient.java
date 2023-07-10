package tv.tallstickman.betterpies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class TallStickMansBetterPiesClient implements ClientModInitializer {

	// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	@Override
	public void onInitializeClient() {
		// Make it so the transparency in the texture is rendered as clear, not black.
		BlockRenderLayerMap.INSTANCE.putBlock(Fruits.BLUEBERRY_BUSH_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(Fruits.BLACKBERRY_BUSH_BLOCK, RenderLayer.getCutout());
	}
}