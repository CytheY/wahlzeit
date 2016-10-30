package org.wahlzeit.model;

/**
 * Created by cyrus on 24.10.16.
 */
public class Location {


    public Coordinate coordinate = null;

    public Location(double lat, double lng){
        this.coordinate = new Coordinate(lat,lng);
    }
}
