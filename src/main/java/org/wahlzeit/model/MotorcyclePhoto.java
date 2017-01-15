package org.wahlzeit.model;

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


import com.googlecode.objectify.annotation.Entity;

import java.util.Calendar;

@Entity
public class MotorcyclePhoto extends Photo{


    private Motorcycle motorcycle;


    public MotorcyclePhoto(){
        super();
    }

    /**
     * @methodtype constructor
     */
    public MotorcyclePhoto(PhotoId myId) {
        this(myId, null);
    }


    /**
     * @methodtype constructor
     */
    public MotorcyclePhoto(PhotoId myId, Motorcycle motorcycle) {
        super(myId);
        this.motorcycle = motorcycle;
    }

    /**
     * @methodtype get
     */
    public Motorcycle getMotorcycle(){
        return motorcycle;
    }
}


