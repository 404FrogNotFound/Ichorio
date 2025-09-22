package net.amagitsyne.ichorio.datagen;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.block.ModBlocks;
import net.amagitsyne.ichorio.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> ENDERIUM_SMELTABLES = List.of(ModItems.RAW_ENDERIUM,
                ModBlocks.ENDERIUM_ORE, ModBlocks.ENDERIUM_DEEPSLATE_ORE);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHERINE_BLOCK.get())
                .define('A', ModItems.NETHERINE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .unlockedBy("has_netherine", has(ModItems.NETHERINE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHERINE.get(), 9)
                .requires(ModBlocks.NETHERINE_BLOCK)
                .unlockedBy("has_netherine_block", has(ModBlocks.NETHERINE_BLOCK)).save(recipeOutput);
        oreSmelting(recipeOutput, ENDERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERIUM_INGOT, 0.25f, 200, "enderium_ingot");
        oreBlasting(recipeOutput, ENDERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERIUM_INGOT, 0.25f, 100, "enderium_ingot");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.smelting(
                            Ingredient.of(itemlike),
                            pCategory,
                            pResult.asItem(), // обязательно asItem()
                            pExperience,
                            pCookingTime
                    )
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Ichorio.MOD_ID + ":" + getItemName(pResult)
                            + "_from_smelting_" + getItemName(itemlike));
        }
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.blasting(
                            Ingredient.of(itemlike),
                            pCategory,
                            pResult.asItem(),
                            pExperience,
                            pCookingTime
                    )
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Ichorio.MOD_ID + ":" + getItemName(pResult)
                            + "_from_blasting_" + getItemName(itemlike));
        }

    }

    protected static void oreCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients,
                                     RecipeCategory pCategory, ItemLike pResult,
                                     float pExperience, int pCookingTime,
                                     String pGroup, String pRecipeName,
                                     boolean blasting) {
        for (ItemLike itemlike : pIngredients) {
            (blasting
                    ? SimpleCookingRecipeBuilder.blasting(
                    Ingredient.of(itemlike),
                    pCategory,
                    pResult.asItem(),
                    pExperience,
                    pCookingTime
            )
                    : SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(itemlike),
                    pCategory,
                    pResult.asItem(),
                    pExperience,
                    pCookingTime
            )
            )
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Ichorio.MOD_ID + ":" + getItemName(pResult)
                            + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}