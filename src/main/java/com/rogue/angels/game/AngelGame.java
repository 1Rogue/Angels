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

import com.rogue.angels.region.PlayArea;
import org.bukkit.Location;

/**
 *
 * @since 0.1
 * @author 1Rogue
 * @version 0.1
 */
public class AngelGame {
    
    protected PlayArea parea;
    protected Location angelspawn;
    protected Location playerspawn;
    protected int startTime;
    
    public AngelGame(PlayArea p, Location angels, Location players, int start) {
        parea = p;
        angelspawn = angels;
        playerspawn = players;
        startTime = start;
    }
    
    public int getStartTime() {
        return startTime;
    }
    
    public void setStartTime(int newStart) {
        startTime = newStart;
    }
}
