package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ExampleModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ExampleMod.LOGGER.info("Attempting to create a provider");
        BlockLootTableProvider test = new BlockLootTableProvider(ExampleMod.dataGenerator);
    }
}
