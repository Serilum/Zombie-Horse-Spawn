package com.natamus.zombiehorsespawn;

import com.natamus.collective.objects.SAMObject;
import com.natamus.zombiehorsespawn.config.ConfigHandler;
import net.minecraft.world.entity.EntityTypes;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		new SAMObject(EntityTypes.ZOMBIE, EntityTypes.ZOMBIE_HORSE, null, ConfigHandler.chanceSurfaceZombieHasHorse, false, true, ConfigHandler.onlySpawnZombieHorsesOnSurface);
	}
}