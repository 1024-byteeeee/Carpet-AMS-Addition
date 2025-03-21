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

package club.mcams.carpet.mixin.rule.sendPlayerDeathLocation;

import club.mcams.carpet.AmsServerSettings;
import club.mcams.carpet.utils.MinecraftServerUtil;
import club.mcams.carpet.helpers.rule.sendPlayerDeathLocation.PlayerDeathLocationContext;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin implements ServerPlayerEntityInvoker {
    @Inject(method = "onDeath", at = @At("TAIL"))
    private void sendDeathLocation(CallbackInfo ci) {
        if (!Objects.equals(AmsServerSettings.sendPlayerDeathLocation, "false")) {
            MinecraftServer server = MinecraftServerUtil.getServer();
            ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
            World world = this.invokeGetWorld();
            switch (AmsServerSettings.sendPlayerDeathLocation) {
                case "all":
                    PlayerDeathLocationContext.sendMessage(server, player, world);
                    break;
                case "realPlayerOnly":
                    PlayerDeathLocationContext.realPlayerSendMessage(server, player, world);
                    break;
                case "fakePlayerOnly":
                    PlayerDeathLocationContext.fakePlayerSendMessage(server, player, world);
                    break;
            }
        }
    }
}
