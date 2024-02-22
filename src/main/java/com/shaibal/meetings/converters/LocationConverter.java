package com.shaibal.meetings.converters;

import com.shaibal.meetings.models.Location;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocationConverter implements AttributeConverter<Location, String> {

    @Override
    public String convertToDatabaseColumn(Location location) {
        return location.toString();
    }

    @Override
    public Location convertToEntityAttribute(String locationAsString) {
        // Assuming the format is "name (latitude, longitude)"
        String[] parts = locationAsString.split("\\(");
        String name = parts[0].trim();
        String coordinates = parts[1].replace(")", "").trim();

        String[] coordinatesArray = coordinates.split(",");
        double latitude = Double.parseDouble(coordinatesArray[0].trim());
        double longitude = Double.parseDouble(coordinatesArray[1].trim());

        return new Location(name, latitude, longitude);
    }
}
