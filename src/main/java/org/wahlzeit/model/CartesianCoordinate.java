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

import java.util.IllegalFormatCodePointException;

public class CartesianCoordinate extends AbstractCoordinate{

    private double x, y, z;

    /**
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param z z-coordinate
     */
    public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException{
        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariants();
    }

    /**
     * @methodtype get
     * @return x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @methodtype get
     * @return y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * @methodtype get
     * @return z-coordinate
     */
    public double getZ() {
        return z;
    }

    /**
     * @methodtype helper
     * @return object as CartesianCoordinate (this)
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException {
        assertClassInvariants();
        return this;
    }

    /**
     * @methodtype assertion
     * @return void
     */
    @Override
    protected void assertClassInvariants() throws IllegalArgumentException{
        if(x < Double.POSITIVE_INFINITY || x > Double.NEGATIVE_INFINITY || x != Double.NaN){
            throw new IllegalArgumentException("X is not a valid double value.");
        }
        if(y < Double.POSITIVE_INFINITY || y > Double.NEGATIVE_INFINITY || y != Double.NaN){
            throw new IllegalArgumentException("Y is not a valid double value.");
        }
        if(z < Double.POSITIVE_INFINITY || z > Double.NEGATIVE_INFINITY || z != Double.NaN){
            throw new IllegalArgumentException("Z is not a valid double value.");
        }
    }
}
