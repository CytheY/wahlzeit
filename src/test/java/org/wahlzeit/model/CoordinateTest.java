package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by cyrus on 24.10.16.
 */
public class CoordinateTest {

    @Test
    public void testGetDistance(){
        Coordinate coord1 = new Coordinate(1.0, 1.0);
        Coordinate coord2 = new Coordinate(0.0, 0.0);
        double distance = coord1.getDistance(coord2);

        assertEquals(distance, 157.2493812719255, 0.1);
    }
}
