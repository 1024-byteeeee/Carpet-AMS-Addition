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

package club.mcams.carpet.mixin.rule.bambooModelNoOffset;

import club.mcams.carpet.AmsServerSettings;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.Vec3d;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(net.minecraft.block.AbstractBlock.AbstractBlockState.class)
public abstract class BambooBlockMixin implements AbstractBlockStateInvoker {
    @ModifyReturnValue(method = "getModelOffset", at = @At("RETURN"))
    public Vec3d getModelOffset(Vec3d original) {
        if (
            AmsServerSettings.bambooModelNoOffset &&
            (this.invokeGetBlock().equals(Blocks.BAMBOO) || this.invokeGetBlock().equals(Blocks.BAMBOO_SAPLING))
        ) {
            return Vec3d.ZERO;
        } else {
            return original;
        }
    }
}