package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by cyrus on 24.10.16.
 */
public class CoordinateTest {

    Coordinate erlangen;
    Coordinate munich;

    @Before
    public void setUp(){

        erlangen = new Coordinate(49.583333,  11.016667);
        munich = new Coordinate(48.137222, 11.575556);

    }

    @Test
    public void testGetDistance(){
        double distance = erlangen.getDistance(munich);
        assertEquals(167.86, distance,3.0);
    }

    @Test
    public void testGetDistanceSameCoord(){
        double distance = erlangen.getDistance(erlangen);
        assertEquals(distance, 0, 0.0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBounds(){
        Coordinate outOfBounds = new Coordinate(-100.0, 120.0);
    }

}
