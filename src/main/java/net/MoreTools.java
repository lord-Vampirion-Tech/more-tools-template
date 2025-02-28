package net;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.util.*;
import org.slf4j.*;

public class MoreTools implements ModInitializer {
	public static final String MOD_ID = "more_tools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CustomModItem.initialize();
		net.item.CustomModItemGroups.initialize();
		CustomModComponents.initialize();

		PlayerBlockBreakEvents.BEFORE.register(new CustomUsageEvent());

		ResourceManagerHelper.registerBuiltinResourcePack(
				Identifier.of(MOD_ID, "more_tools"),
				FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
				Text.translatable("resourcepack.more_tools.name"),
				ResourcePackActivationType.NORMAL
		);
	}
}