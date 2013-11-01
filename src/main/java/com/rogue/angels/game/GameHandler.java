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
package com.rogue.angels.game;

import com.rogue.angels.Angels;
import com.rogue.angels.region.PlayArea;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;

/**
 *
 * @since
 * @author 1Rogue
 * @version
 */
public class GameHandler {
    
    protected Angels plugin;
    protected List<AngelGame> games = new ArrayList();
    
    public GameHandler (Angels p) {
        plugin = p;
    }
    
    public AngelGame newGame(PlayArea p, Location angels, Location players, int startTime) {
        AngelGame newg = new AngelGame(p, angels, players, startTime);
        games.add(newg);
        return newg;
    }
    
    public AngelGame newGame (AngelGame ag) {
        games.add(ag);
        return ag;
    }
    
    public List<AngelGame> getGames() {
        return games;
    }
    
    /**
     * Removes the game from the selected index in the game list
     * 
     * @param id The index of the game list
     */
    public void delGame(int id) {
        games.remove(id);
    }
}
