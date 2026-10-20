package com.serilum.zombiehorsespawn.mixin;

import com.serilum.zombiehorsespawn.config.ConfigHandler;
import com.serilum.zombiehorsespawn.util.Util;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Animal.class, priority = 1001)
public class AnimalMixin {
	@Inject(method = "removeWhenFarAway(D)Z", at = @At(value = "HEAD"), cancellable = true)
	public void removeWhenFarAway(double distanceToClosestPlayer, CallbackInfoReturnable<Boolean> cir) {
		if (!ConfigHandler.zombieHorsesCanDespawn) {
			return;
		}

		if (!((Object)this instanceof ZombieHorse zombieHorse)) {
			return;
		}

		if (Util.isUnclaimedModHorse(zombieHorse)) {
			cir.setReturnValue(true);
		}
	}
}
