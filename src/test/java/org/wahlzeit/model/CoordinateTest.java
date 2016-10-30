package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by cyrus on 24.10.16.
 */
public class CoordinateTest {

    Coordinate coord1;
    Coordinate coord2;

    @Before
    public void setUp(){
        coord1 = new Coordinate(1.0, 1.0);
        coord2 = new Coordinate(0.0, 0.0);
    }

    @Test
    public void testGetDistance(){
        double distance = coord1.getDistance(coord2);

        assertEquals(distance, 157.2493812719255, 0.0);
    }
}
