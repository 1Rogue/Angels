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
package com.rogue.angels;

import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @since 0.1
 * @author 1Rogue
 * @version 0.1
 */
public class Angels extends JavaPlugin {

    /**
     * No use yet.
     *
     * @since 0.1
     * @version 0.1
     */
    @Override
    public void onLoad() {
        this.getLogger().log(Level.INFO, "{0} is loaded!", this.getName());
    }

    /**
     * No use yet.
     *
     * @since 0.1
     * @version 0.1
     */
    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, "{0} is enabled!", this.getName());
    }

    /**
     * Main executor of commands. Grabs the appropriate command and executes it.
     *
     * @since 0.1
     * @version 0.1
     *
     * @param cs The command executor
     * @param cmd The command instance
     * @param string The label of the command
     * @param args The command arguments
     *
     * @return Command success
     */
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("angels") && cs.hasPermission("angels.version")) {
            cs.sendMessage("Angels v" + this.getDescription().getVersion() + " - made by " + this.getDescription().getAuthors().toArray()[0]);
            return true;
        }
        return false;
    }

    /**
     * No use yet.
     *
     * @since 0.1
     * @version 0.1
     */
    @Override
    public void onDisable() {
        this.getLogger().log(Level.INFO, "{0} is disabled!", this.getName());
    }

    /**
     * Gets the instance of the plugin in its entirety.
     *
     * @since 0.1
     * @version 0.1
     *
     * @return The plugin instance
     */
    public static Angels getPlugin() {
        return (Angels) Bukkit.getServer().getPluginManager().getPlugin("Rejected");
    }
}
