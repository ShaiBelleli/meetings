package com.shaibal.meetings.util.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.shaibal.meetings.models.Location;

import java.io.IOException;

public class LocationDeserializer extends StdDeserializer<Location> {

    public LocationDeserializer() {
        this(null);
    }

    public LocationDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Location deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        String name = node.get("name").asText();
        double latitude = node.get("latitude").asDouble();
        double longitude = node.get("longitude").asDouble();

        return new Location(name, latitude, longitude);
    }
}
