package com.serilum.zombiehorsespawn.forge.events;

import com.serilum.zombiehorsespawn.events.ZombieHorseEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeZombieHorseEvent {
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
