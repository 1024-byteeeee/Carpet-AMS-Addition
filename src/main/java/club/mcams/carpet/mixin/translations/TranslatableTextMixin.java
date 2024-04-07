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

package club.mcams.carpet.mixin.translations;

import club.mcams.carpet.translations.AMSTranslations;
import club.mcams.carpet.translations.TranslationConstants;

import net.minecraft.text.TranslatableText;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TranslatableText.class)
public abstract class TranslatableTextMixin {

    @Shadow
    @Final
    private String key;

    @ModifyArg(
        method = "updateTranslations",
        at = @At(
            value = "INVOKE",
            //#if MC<11800
            //$$ target = "Lnet/minecraft/text/TranslatableText;setTranslation(Ljava/lang/String;)V"
            //#else
            target = "Lnet/minecraft/text/TranslatableText;forEachPart(Ljava/lang/String;Ljava/util/function/Consumer;)V"
            //#endif
        )
    )
    private String applyAMSTranslation(String vanillaTranslatedFormattingString) {
        if (this.key.startsWith(TranslationConstants.TRANSLATION_KEY_PREFIX) && vanillaTranslatedFormattingString.equals(this.key)) {
            String amsTranslated = AMSTranslations.translateKeyToFormattedString(AMSTranslations.getServerLanguage(), this.key);
            if (amsTranslated != null) {
                return amsTranslated;
            }
        }
        return vanillaTranslatedFormattingString;
    }
}
