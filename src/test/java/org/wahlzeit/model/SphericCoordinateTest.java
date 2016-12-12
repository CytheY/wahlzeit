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

public class SphericCoordinateTest {

    private static double ERLANGEN_LAT = 49.583333;
    private static double ERLANGEN_LON = 11.016667;

    private static double MUNICH_LAT = 48.137222;
    private static double MUNICH_LON = 11.575556;

    private static double DISTANCE_ER_MUN = 167.86;
    private static double DISTANCE_TOLERANCE = 3.0;


    SphericCoordinate erlangen;
    SphericCoordinate munich;

    @Before
    public void setUp(){
        erlangen = new SphericCoordinate(ERLANGEN_LAT,  ERLANGEN_LON);
        munich = new SphericCoordinate(MUNICH_LAT, MUNICH_LON);
    }

    @Test
    public void testGetDistanceSpheric(){
        double distance = erlangen.getDistance(munich);
        assertEquals(DISTANCE_ER_MUN, distance, DISTANCE_TOLERANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongLatitudeTest() throws Exception {
        new SphericCoordinate(-100.0, 90.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongLongitudeTest() throws Exception {
        new SphericCoordinate(-80.0, 190.0);
    }

    @Test
    public void getDistanceSameCoordTest(){
        double distance = erlangen.getDistance(erlangen);
        assertEquals(distance, 0, 0.0);
    }

    @Test
    public void isEqualTest(){
        boolean isEqual = erlangen.isEqual(erlangen);
        assertTrue(isEqual);
    }

    @Test
    public void isNotEqualTest(){
        boolean isEqual = erlangen.isEqual(munich);
        assertFalse(isEqual);
    }

    @Test
    public void asCartesianCoordinateTest() throws Exception {
        CartesianCoordinate erlangenCart = erlangen.asCartesianCoordinate();
        boolean isEqual = erlangen.isEqual(erlangenCart);
        assertTrue(isEqual);
    }

    @After
    public void tearDown(){
        erlangen = null;
        munich = null;
    }

}