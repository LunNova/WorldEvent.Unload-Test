package me.nallar.unloadtest.minecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import me.nallar.unloadtest.Log;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

@SuppressWarnings ("WeakerAccess")
@Mod (modid = "UnloadTest", name = "UnloadTest", version = "1.0")
@NetworkMod (clientSideRequired = false, serverSideRequired = false)
public class UnloadTest {
	@Mod.Init
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onWorldLoad(WorldEvent.Load event) {
		logWorldEvent(event);
	}

	@ForgeSubscribe
	public void onWorldUnload(WorldEvent.Unload event) {
		logWorldEvent(event);
	}

	private void logWorldEvent(WorldEvent event) {
		Log.severe(event.getClass() + " fired for world " + Log.name(event.world) + " in thread " + Thread.currentThread().getName());
	}
}
