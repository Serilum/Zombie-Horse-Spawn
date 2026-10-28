package com.serilum.zombiehorsespawn.util;

import net.minecraft.world.entity.animal.equine.ZombieHorse;

public class Util {
	public static boolean isSpawnedByMod(ZombieHorse zombieHorse) {
		return zombieHorse.isTamed() && zombieHorse.getOwnerReference() == null;
	}
}
