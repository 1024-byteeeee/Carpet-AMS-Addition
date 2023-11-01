/*
 * This file is part of the Carpet AMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  A Minecraft Server and contributors
 *
 * Carpet AMS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet AMS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet AMS Addition.  If not, see <https://www.gnu.org/licenses/>.
 */

package club.mcams.carpet.translations;

import club.mcams.carpet.util.Messenger;
import net.minecraft.text.BaseText;

@SuppressWarnings("unused")
public class Translator {
    private final String translationPath;

    public Translator getDerivedTranslator(String derivedName) {
        return new Translator(this.translationPath + "." + derivedName);
    }

    public Translator(String translationPath) {
        this.translationPath = translationPath;
    }

    public BaseText tr(String key, Object... args) {
        String translationKey = TranslationConstants.TRANSLATION_KEY_PREFIX + this.translationPath + "." + key;
        return Messenger.tr(translationKey, args);
    }
}
