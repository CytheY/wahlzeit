package org.wahlzeit.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

public class CartesianCoordinateTest {

    final double X_1 = 156.0;
    final double Y_1 = 2.0;
    final double Z_1 = 34.0;

    final double X_2 = 422.002432;
    final double Y_2 = 123.009093;
    final double Z_2 = -324.000942;

    CartesianCoordinate cartesian1;
    CartesianCoordinate cartesian2;
    CartesianCoordinate cartesian3;

    @Before
    public void setUp(){
        cartesian1 = CartesianCoordinate.getCoordinate(X_1,Y_1,Z_1);
        cartesian2 = CartesianCoordinate.getCoordinate(X_2, Y_2, Z_2);
        cartesian3 = CartesianCoordinate.getCoordinate(X_1,Y_1,Z_1);
    }

    @Test
    public void testGetDistanceCartesian(){
        double distance = cartesian1.getDistance(cartesian2);
        assertEquals(462.13, distance, 0.1);
    }

    @Test
    public void getDistanceSameCoordTest(){

        double distance = cartesian1.getDistance(cartesian3);
        assertEquals(0, distance, 0.0);
    }

    @Test
    public void isEqualTest(){
        boolean isEqual = cartesian1.isEqual(cartesian3);
        assertTrue(isEqual);
    }

    @Test
    public void isNotEqualTest(){
        boolean isEqual = cartesian1.isEqual(cartesian2);
        assertFalse(isEqual);
    }


    @Test
    public void asCartesianCoordinate() {
        CartesianCoordinate clone = CartesianCoordinate.getCoordinate(cartesian1.getX(), cartesian1.getY(), cartesian1.getZ());
        boolean isEqual = cartesian1.isEqual(clone);
        assertTrue(isEqual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCoordinates() {
        CartesianCoordinate clone = CartesianCoordinate.getCoordinate(Double.NaN, 1, cartesian1.getZ());
    }

    @Test
    public void testEquals(){
        assertTrue(cartesian1.equals(cartesian3));
        assertFalse(cartesian1.equals(cartesian2));
    }

    @Test
    public void testCartesianValueObject(){
        double x = 156.0;
        double y = 2.0;
        double z = 34.0;

        CartesianCoordinate test = CartesianCoordinate.getCoordinate(x,y,z);
        Coordinate valueObject = CartesianCoordinate.getCoordinate(x,y,z);

        assertTrue(test.equals(valueObject));
    }

    @After
    public void tearDown(){
        cartesian1 = null;
        cartesian2 = null;
        cartesian3 = null;
    }

}