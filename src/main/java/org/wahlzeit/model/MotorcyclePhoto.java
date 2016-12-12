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
     * @methodtype constructor
     */
    public MotorcyclePhoto(PhotoId myId, String brand, String model, int buildYear, Type type) {
        super(myId);
        this.brand = brand;
        this.model = model;
        this.buildYear = buildYear;
        this.type = type;

        assertClassInvariants();
    }

    private void assertClassInvariants() {
        assertString(brand);
        assertString(model);
        assertBuildYear();
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
     * @return Type
     */
    public Type getType() {
        return type;
    }

    /**
     * @methodtype set
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @methodtype get
     * @return String: brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     * @throws IllegalArgumentException
     */
    public void setBrand(String brand) throws IllegalArgumentException {
        assertString(brand);
        this.brand = brand;
    }

    /**
     * @methodtype get
     * @return String: model
     */
    public String getModel() {
        return model;
    }

    /**
     * @methodtype set
     * @param model
     * @throws IllegalArgumentException
     */
    public void setModel(String model) throws IllegalArgumentException {
        assertString(model);
        this.model = model;
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
     * @methodtype set
     * @param buildYear
     * @throws IllegalArgumentException
     */
    public void setBuildYear(int buildYear) throws IllegalArgumentException {
        assertBuildYear();
        this.buildYear = buildYear;
    }
}


