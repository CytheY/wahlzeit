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

/**
 * Created by cyrus on 24.10.16.
 */
public class Coordinate {

    private double latitude;
    private double longitude;


    public Coordinate(double lat, double lng){
        this.latitude = lat;
        this.longitude = lng;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistance(Coordinate coord){
        double lat1 = coord.getLatitude();
        lat1 = Math.toRadians(lat1);
        double lat2 = this.latitude;
        lat2 = Math.toRadians(lat2);

        double lon1 = coord.getLongitude();
        lon1 = Math.toRadians(lon1);
        double lon2 = this.longitude;
        lon2 = Math.toRadians(lon2);

        final int R = 6371;

        double delta_long = (lon2 - lon1);

        final double delta_roh = Math.acos(Math.sin(lat1) * Math.sin(lat2) +
                                 Math.cos(lat1) * Math.cos(lat2) * Math.cos(delta_long));

        final double distance = R * delta_roh;

        return distance;
    }
}
