package org.wahlzeit.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LocationTest {

    private Location location1;
    private Location location2;

    @Before
    public void setUp(){
        location1 = new Location(SphericCoordinate.getCoordinate(1.0, 1.0));
        location2 = new Location(SphericCoordinate.getCoordinate(0.0, 0.0));
    }

    @Test
    public void testLocation(){
        assertTrue( location1 != null);
        assertTrue( location2 != null);
    }

    @After
    public void tearDown(){
        location1 = null;
        location2 = null;
    }

}
