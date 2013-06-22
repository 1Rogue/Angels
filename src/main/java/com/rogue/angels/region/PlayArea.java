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
package com.rogue.angels.region;

import com.sk89q.worldedit.bukkit.selections.Selection;
import org.bukkit.Location;

/**
 *
 * @since 0.1
 * @author 1Rogue
 * @version 0.1
 */
public class PlayArea {
    
    Selection area;
    
    public PlayArea (Selection sel) {
        /*if (sel instanceof CuboidSelection) {
            CuboidSelection cuboid = (CuboidSelection) sel;
   

        } else if (sel instanceof Polygonal2DSelection) { // Is it a polygon?
            Polygonal2DSelection polygon = (Polygonal2DSelection) sel;
            List<BlockVector2D> points = polygon.getNativePoints();
        }*/
        area = sel;
    }
    
    public boolean contains (Location loc) {
        return area.contains(loc);
    }
    
    public Selection getArea() {
        return area;
    }
    
}
