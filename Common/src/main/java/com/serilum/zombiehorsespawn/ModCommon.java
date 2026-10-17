package com.serilum.zombiehorsespawn;

import com.natamus.collective.globalcallbacks.ConfigCallback;
import com.natamus.collective.objects.SAMObject;
import com.serilum.zombiehorsespawn.config.ConfigHandler;
import com.serilum.zombiehorsespawn.util.Reference;
import net.minecraft.world.entity.EntityTypes;

public class ModCommon {
	private static SAMObject samObject;

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		samObject = new SAMObject(EntityTypes.ZOMBIE, EntityTypes.ZOMBIE_HORSE, null, ConfigHandler.chanceSurfaceZombieHasHorse, false, true, ConfigHandler.onlySpawnZombieHorsesOnSurface, false, false, Integer.MAX_VALUE);

		ConfigCallback.CONFIG_CHANGED.register((String modid) -> {
			if (!modid.equals(Reference.MOD_ID)) {
				return;
			}

			samObject.changeChance = ConfigHandler.chanceSurfaceZombieHasHorse;
			samObject.onlyOnSurface = ConfigHandler.onlySpawnZombieHorsesOnSurface;
		});
	}
}