package com.serilum.zombiehorsespawn.config;

import com.natamus.collective.config.DuskConfig;
import com.serilum.zombiehorsespawn.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1.0) public static double chanceSurfaceZombieHasHorse = 0.05;
	@Entry public static boolean shouldBurnZombieHorsesInDaylight = true;
	@Entry public static boolean onlySpawnZombieHorsesOnSurface = true;
	@Entry(registry = "dimension") public static String dimensionsToSpawnIn = "";
	@Entry(registry = "worldgen/biome") public static String biomesToSpawnIn = "";

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
		configMetaData.put("dimensionsToSpawnIn", Arrays.asList(
			"Dimensions in which zombies can spawn riding a zombie horse, separated by a comma. Leave empty for every dimension. For example: 'minecraft:overworld'."
		));
		configMetaData.put("biomesToSpawnIn", Arrays.asList(
			"Biomes in which zombies can spawn riding a zombie horse, separated by a comma. Biome tags work too, starting with a '#'. Leave empty for every biome. For example: 'minecraft:plains,#minecraft:is_savanna'."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}