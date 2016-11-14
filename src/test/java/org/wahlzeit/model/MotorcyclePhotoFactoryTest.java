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
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MotorcyclePhotoFactoryTest {

    private MotorcyclePhotoFactory factory;

    @Before
    public void setUp(){
        factory = MotorcyclePhotoFactory.getInstance();
    }

    @Test
    public void createPhotoTest(){
        MotorcyclePhoto photo1 = factory.createPhoto();
        MotorcyclePhoto photo2 = factory.createPhoto(new PhotoId(3));
        MotorcyclePhoto photo3 = factory.createPhoto(new PhotoId(4), "Yamaha", "XJ 650", 1982, MotorcyclePhoto.Type.SCRAMBLER);

        assertEquals(photo1.getName(), "N/A");
        assertEquals(photo2.getId(), 3);

        assertEquals(photo3.getId(), 4);
        assertEquals(photo3.getType(), MotorcyclePhoto.Type.SCRAMBLER);

    }
}
