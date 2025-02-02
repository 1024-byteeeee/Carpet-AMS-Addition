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

package club.mcams.carpet.mixin.rule.maxPlayerInteractionRange;

import club.mcams.carpet.AmsServerSettings;
import club.mcams.carpet.translations.Translator;
import club.mcams.carpet.utils.Messenger;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.AttributeCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Formatting;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import top.byteeeee.annotationtoolbox.annotation.GameVersion;

@GameVersion(version = "Minecraft >= 1.20.5")
@Mixin(value = AttributeCommand.class, priority = 1688)
public abstract class AttributeCommandMixin {

    @Unique
    private static final Translator translator = new Translator("rule");

    @Unique
    private static final String MSG_HEAD = "<Carpet AMS Addition> ";

    @WrapOperation(
        method = "executeBaseValueSet",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/attribute/EntityAttributeInstance;setBaseValue(D)V"
        )
    )
    private static void disableBlockInteractionRangeSet(EntityAttributeInstance instance, double baseValue, Operation<Void> original, ServerCommandSource source) {
        if (AmsServerSettings.maxPlayerBlockInteractionRange != -1.0D && instance.getAttribute().equals(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE)) {
            PlayerEntity player = source.getPlayer();
            if (player != null) {
                player.sendMessage(
                    Messenger.s(
                        MSG_HEAD + translator.tr("maxPlayerBlockInteractionRange.disable_command").getString()
                    ).formatted(Formatting.RED), false
                );
            }
        } else {
            original.call(instance, baseValue);
        }
    }

    @WrapOperation(
        method = "executeBaseValueSet",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/attribute/EntityAttributeInstance;setBaseValue(D)V"
        )
    )
    private static void disableEntityInteractionRangeSet(EntityAttributeInstance instance, double baseValue, Operation<Void> original, ServerCommandSource source) {
        if (AmsServerSettings.maxPlayerEntityInteractionRange != -1.0D && instance.getAttribute().equals(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE)) {
            PlayerEntity player = source.getPlayer();
            if (player != null) {
                player.sendMessage(
                    Messenger.s(
                        MSG_HEAD + translator.tr("maxPlayerEntityInteractionRange.disable_command").getString()
                    ).formatted(Formatting.RED), false
                );
            }
        } else {
            original.call(instance, baseValue);
        }
    }
}
