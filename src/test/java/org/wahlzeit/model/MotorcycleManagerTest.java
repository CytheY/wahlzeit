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

public class MotorcycleManagerTest {

    MotorcycleManager motorcycleManager;

    private final String BRAND = "Yamaha";
    private final String MODEL = "XJ 650";
    private final int BUILD_YEAR = 1982;
    private final String NAME = "Yamaha XJ 650 (1982)";
    @Before
    public void setUp() throws Exception {
        motorcycleManager = MotorcycleManager.getInstance();
        assertNotNull(motorcycleManager);
    }

    @Test
    public void createMotorcycle() {
        Motorcycle test = motorcycleManager.createMotorcycle( MotorcycleType.Type.SCRAMBLER, BRAND, MODEL, BUILD_YEAR);
        assertEquals(test.getBrand(), BRAND);
        assertEquals(test.getBuildYear(), BUILD_YEAR);
        assertEquals(test.getModel(), MODEL);

        Motorcycle test2 = motorcycleManager.getMotorcycle(NAME);
        assertEquals(test,test2);
    }

    @Test
    public void addGetMotorcycleType(){
        motorcycleManager.addMotorcycleType(MotorcycleType.Type.ENDURO);

        MotorcycleType motorcycleTypeEnduro = motorcycleManager.getMotorcycleType(MotorcycleType.Type.ENDURO);
        assertNotNull(motorcycleTypeEnduro);

        MotorcycleType motorcycleTypeScrambler = motorcycleManager.getMotorcycleType(MotorcycleType.Type.SCRAMBLER);
        assertNull(motorcycleTypeScrambler);
    }

}