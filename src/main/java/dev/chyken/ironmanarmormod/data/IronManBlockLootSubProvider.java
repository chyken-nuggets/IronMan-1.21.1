package dev.chyken.ironmanarmormod.data;

import dev.chyken.ironmanarmormod.block.IronManBlocks;
import dev.chyken.ironmanarmormod.item.IronManItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Collections;

public class IronManBlockLootSubProvider extends BlockLootSubProvider {
    protected IronManBlockLootSubProvider(HolderLookup.Provider registries) {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.add(
                IronManBlocks.MAGNESIUM_ORE.get(),
                block -> createOreDrop(
                        block,
                        IronManItems.RAW_MAGNESIUM.get()
                )
        );

        this.add(
                IronManBlocks.TITANIUM_ORE.get(),
                block -> createOreDrop(
                        block,
                        IronManItems.RAW_TITANIUM.get()
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return IronManBlocks.BLOCKS.getEntries().stream().map(holder -> (Block) holder.value())::iterator;
    }
}