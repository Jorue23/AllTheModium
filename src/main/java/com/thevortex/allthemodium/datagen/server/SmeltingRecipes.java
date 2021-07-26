package com.thevortex.allthemodium.datagen.server;


import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class SmeltingRecipes extends RecipeProvider {
    public SmeltingRecipes(DataGenerator generator) {
        super(generator);
    }
    private ResourceLocation recipeDir(String typeIn, String typeOut) {
        return new ResourceLocation(Reference.MOD_ID,typeIn + "_from_" + typeOut);
    }
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        final String hasCondition = "has_item";

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.RAW_ALLTHEMODIUM.get()),ModRegistry.ALLTHEMODIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_ALLTHEMODIUM.get()))
                .save(consumer,recipeDir("allthemodium_ingot","raw"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.RAW_VIBRANIUM.get()),ModRegistry.VIBRANIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_VIBRANIUM.get()))
                .save(consumer,recipeDir("vibranium_ingot","raw"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.RAW_UNOBTAINIUM.get()),ModRegistry.UNOBTAINIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.RAW_UNOBTAINIUM.get()))
                .save(consumer,recipeDir("unobtainium_ingot","raw"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.ALLTHEMODIUM_DUST.get()),ModRegistry.ALLTHEMODIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.ALLTHEMODIUM_DUST.get()))
                .save(consumer,recipeDir("allthemodium_ingot","dust"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.VIBRANIUM_DUST.get()),ModRegistry.VIBRANIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.VIBRANIUM_DUST.get()))
                .save(consumer,recipeDir("vibranium_ingot","dust"));

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModRegistry.UNOBTAINIUM_DUST.get()),ModRegistry.UNOBTAINIUM_INGOT.get(),0.15f,200)
                .unlockedBy(hasCondition,RecipeProvider.has(ModRegistry.UNOBTAINIUM_DUST.get()))
                .save(consumer,recipeDir("unobtainium_ingot","dust"));

    }
}