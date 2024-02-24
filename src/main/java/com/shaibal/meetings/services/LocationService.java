package com.shaibal.meetings.services;

import com.shaibal.meetings.models.Location;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    public Location buildLocationFromStringsInput(String city, String street, String streetNumber) {
        // UI will handle converting a location to meaningful numbers
        // For now, we'll create a dummy Location with hardcoded values (latitude: 1.0, longitude: 1.0)
        return new Location(city + street + streetNumber, 1.0, 1.0);
    }
}