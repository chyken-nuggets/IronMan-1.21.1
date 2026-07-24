package dev.chyken.ironmanarmormod.data;

import dev.chyken.ironmanarmormod.block.IronManBlocks;
import dev.chyken.ironmanarmormod.item.IronManItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class IronManRecipeProvider extends RecipeProvider {
    public IronManRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        oreSmelting(output, List.of(IronManItems.RAW_MAGNESIUM.get(), IronManBlocks.MAGNESIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.MAGNESIUM_INGOT.get(), 0.7F, 100, "magnesium");
        oreBlasting(output, List.of(IronManItems.RAW_MAGNESIUM.get(), IronManBlocks.MAGNESIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.MAGNESIUM_INGOT.get(), 0.7F, 50, "magnesium");
        oreSmelting(output, List.of(IronManItems.RAW_TITANIUM.get(), IronManBlocks.TITANIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.TITANIUM_INGOT.get(), 0.7F, 200, "titanium");
        oreBlasting(output, List.of(IronManItems.RAW_TITANIUM.get(), IronManBlocks.TITANIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.TITANIUM_INGOT.get(), 0.7F, 100, "titanium");
    }
}