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

import java.util.HashMap;

@PatternInstance(
        patternName = "Value Object",
        participants = {
                "SphericCoordinate"
        }
)

public class SphericCoordinate extends AbstractCoordinate{

    private static final HashMap<Integer, SphericCoordinate> sphericCoordinateMap = new HashMap<>();

    private static final int EARTH_RADIUS = 6371;

    private static final double LATITUDE_MIN = -90.0;
    private static final double LATITUDE_MAX = 90.0;

    private static final double LONGITUDE_MIN = -180.0;
    private static final double LONGITUDE_MAX = 180.0;

    private final double latitude;
    private final double longitude;

    /**
     *
     * @param lat latitude
     * @param lng longitude
     * @throws IllegalArgumentException
     */
    private SphericCoordinate(double lat, double lng) throws IllegalArgumentException {

        this.latitude = lat;
        this.longitude = lng;

        assertClassInvariants();
    }

    /**
     * returns an equal object from hashMap or
     * creates a new instance of CartesianCoordinate if no equal object is found
     * @param lat
     * @param lng
     * @return
     */
    public static SphericCoordinate getCoordinate(double lat, double lng){
        SphericCoordinate tmp = new SphericCoordinate(lat,lng);
        synchronized (sphericCoordinateMap) {
            //check if object already in HashMap
            SphericCoordinate result = sphericCoordinateMap.get(tmp.hashCode());
            if (result == null) {
                result = tmp;
                sphericCoordinateMap.put(tmp.hashCode(), result);
            }
            return  result;
        }
    }
    /**
     * @methodtype get
     * @return latitude coordiante as double
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @methodtype get
     * @return longitude coordinate as double
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @methodtype helper
     * @return object coordinates as CartesianCoordinate x
     */
    @Override
    protected double getX(){
        return EARTH_RADIUS * Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
    }

    /**
     * @methodtype helper
     * @return object coordinates as CartesianCoordinate y
     */
    @Override
    protected double getY(){
        return EARTH_RADIUS * Math.cos(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
    }

    /**
     * @methodtype helper
     * @return object coordinates as CartesianCoordinate z
     */
    @Override
    protected double getZ(){
        return EARTH_RADIUS * Math.sin(Math.toRadians(latitude));
    }

    /**
     * @methodtype assertion
     * @return void
     */
    @Override
    protected void assertClassInvariants() throws IllegalArgumentException{
        if(latitude < LATITUDE_MIN || latitude > LATITUDE_MAX)
            throw new IllegalArgumentException("Latitude value is invalid. Must be between -90.0 and 90.0");

        if(longitude < LONGITUDE_MIN || longitude > LONGITUDE_MAX)
            throw new IllegalArgumentException("Longitude value is invalid. Must be between -180.0 and 180.0");
    }
}
