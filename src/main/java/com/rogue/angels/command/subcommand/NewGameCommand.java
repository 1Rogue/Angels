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
package com.rogue.angels.command.subcommand;

import com.rogue.angels.Angels;
import com.rogue.angels.region.PlayArea;
import com.sk89q.worldedit.BlockVector2D;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.*;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @since 0.1
 * @author 1Rogue
 * @version 0.1
 */
public class NewGameCommand implements SubCommand {

    public boolean execute(CommandSender sender, String[] args) {
        /*if (!(sender instanceof Player)) {
            sender.sendMessage("You must be an in-game player to use this command!");
            return true;
        }
        WorldEditPlugin we = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        Selection sel = we.getSelection((Player) sender);
        if (sel == null) {
            sender.sendMessage("You must make a WorldEdit Selection first");
        } else {
            Angels.getPlugin().getGameHandler().
            //Angels.getPlugin().setPlayArea(new PlayArea(sel));
        }*/
        return true;
    }

    

    public String getName() {
        return "setregion";
    }

    public String[] getHelp() {
        return new String[]{
            "/angels setregion",
            "Sets the region for angels to be played in from the current worldedit selection."
        };
    }
}
