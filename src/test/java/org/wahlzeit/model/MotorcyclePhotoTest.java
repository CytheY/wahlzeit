package org.wahlzeit.model;/*
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

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import static org.junit.Assert.assertEquals;

public class MotorcyclePhotoTest {

    @ClassRule
    public static RuleChain ruleChain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider());

    private MotorcyclePhoto motorcyclePhoto;

    @Before
    public void initPhotoFilter() {
        motorcyclePhoto = new MotorcyclePhoto(new PhotoId(2));
    }

    /**
     *
     */
    @Test
    public void testGetterSetter() {

        motorcyclePhoto.setType(MotorcyclePhoto.Type.SCRAMBLER);
        assertEquals(motorcyclePhoto.getType(), MotorcyclePhoto.Type.SCRAMBLER);

//        motorcyclePhoto.setBrand("Yamaha");
//        assertEquals(motorcyclePhoto.getBrand(), "Yamaha");
    }
}