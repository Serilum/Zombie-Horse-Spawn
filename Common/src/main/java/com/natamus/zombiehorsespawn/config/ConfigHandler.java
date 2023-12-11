package com.natamus.zombiehorsespawn.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.zombiehorsespawn.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1.0) public static double chanceSurfaceZombieHasHorse = 0.05;
	@Entry public static boolean shouldBurnZombieHorsesInDaylight = true;
	@Entry public static boolean onlySpawnZombieHorsesOnSurface = true;

	public static void initConfig() {
		configMetaData.put("chanceSurfaceZombieHasHorse", Arrays.asList(
			"The chance a zombie that has spawned on the surface is riding a horse."
		));
		configMetaData.put("shouldBurnZombieHorsesInDaylight", Arrays.asList(
			"If enabled, burns zombie horses when daylight shines upon them."
		));
		configMetaData.put("onlySpawnZombieHorsesOnSurface", Arrays.asList(
			"If enabled, a zombie horse with rider will only spawn on the surface."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}