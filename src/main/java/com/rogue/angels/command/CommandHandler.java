/*
 * Copyright (C) 2013 AE97
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
package com.rogue.angels.command;

import com.rogue.angels.command.subcommand.*;
import java.util.HashMap;
import java.util.Map;
import com.rogue.angels.Angels;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Adopted from TotalPermissions
 * 
 * @version 0.1
 * @author 1Rogue
 * @since 0.1
 */
public final class CommandHandler implements CommandExecutor {

    protected final Map<String, SubCommand> commands = new HashMap<String, SubCommand>();
    protected final Angels plugin;

    public CommandHandler(Angels p) {
        plugin = p;
    }
    
    /**
     * Main executor of commands. Grabs the appropriate command and executes it.
     *
     * @since 0.1
     * @version 0.1
     *
     * @param sender The command executor
     * @param cmd The command instance
     * @param alias The label of the command
     * @param args The command arguments
     *
     * @return Command success
     */
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
        String subCommand;
        if (args.length < 1) {
            args = new String[]{"help"};
        }
        subCommand = args[0];
        SubCommand executor = commands.get(subCommand.toLowerCase());
        if (executor == null) {
            sender.sendMessage("No command found, use /angels help for command list");
            return true;
        }
        if ((args.length > 1) && (args[1].equalsIgnoreCase("help"))) {
            sender.sendMessage("Usage: " + executor.getHelp()[0]);
            sender.sendMessage(executor.getHelp()[1]);
            return true;
        }
        int length = args.length - 1;
        if (length < 0) {
            length = 0;
        }
        String[] newArgs = new String[length];
        for (int i = 0; i < newArgs.length; i++) {
            newArgs[i] = args[i + 1];
        }
        if (sender.hasPermission("angels.cmd" + executor.getName())) {
            boolean success = executor.execute(sender, args);
            if (!success) {
                sender.sendMessage(executor.getHelp()[0]);
                sender.sendMessage(executor.getHelp()[1]);
            }
            return true;
        } else {
            sender.sendMessage("You cannot use that command");
        }
        return true;
    }

    /**
     * Gets the registered commands that may be used
     *
     * @return Map of registered sub commands
     *
     * @since 0.1
     */
    public Map<String, SubCommand> getCommandList() {
        return commands;
    }
}
