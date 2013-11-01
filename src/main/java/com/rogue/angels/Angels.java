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

import com.rogue.angels.command.CommandHandler;
import com.rogue.angels.game.GameHandler;
import com.rogue.angels.listener.AngelsListener;
import com.rogue.angels.region.PlayArea;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @since 0.1
 * @author 1Rogue
 * @version 0.1
 */
public class Angels extends JavaPlugin {
    
    protected CommandHandler commands;
    protected GameHandler ghandler;
    protected AngelsListener listener;
    protected PlayArea parea;

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
     * Registers the command system.
     *
     * @since 0.1
     * @version 0.1
     */
    @Override
    public void onEnable() {
        getLogger().config("Creating listener...");
        listener = new AngelsListener(this);
        Bukkit.getPluginManager().registerEvents(listener, this);
        getLogger().config("Creating command handler...");
        commands = new CommandHandler(this);
        getCommand("angels").setExecutor(commands);
        getLogger().config("Creating game handler...");
        ghandler = new GameHandler(this);
        this.getLogger().log(Level.INFO, "{0} is enabled!", this.getName());
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
        return (Angels) Bukkit.getServer().getPluginManager().getPlugin("Angels");
    }
    
    /**
     * Gets the plugin's listener
     * 
     * @since 0.1
     * @version 0.1
     * 
     * @return The plugin's listener
     */
    public AngelsListener getListener() {
        return listener;
    }
    
    /**
     * Gets the plugin's handler for all the games
     * 
     * @since 0.1
     * @version 0.1
     * 
     * @return The plugin's game system
     */
    public GameHandler getGameHandler() {
        return ghandler;
    }
}
