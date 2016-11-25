package org.wahlzeit.model;

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
 */public class CartesianCoordinateTest {

    CartesianCoordinate cartesian1;
    CartesianCoordinate cartesian2;
    CartesianCoordinate cartesian3;

    @Before
    public void setUp(){
        cartesian1 = new CartesianCoordinate(0,0,0);
        cartesian2 = new CartesianCoordinate(100, 100, 100);
        cartesian3 = new CartesianCoordinate(0,0,0);
    }

    @Test
    public void testGetDistanceCartesian(){
        double distance = cartesian1.getDistance(cartesian2);
        assertEquals(173.21, distance, 0.1);
    }

    @Test
    public void getDistanceSameCoordTest(){

        double distance = cartesian1.getDistance(cartesian3);
        assertEquals(distance, 0, 0.0);
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
    public void asCartesianCoordinate() throws Exception {

    }

}