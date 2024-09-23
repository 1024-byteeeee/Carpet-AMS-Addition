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

package club.mcams.carpet.api.recipe.template;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.util.Identifier;

import java.util.Map;

public interface RecipeTemplateInterface {
    JsonObject toJson();

    void addToRecipeMap(Map<Identifier, JsonElement> recipeMap);

    static String compatResultItemIdKey() {
        //#if MC>=12005
        //$$ return "id";
        //#else
        return "item";
        //#endif
    }
}
