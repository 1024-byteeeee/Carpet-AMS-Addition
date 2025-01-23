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

package club.mcams.carpet.helpers.rule.blockChunkLoader;

import club.mcams.carpet.AmsServerSettings;

import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.ChunkPos;

import top.byteeeee.annotationtoolbox.annotation.GameVersion;

import java.util.Comparator;

@GameVersion(version = "Minecraft < 1.21.5")
public class BlockChunkLoaderHelper {
    public static String TICKET_NAMESPACE = "carpetamsaddition";
    public static final ChunkTicketType<ChunkPos> NOTE_BLOCK_TICKET_TYPE = createChunkTicketType(
        String.format("%s:note_block_loader", TICKET_NAMESPACE)
    );
    private static final ChunkTicketType<ChunkPos> PISTON_BLOCK_TICKET_TYPE = createChunkTicketType(
        String.format("%s:piston_block_loader", TICKET_NAMESPACE)
    );
    private static final ChunkTicketType<ChunkPos> BELL_BLOCK_TICKET_TYPE = createChunkTicketType(
        String.format("%s:bell_block_loader", TICKET_NAMESPACE)
    );

    public static void addNoteBlockTicket(ServerWorld world, ChunkPos chunkPos) {
        addTicket(world, chunkPos, NOTE_BLOCK_TICKET_TYPE);
    }

    public static void addPistonBlockTicket(ServerWorld world, ChunkPos chunkPos) {
        addTicket(world, chunkPos, PISTON_BLOCK_TICKET_TYPE);
    }

    public static void addBellBlockTicket(ServerWorld world, ChunkPos chunkPos) {
        addTicket(world, chunkPos, BELL_BLOCK_TICKET_TYPE);
    }

    private static void addTicket(ServerWorld world, ChunkPos chunkPos, ChunkTicketType<ChunkPos> ticketType) {
        world.getChunkManager().addTicket(ticketType, chunkPos, getLoadRange(), chunkPos);
        blockChunkLoaderKeepWorldTickUpdate(world);
    }

    private static void blockChunkLoaderKeepWorldTickUpdate(ServerWorld world) {
        if (AmsServerSettings.blockChunkLoaderKeepWorldTickUpdate) {
            world.resetIdleTimeout();
        }
    }

    private static int getLoadTime() {
        return AmsServerSettings.blockChunkLoaderTimeController;
    }

    private static int getLoadRange() {
        return AmsServerSettings.blockChunkLoaderRangeController;
    }

    private static ChunkTicketType<ChunkPos> createChunkTicketType(String type) {
        return ChunkTicketType.create(type, Comparator.comparingLong(ChunkPos::toLong), getLoadTime());
    }
}