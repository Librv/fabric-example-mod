package net.fabricmc.example;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.function.BiConsumer;

public class LootTableProvider extends SimpleFabricLootTableProvider {

    public LootTableProvider(LootContextType lootContextType, FabricDataGenerator generator) {
        super(generator, lootContextType);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> biConsumer) {
        biConsumer.accept(new Identifier("examplemod", "chests/example_loot"), LootTable.builder().pool(
                LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.DIAMOND)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND_SWORD))
                        .apply(EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(20.0F, 39.0F))))
        );

        //biConsumer.accept(new Identifier("examplemod", "blocks/test_ore"), BlockLootTableGenerator.drops(ExampleMod.TEST_ORE));
    }

    @Override
    public String getName() {
        return "Loot Table " + Objects.requireNonNull(LootContextTypes.getId(lootContextType), "Could not get id for loot context type");
    }
}
