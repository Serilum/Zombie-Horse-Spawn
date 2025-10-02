package com.natamus.zombiehorsespawn.forge.events;

import com.natamus.zombiehorsespawn.events.ZombieHorseEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class ForgeZombieHorseEvent {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeZombieHorseEvent.class);
	}

	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		ZombieHorseEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
	
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post e) {
		Level level = e.level();
		if (level.isClientSide()) {
			return;
		}

		ZombieHorseEvent.onWorldTick((ServerLevel)level);
	}
}
