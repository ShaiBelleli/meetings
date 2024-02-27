package com.shaibal.meetings.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shaibal.meetings.util.deserializers.LocationDeserializer;
import com.shaibal.meetings.util.serializers.LocationSerializer;
import lombok.Getter;
import lombok.Setter;

/******************************************************************************
 *  Immutable data type for a named location: name and
 *  (latitude, longitude).

 ******************************************************************************/
@JsonDeserialize(using = LocationDeserializer.class)
@JsonSerialize(using = LocationSerializer.class)
@Getter
@Setter
public class Location {
    private final String name;
    private final double longitude;
    private final double latitude;

    // create and initialize a point with given name and
    // (latitude, longitude) specified in degrees
    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    // return distance between this location and that location
    // measured in kilometers
    public double distanceTo(Location that) {
        final double NAUTICAL_MILES_PER_DEGREE_LATITUDE = 60.0;
        final double KILOMETERS_PER_NAUTICAL_MILE = 1.852;

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(that.latitude);
        double lon2 = Math.toRadians(that.longitude);

        // great circle distance in radians, using the law of cosines formula
        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        // each degree on a great circle of Earth is 60 nautical miles
        double nauticalMiles = Math.toDegrees(angle) * NAUTICAL_MILES_PER_DEGREE_LATITUDE;


        return nauticalMiles * KILOMETERS_PER_NAUTICAL_MILE;
    }

    // return string representation of this point
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }
}
