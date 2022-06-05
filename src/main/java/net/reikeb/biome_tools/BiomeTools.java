package net.reikeb.biome_tools;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.reikeb.biome_tools.commands.SetBiomeCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BiomeTools.MODID)
@Mod.EventBusSubscriber(modid = BiomeTools.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BiomeTools {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "biome_tools";

    public BiomeTools() {

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterCommand(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> commandDispatcher = event.getDispatcher();
        SetBiomeCommand.register(commandDispatcher);
    }
}
