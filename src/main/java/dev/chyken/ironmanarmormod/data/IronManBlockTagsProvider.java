package dev.chyken.ironmanarmormod.data;

import dev.chyken.ironmanarmormod.IronManArmorMod;
import dev.chyken.ironmanarmormod.block.IronManBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class IronManBlockTagsProvider extends BlockTagsProvider {
    public IronManBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IronManArmorMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(IronManBlocks.MAGNESIUM_ORE.get(), IronManBlocks.TITANIUM_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(IronManBlocks.MAGNESIUM_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(IronManBlocks.TITANIUM_ORE.get());
    }
}
