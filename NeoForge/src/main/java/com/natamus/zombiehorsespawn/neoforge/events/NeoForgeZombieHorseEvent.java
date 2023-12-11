package com.natamus.zombiehorsespawn.neoforge.events;

import com.natamus.zombiehorsespawn.events.ZombieHorseEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.TickEvent.LevelTickEvent;
import net.neoforged.neoforge.event.TickEvent.Phase;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeZombieHorseEvent {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		ZombieHorseEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
	
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent e) {
		Level level = e.level;
		if (level.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}

		ZombieHorseEvent.onWorldTick((ServerLevel)level);
	}
}
