/*
 * This file is part of the Carpet AMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024 A Minecraft Server and contributors
 *
 * Carpet AMS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet AMS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet AMS Addition. If not, see <https://www.gnu.org/licenses/>.
 */

package club.mcams.carpet.api.recipe;

import club.mcams.carpet.api.recipe.template.ShapedRecipeTemplate;
import club.mcams.carpet.api.recipe.template.ShapelessRecipeTemplate;
import club.mcams.carpet.api.recipe.template.SmeltingRecipeTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import com.mojang.serialization.JsonOps;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import top.byteeeee.annotationtoolbox.annotation.GameVersion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GameVersion(version = "Minecraft >= 1.21.2")
public class AmsRecipeManager {
    private final List<ShapelessRecipeTemplate> shapelessRecipes;
    private final List<ShapedRecipeTemplate> shapedRecipes;
    private final List<SmeltingRecipeTemplate> smeltingRecipes;

    public AmsRecipeManager(AmsRecipeBuilder builder) {
        this.shapelessRecipes = builder.getShapelessRecipeList();
        this.shapedRecipes = builder.getShapedRecipeList();
        this.smeltingRecipes = builder.getSmeltingRecipeList();
    }

    public void registerRecipes(Map<Identifier, Recipe<?>> map, RegistryWrapper.WrapperLookup wrapperLookup) {
        Map<Identifier, JsonElement> recipeMap = new HashMap<>();
        registerAllRecipes(recipeMap);
        recipeMap.forEach((id, json) -> addRecipe(map, wrapperLookup, id, json));
    }

    private void addRecipe(Map<Identifier, Recipe<?>> map, RegistryWrapper.WrapperLookup wrapperLookup, Identifier id, JsonElement json) {
        RecipeEntry<?> recipeEntry = this.deserializeRecipe(RegistryKey.of(RegistryKeys.RECIPE, id), json.getAsJsonObject(), wrapperLookup);
        map.put(id, recipeEntry.value());
    }

    private RecipeEntry<?> deserializeRecipe(RegistryKey<Recipe<?>> key, JsonObject json, RegistryWrapper.WrapperLookup registries) {
        return new RecipeEntry<>(key, Recipe.CODEC.parse(registries.getOps(JsonOps.INSTANCE), json).getOrThrow(JsonParseException::new));
    }

    private void registerAllRecipes(Map<Identifier, JsonElement> recipeMap) {
        shapelessRecipes.forEach(recipe -> recipe.addToRecipeMap(recipeMap));
        shapedRecipes.forEach(recipe -> recipe.addToRecipeMap(recipeMap));
        smeltingRecipes.forEach(recipe -> recipe.addToRecipeMap(recipeMap));
    }

    public static void clearRecipeListMemory(AmsRecipeBuilder amsRecipeBuilder) {
        amsRecipeBuilder.getShapedRecipeList().clear();
        amsRecipeBuilder.getShapelessRecipeList().clear();
        amsRecipeBuilder.getSmeltingRecipeList().clear();
    }
}
