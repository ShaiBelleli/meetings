package com.shaibal.meetings.util.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.shaibal.meetings.models.Location;

import java.io.IOException;

public class LocationSerializer extends JsonSerializer<Location> {

    @Override
    public void serialize(Location location, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", location.getName());
        gen.writeNumberField("latitude", location.getLatitude());
        gen.writeNumberField("longitude", location.getLongitude());
        gen.writeEndObject();
    }
}
