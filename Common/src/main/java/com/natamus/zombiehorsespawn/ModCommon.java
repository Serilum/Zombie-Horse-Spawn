package com.natamus.zombiehorsespawn;

import com.natamus.collective.objects.SAMObject;
import com.natamus.zombiehorsespawn.config.ConfigHandler;
import net.minecraft.world.entity.EntityType;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		new SAMObject(EntityType.ZOMBIE, EntityType.ZOMBIE_HORSE, null, ConfigHandler.chanceSurfaceZombieHasHorse, false, true, ConfigHandler.onlySpawnZombieHorsesOnSurface);
	}
}