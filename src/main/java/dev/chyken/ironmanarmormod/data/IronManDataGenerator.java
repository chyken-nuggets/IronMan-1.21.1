package dev.chyken.ironmanarmormod.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class IronManDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();

        generator.addProvider(
                event.includeServer(),
                new LootTableProvider(
                        output,
                        Set.of(),
                        List.of(new LootTableProvider.SubProviderEntry(
                                IronManBlockLootSubProvider::new,
                                LootContextParamSets.BLOCK
                        )),
                        event.getLookupProvider()
                )
        );

        generator.addProvider(
                includeClient,
                new IronManBlockStateProvider(output, existingFileHelper)
        );

        generator.addProvider(
                includeClient,
                new IronManItemModelProvider(output, existingFileHelper)
        );

        generator.addProvider(
                includeServer,
                new IronManRecipeProvider(output, lookupProvider)
        );

        generator.addProvider(
                includeServer,
                new IronManBlockTagsProvider(output, lookupProvider, existingFileHelper)
        );
    }
}