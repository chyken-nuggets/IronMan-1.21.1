package dev.chyken.ironmanarmormod.data;

import dev.chyken.ironmanarmormod.block.IronManBlocks;
import dev.chyken.ironmanarmormod.item.IronManItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class IronManRecipeProvider extends RecipeProvider {
    public IronManRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IronManItems.PALLADIUM_ARC_REACTOR)
                .pattern("XUX")
                .pattern("UCU")
                .pattern("XUX")
                .define('X', Ingredient.of(Tags.Items.GLASS_BLOCKS))
                .define('U', Items.COPPER_INGOT)
                .define('C', IronManItems.PALLADIUM.get())
                .unlockedBy("has_anything", has(Items.AIR))
                .save(output);

        oreSmelting(output, List.of(IronManItems.RAW_MAGNESIUM.get(), IronManBlocks.MAGNESIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.MAGNESIUM_INGOT.get(), 0.7F, 100, "magnesium");
        oreBlasting(output, List.of(IronManItems.RAW_MAGNESIUM.get(), IronManBlocks.MAGNESIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.MAGNESIUM_INGOT.get(), 0.7F, 50, "magnesium");
        oreSmelting(output, List.of(IronManItems.RAW_TITANIUM.get(), IronManBlocks.TITANIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.TITANIUM_INGOT.get(), 0.7F, 200, "titanium");
        oreBlasting(output, List.of(IronManItems.RAW_TITANIUM.get(), IronManBlocks.TITANIUM_ORE.asItem()), RecipeCategory.MISC, IronManItems.TITANIUM_INGOT.get(), 0.7F, 100, "titanium");
    }
}