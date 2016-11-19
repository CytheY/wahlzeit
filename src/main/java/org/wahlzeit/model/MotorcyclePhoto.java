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

@Entity
public class MotorcyclePhoto extends Photo{

    public enum Type {
        SUPERBIKE,
        ENDURO,
        NAKED,
        SCRAMBLER,
        CHOPPER,
        TOURER,
        CROSS,
        STREETFIGHTER,
        OTHER
        }
    public Type type;

    private final static String NA = "N/A";
    private final static int BUILDYEAR_NA = 0000;

    private String brand = NA;
    private String model = NA;
    private int buildYear = BUILDYEAR_NA;


    public MotorcyclePhoto(){
        super();

    }

    /**
     * @methodtype constructor
     */
    public MotorcyclePhoto(PhotoId myId) {
        super(myId);
    }


    /**
     *
     */
    public MotorcyclePhoto(PhotoId myId, String brand, String model, int buildYear, Type type) {
        super(myId);
        this.brand = brand;
        this.model = model;
        this.buildYear = buildYear;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return brand + " " + model + "(" + buildYear + ")";
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }
}


