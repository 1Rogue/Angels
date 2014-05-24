/*
 * Copyright (C) 2013 Spencer Alderman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rogue.angels.runnable;

import com.rogue.angels.Angels;
import com.rogue.angels.region.PlayArea;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @since 0.1
 * @author 1Rogue
 * @version 0.1
 */
public class BorderRunnable extends BukkitRunnable {

    Angels plugin;
    PlayArea sel;

    public BorderRunnable(Angels p, PlayArea pa) {
        plugin = p;
        sel = pa;
    }

    public void run() {
        //TODO: FATAL: Get players within the proper game, not the online players
        Player[] players = plugin.getServer().getOnlinePlayers();
        double minX = sel.getArea().getMinimumPoint().getX();
        double minZ = sel.getArea().getMinimumPoint().getZ();
        double maxX = sel.getArea().getMaximumPoint().getX();
        double maxZ = sel.getArea().getMaximumPoint().getZ();
        for (Player p : players) {
            if (!p.hasPermission("angels.playarea.bypass") && !sel.contains(p.getLocation())) {
                double theX = p.getLocation().getX();
                double theZ = p.getLocation().getZ();

                if (theX <= minX) {
                    theX = minX + 3;
                }
                if (theZ <= minZ) {
                    theZ = minZ + 3;
                }
                if (theX >= maxX) {
                    theX = maxX - 3;
                }
                if (theZ >= maxZ) {
                    theZ = maxZ - 3;
                }


                //int newX = rand.nextInt(sel.getArea().getLength());
                //int newZ = rand.nextInt(sel.getArea().getWidth());
                double newY = getSafeY(p.getWorld(), (int) theX, (int) Math.round(p.getLocation().getY()), (int) theZ, p.isFlying());
                p.teleport(new Location(p.getWorld(), theX, newY, theZ));
            }
        }
    }
    //Everything below, credit to: simplyianm, developer of WorldBorder
    //these material IDs are acceptable for places to teleport player; breathable blocks and water
    public static final LinkedHashSet<Integer> safeOpenBlocks = new LinkedHashSet<Integer>(Arrays.asList(
            new Integer[]{0, 6, 8, 9, 27, 28, 30, 31, 32, 37, 38, 39, 40, 50, 55, 59, 63, 64, 65, 66, 68, 69, 70, 71, 72, 75, 76, 77, 78, 83, 90, 93, 94, 96, 104, 105, 106, 115, 131, 132, 141, 142, 149, 150, 157}));
    //these material IDs are ones we don't want to drop the player onto, like cactus or lava or fire or activated Ender portal
    public static final LinkedHashSet<Integer> painfulBlocks = new LinkedHashSet<Integer>(Arrays.asList(
            new Integer[]{10, 11, 51, 81, 119}));

    private boolean isSafeSpot(World world, int X, int Y, int Z, boolean flying) {
        boolean safe = safeOpenBlocks.contains((Integer) world.getBlockTypeIdAt(X, Y, Z)) // target block open and safe
                && safeOpenBlocks.contains((Integer) world.getBlockTypeIdAt(X, Y + 1, Z));	// above target block open and safe
        if (!safe || flying) {
            return safe;
        }

        Integer below = (Integer) world.getBlockTypeIdAt(X, Y - 1, Z);
        return (safe
                && (!safeOpenBlocks.contains(below) || below == 8 || below == 9) // below target block not open/breathable (so presumably solid), or is water
                && !painfulBlocks.contains(below) // below target block not painful
                );
    }
    private static final int limBot = 1;

    // find closest safe Y position from the starting position
    private double getSafeY(World world, int X, int Y, int Z, boolean flying) {
        // artificial height limit of 127 added for Nether worlds since CraftBukkit still incorrectly returns 255 for their max height, leading to players sent to the "roof" of the Nether
        final int limTop = (world.getEnvironment() == World.Environment.NETHER) ? 125 : world.getMaxHeight() - 2;
        // Expanding Y search method adapted from Acru's code in the Nether plugin

        for (int y1 = Y, y2 = Y; (y1 > limBot) || (y2 < limTop); y1--, y2++) {
            // Look below.
            if (y1 > limBot) {
                if (isSafeSpot(world, X, y1, Z, flying)) {
                    return (double) y1;
                }
            }

            // Look above.
            if (y2 < limTop && y2 != y1) {
                if (isSafeSpot(world, X, y2, Z, flying)) {
                    return (double) y2;
                }
            }
        }

        return -1.0;	// no safe Y location?!?!? Must be a rare spot in a Nether world or something
    }
}
