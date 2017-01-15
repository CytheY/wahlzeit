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

import com.googlecode.objectify.annotation.Id;

import java.util.Calendar;

public class Motorcycle {

    private MotorcycleType motorcycleType;

    private String brand;
    private String model;
    private int buildYear;


    public Motorcycle(MotorcycleType mt, String brand, String model, int buildYear){
        this.motorcycleType = mt;
        this.brand = brand;
        this.model = model;
        this.buildYear = buildYear;

        assertClassInvariants();
    }

    private void assertClassInvariants() {
        assertNotNull(motorcycleType);
        assertString(brand);
        assertString(model);
        assertBuildYear();
    }

    private void assertNotNull(MotorcycleType motorcycleType) {
        if(motorcycleType == null)
            throw new IllegalArgumentException("Type name must not be null.");
    }

    private void assertString(String brand) {
        if(model.isEmpty())
            throw new IllegalArgumentException("Model name must not be emopty.");
    }

    private void assertBuildYear() {
        Calendar cal = Calendar.getInstance();

        if(buildYear < 1800 || buildYear > cal.YEAR){
            throw new IllegalArgumentException("Buildyear have to be between 1800 and " + cal.YEAR);
        }
    }

    /**
     * @methodtype get
     * @return String: brand
     */
    public String getBrand() {
        return brand;
    }


    /**
     * @methodtype get
     * @return String: model
     */
    public String getModel() {
        return model;
    }

    /**
     * @methodtype get
     * @return String: Name as <brand model (buildYear)>
     */
    public String getName() {
        return getBrand() + " " + getModel() + "(" + getBuildYear() + ")";
    }

    /**
     * @methodtype get
     * @return Int: buildYear
     */
    public int getBuildYear() {
        return buildYear;
    }

    /**
     * @methodtype get
     * @return MotorcycleType: motorcycleType
     */
    public MotorcycleType getMotorcycleType() {
        return motorcycleType;
    }

}
