package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("examplemod");

	public static final Block TEST_ORE = Registry.register(Registry.BLOCK, new Identifier("examplemod", "test_ore"), new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f)));
	public static ModContainer container = FabricLoader.getInstance().getModContainer("examplemod").get();
	public static FabricDataGenerator dataGenerator = new FabricDataGenerator(FabricLoader.getInstance().getConfigDir().resolve("examplemod"), container, true);

	@Override
	public void onInitialize() {

		LootTableProvider lootTableProvider = new LootTableProvider(LootContextTypes.CHEST, dataGenerator);
/*
		dataGenerator.addProvider(lootTableProvider);

		try {
			dataGenerator.run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/
	}
}
