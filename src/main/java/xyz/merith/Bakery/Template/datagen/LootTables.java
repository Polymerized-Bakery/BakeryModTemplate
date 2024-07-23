package xyz.merith.bakery.template.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import xyz.merith.bakery.template.SimpleBlocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class LootTables extends FabricBlockLootTableProvider {
    public LootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    /**
     * Implement this method to add block drops.
     *
     * <p>Use the range of {@link BlockLootTableGenerator#addDrop} methods to generate block drops.
     */
    @Override
    public void generate() {
        // Add Drops here
        addDrop(SimpleBlocks.BLOCK_CLEAR);
        addDrop(SimpleBlocks.BLOCK_SOLID);
    }

    /**
     * Return a new generator that applies the specified conditions to any loot table it receives,
     * and then forwards the loot tables to this generator.
     *
     * @param conditions
     */
    @Override
    public BlockLootTableGenerator withConditions(ResourceCondition... conditions) {
        return super.withConditions(conditions);
    }

    /**
     * Return a new exporter that applies the specified conditions to any loot table it receives.
     *
     * <p>For block loot tables, use {@link FabricBlockLootTableGenerator#withConditions} instead.
     *
     * @param exporter
     * @param conditions
     */
    @Override
    public BiConsumer<RegistryKey<LootTable>, LootTable.Builder> withConditions(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> exporter, ResourceCondition... conditions) {
        return super.withConditions(exporter, conditions);
    }
}
