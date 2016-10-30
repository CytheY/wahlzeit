package org.wahlzeit.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by cyrus on 24.10.16.
 */
public class LocationTest {

    private Location location1;
    private Location location2;

    @Before
    public void setUp(){
        location1 = new Location(1.0, 1.0);
        location2 = new Location(0.0, 0.0);
    }

    @Test
    public void testLocation(){
        assertEquals(location1.coordinate.getLongitude(), 1.0, 0.0);
        assertEquals(location1.coordinate.getLatitude(), 1.0, 0.0);

        assertEquals(location2.coordinate.getLongitude(), 0.0, 0.0);
        assertEquals(location2.coordinate.getLatitude(), 0.0, 0.0);
    }

}
