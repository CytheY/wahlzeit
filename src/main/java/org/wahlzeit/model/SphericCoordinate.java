package org.wahlzeit.model;
/*
 * Copyright (c) 2006-2009 by Julian Schneider, http://dirkriehle.com
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

public class SphericCoordinate extends AbstractCoordinate{

    private static final int EARTH_RADIUS = 6371;

    private static final double LATITUDE_MIN = -90.0;
    private static final double LATITUDE_MAX = 90.0;

    private static final double LONGITUDE_MIN = -180.0;
    private static final double LONGITUDE_MAX = 180.0;

    private double latitude;
    private double longitude;


    public SphericCoordinate(double lat, double lng){
        if(lat < LATITUDE_MIN || lat > LATITUDE_MAX)
            throw new IllegalArgumentException("Latitude value is invalid. Must be between -90.0 and 90.0");

        if(lng < LONGITUDE_MIN || lng > LONGITUDE_MAX)
            throw new IllegalArgumentException("Longitude value is invalid. Must be between -180.0 and 180.0");

        this.latitude = lat;
        this.longitude = lng;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();

        double lat, lon;
        double x, y, z;

        lat = Math.toRadians(latitude);
        lon = Math.toRadians(longitude);

        x = EARTH_RADIUS * Math.cos(lat) * Math.cos(lon);
        y = EARTH_RADIUS * Math.cos(lat) * Math.sin(lon);
        z = EARTH_RADIUS * Math.sin(lat);

        CartesianCoordinate result = new CartesianCoordinate(x, y, z);
        result.assertClassInvariants();

        return result;
    }

    @Override
    public void assertClassInvariants() {
        assert latitude >= LATITUDE_MIN && longitude <= LATITUDE_MAX;
        assert longitude >= LONGITUDE_MIN && longitude <= LONGITUDE_MAX;
    }
}
