package org.wahlzeit.model;/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

import org.wahlzeit.model.interfaces.ICoordinate;

public abstract class AbstractCoordinate implements ICoordinate{

    protected static int EARTH_RADIUS = 6371;

    //Tolerance in which two coordinates are equal
    private static int TOLERANCE = 0;


    @Override
    public double getDistance(ICoordinate coord){
        double delta_x, delta_y, delta_z;

        CartesianCoordinate cc1 = coord.asCartesianCoordinate();
        CartesianCoordinate cc2 = this.asCartesianCoordinate();

        delta_x = cc2.getX() - cc1.getX();
        delta_y = cc2.getY() - cc1.getY();
        delta_z = cc2.getZ() - cc1.getZ();


        // distance between points (x1,y1,z1) and (x2,y2,z2)
        double distance =  Math.sqrt(delta_x * delta_x +
                                     delta_y * delta_y +
                                     delta_z * delta_z);

        return distance;
    };

    @Override
    public boolean isEqual(ICoordinate coord){
        CartesianCoordinate cc1 = coord.asCartesianCoordinate();
        CartesianCoordinate cc2 = this.asCartesianCoordinate();

        return cc1.getDistance(cc2) <= TOLERANCE;
    };

    @Override
    public abstract CartesianCoordinate asCartesianCoordinate();


}
