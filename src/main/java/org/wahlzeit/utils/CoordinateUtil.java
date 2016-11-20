package org.wahlzeit.utils;
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

import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.SphericCoordinate;
import org.wahlzeit.model.interfaces.ICoordinate;

public class CoordinateUtil {

    public static final int EARTH_RADIUS = 6371;

    public static double calculateDistance(ICoordinate coord1, ICoordinate coord2){
        double x1,y1,z1;
        double x2,y2,z2;

        CartesianCoordinate cc1;
        CartesianCoordinate cc2;

        if(coord1 instanceof SphericCoordinate){
            cc1 = convertSphericToCartesian((SphericCoordinate) coord1);
        }else{
            cc1 = (CartesianCoordinate) coord1;
        }

        if(coord2 instanceof SphericCoordinate){
            cc2 = convertSphericToCartesian((SphericCoordinate) coord2);
        }else{
            cc2 = (CartesianCoordinate) coord2;
        }

        x1 = cc1.getX();
        y1 = cc1.getY();
        z1 = cc1.getZ();

        x2 = cc2.getX();
        y2 = cc2.getY();
        z2 = cc2.getZ();

        // distance between points (x1,y1,z1) and (x2,y2,z2)
        double distance = Math.sqrt((x2 - x1)*(x2 - x1) +
                (y2 - y1)*(y2 - y1) +
                (z2 - z1)*(z2 - z1));

        return distance;
    }

    public static CartesianCoordinate convertSphericToCartesian(SphericCoordinate coord){
        double lat,lon;
        double x, y, z;

        lat = coord.getLatitude();
        lat = Math.toRadians(lat);

        lon = coord.getLongitude();
        lon = Math.toRadians(lon);

        x = EARTH_RADIUS * Math.cos(lat) * Math.cos(lon);
        y = EARTH_RADIUS * Math.cos(lat) * Math.sin(lon);
        z = EARTH_RADIUS * Math.sin(lat);

        return new CartesianCoordinate(x, y, z);
    }
}
