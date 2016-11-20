package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.interfaces.ICoordinate;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    SphericCoordinate erlangen;
    SphericCoordinate munich;

    CartesianCoordinate cartesian1;
    CartesianCoordinate cartesian2;

    @Before
    public void setUp(){

        erlangen = new SphericCoordinate(49.583333,  11.016667);
        munich = new SphericCoordinate(48.137222, 11.575556);

        cartesian1 = new CartesianCoordinate(0,0,0);
        cartesian2 = new CartesianCoordinate(100, 100, 100);
    }

    @Test
    public void testGetDistanceSpheric(){
        double distance = erlangen.getDistance(munich);
        assertEquals(167.86, distance, 3.0);
    }

    @Test
    public void testGetDistanceCartesian(){
        double distance = cartesian1.getDistance(cartesian2);
        assertEquals(173.21, distance, 0.1);
    }

    @Test
    public void testGetDistanceSameCoord(){
        double distance = erlangen.getDistance(erlangen);
        assertEquals(distance, 0, 0.0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBoundsSpheric(){
        ICoordinate outOfBounds = new SphericCoordinate(-100.0, 120.0);
    }


}
