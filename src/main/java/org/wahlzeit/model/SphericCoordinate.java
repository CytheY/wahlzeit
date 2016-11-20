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

package org.wahlzeit.model;

import org.wahlzeit.model.interfaces.ICoordinate;
import org.wahlzeit.utils.CoordinateUtil;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class SphericCoordinate implements ICoordinate{
    private static final DecimalFormat df = new DecimalFormat("#.##");

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

        DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        sym.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(sym);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getRadius(){
        return EARTH_RADIUS;
    }

    @Override
    public double getDistance(ICoordinate coord){
        return CoordinateUtil.calculateDistance(this, coord);
    }
}
