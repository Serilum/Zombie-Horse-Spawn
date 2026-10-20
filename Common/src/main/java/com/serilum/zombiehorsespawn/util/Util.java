package com.serilum.zombiehorsespawn.util;

import net.minecraft.world.entity.animal.horse.ZombieHorse;

public class Util {
	public static boolean isUnclaimedModHorse(ZombieHorse zombieHorse) {
		if (!zombieHorse.isTamed() || zombieHorse.getOwnerUUID() != null) {
			return false;
		}
		return !zombieHorse.isSaddled();
	}
}
