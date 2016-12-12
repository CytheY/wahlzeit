package org.wahlzeit.model;
/*
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

public abstract class AbstractCoordinate implements Coordinate {

    //Tolerance in which two coordinates are equal
    private static double TOLERANCE = 0.5;

    protected abstract void assertClassInvariants();

    protected abstract double getX();
    protected abstract double getY();
    protected abstract double getZ();

    protected void assertIsNonNullArgument(Coordinate coord) throws NullPointerException {
        if(coord == null)
            throw new NullPointerException();
    }

    /**
     *
     * @param coord
     * @return double: distance between two coordinates in meters
     */
    public double getDistance(Coordinate coord){
        assertIsNonNullArgument(coord);
        assertClassInvariants();

        return doGetDistance((AbstractCoordinate) coord);
    }

    private double doGetDistance(AbstractCoordinate coord){
        double delta_x, delta_y, delta_z;

        delta_x = this.getX() - coord.getX();
        delta_y = this.getY() - coord.getY();
        delta_z = this.getZ() - coord.getZ();


        // distance between points (x1,y1,z1) and (x2,y2,z2)
        double distance =  Math.sqrt(delta_x * delta_x +
                                     delta_y * delta_y +
                                     delta_z * delta_z);
        return distance;
    }

    /**
     * @methodtype helper
     * @param coord
     * @return bool: two coordinates describe the same location
     */
    @Override
    public boolean isEqual(Coordinate coord){
        assertIsNonNullArgument(coord);
        assertClassInvariants();

        return this.getDistance(coord) <= TOLERANCE;
    }
}
