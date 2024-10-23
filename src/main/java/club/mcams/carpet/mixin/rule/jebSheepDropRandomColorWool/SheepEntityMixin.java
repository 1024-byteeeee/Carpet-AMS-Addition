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

package club.mcams.carpet.mixin.rule.jebSheepDropRandomColorWool;

import club.mcams.carpet.AmsServerSettings;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.passive.SheepEntity;
//#if MC>=12102
//$$ import net.minecraft.item.ItemStack;
//$$ import net.minecraft.loot.LootTable;
//$$ import net.minecraft.registry.RegistryKey;
//$$ import java.util.function.BiConsumer;
//$$ import net.minecraft.server.world.ServerWorld;
//#endif
import net.minecraft.util.DyeColor;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin {
    //#if MC>=12102
    //$$ @WrapOperation(
    //$$     method = "sheared",
    //$$     at = @At(
    //$$         value = "INVOKE",
    //$$         target = "Lnet/minecraft/entity/passive/SheepEntity;forEachShearedItem(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/item/ItemStack;Ljava/util/function/BiConsumer;)V"
    //$$     )
    //$$ )
    //$$ private void redirectDropStack(SheepEntity sheepEntity, ServerWorld world, RegistryKey<LootTable> registryKey, ItemStack shears, BiConsumer<ServerWorld, ItemStack> consumer, Operation<Void> original) {
    //$$     if (AmsServerSettings.jebSheepDropRandomColorWool && isJebSheep(sheepEntity)) {
    //$$         Random random = new Random();
    //$$         for (int i = 0; i < 1 + random.nextInt(3); ++i) {
    //$$             DyeColor randomColor = DyeColor.values()[random.nextInt(DyeColor.values().length)];
    //$$             Block coloredWoolBlock = getWoolBlockFromColor(randomColor);
    //$$             consumer.accept(world, new ItemStack(coloredWoolBlock.asItem()));
    //$$         }
    //$$     } else {
    //$$         original.call(sheepEntity, world, registryKey, shears, consumer);
    //$$     }
    //$$ }
    //#else
    @WrapOperation(
        method = "sheared",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/passive/SheepEntity;getColor()Lnet/minecraft/util/DyeColor;"
        )
    )
    private DyeColor randomColor(SheepEntity sheepEntity, Operation<DyeColor> original) {
        if (AmsServerSettings.jebSheepDropRandomColorWool && isJebSheep(sheepEntity)) {
            Random random = new Random();
            return DyeColor.values()[random.nextInt(DyeColor.values().length)];
        } else {
            return original.call(sheepEntity);
        }
    }
    //#endif

    @Unique
    private static boolean isJebSheep(SheepEntity sheepEntity) {
        return sheepEntity.hasCustomName() && sheepEntity.getCustomName() != null && sheepEntity.getCustomName().getString().equals("jeb_");
    }

    @SuppressWarnings({"EnhancedSwitchMigration", "DuplicateBranchesInSwitch", "unused"})
    @Unique
    private static Block getWoolBlockFromColor(DyeColor color) {
        switch (color) {
            case WHITE: return Blocks.WHITE_WOOL;
            case ORANGE: return Blocks.ORANGE_WOOL;
            case MAGENTA: return Blocks.MAGENTA_WOOL;
            case LIGHT_BLUE: return Blocks.LIGHT_BLUE_WOOL;
            case YELLOW: return Blocks.YELLOW_WOOL;
            case LIME: return Blocks.LIME_WOOL;
            case PINK: return Blocks.PINK_WOOL;
            case GRAY: return Blocks.GRAY_WOOL;
            case LIGHT_GRAY: return Blocks.LIGHT_GRAY_WOOL;
            case CYAN: return Blocks.CYAN_WOOL;
            case PURPLE: return Blocks.PURPLE_WOOL;
            case BLUE: return Blocks.BLUE_WOOL;
            case BROWN: return Blocks.BROWN_WOOL;
            case GREEN: return Blocks.GREEN_WOOL;
            case RED: return Blocks.RED_WOOL;
            case BLACK: return Blocks.BLACK_WOOL;
            default: return Blocks.WHITE_WOOL;
        }
    }
}
