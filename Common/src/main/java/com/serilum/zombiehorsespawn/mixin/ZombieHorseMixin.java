package com.serilum.zombiehorsespawn.mixin;

import com.serilum.zombiehorsespawn.config.ConfigHandler;
import com.serilum.zombiehorsespawn.util.Util;
import net.minecraft.world.entity.animal.equine.ZombieHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ZombieHorse.class, priority = 1001)
public class ZombieHorseMixin {
	@Inject(method = "removeWhenFarAway(D)Z", at = @At(value = "HEAD"), cancellable = true)
	public void removeWhenFarAway(double distSqr, CallbackInfoReturnable<Boolean> cir) {
		if (ConfigHandler.zombieHorsesCanDespawn) {
			return;
		}

		if (Util.isSpawnedByMod((ZombieHorse)(Object)this)) {
			cir.setReturnValue(false);
		}
	}
}
