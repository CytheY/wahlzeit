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

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MotorcyclePhotoManagerTest {

    private MotorcyclePhotoManager instance;

    @Before
    public void initPhotoFilter() {
        instance = MotorcyclePhotoManager.getInstance();
    }

    /**
     *
     */
    @Test
    public void doAdd() throws IOException {
        MotorcyclePhoto photo1 = new MotorcyclePhoto(new PhotoId(2), "Yamaha", "XJ 650", 1982, MotorcyclePhoto.Type.SCRAMBLER);
        MotorcyclePhoto photo2 = new MotorcyclePhoto(new PhotoId(3), "Yamaha", "XJ 1200", 2002, MotorcyclePhoto.Type.SCRAMBLER);
        MotorcyclePhoto photo3 = new MotorcyclePhoto(new PhotoId(4), "Triumph", "Speedtriple", 2001, MotorcyclePhoto.Type.NAKED);
        instance.addPhoto(photo1);
        instance.addPhoto(photo2);
        instance.addPhoto(photo3);
    }

    @Test
    public void testGetPhotoByType(){
        Set<MotorcyclePhoto> result = instance.findPhotosByType(MotorcyclePhoto.Type.SCRAMBLER);
        assertEquals(result.size(), 2, 0);
    }
}
