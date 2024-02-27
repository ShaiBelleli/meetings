package com.shaibal.meetings.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class CustomIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "Meeting_";
    private static final int MAX_RANDOM_ATTEMPTS = 1000;  // Adjust as needed
    private static final Set<String> usedIds = new HashSet<>();

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Random random = new Random();
        int numberOfDigits = 19;
        long randomSuffix;
        String generatedId;

        int attempts = 0;
        do {
            long lowerBound = 1000000000000000000L; // 19 digits
            long upperBound = (long) Math.pow(10, numberOfDigits);

            randomSuffix = Math.abs(lowerBound + random.nextLong() % (upperBound - lowerBound));
            generatedId = PREFIX + randomSuffix;
            attempts++;
        } while (usedIds.contains(generatedId) && attempts < MAX_RANDOM_ATTEMPTS);

        if (attempts >= MAX_RANDOM_ATTEMPTS) {
            throw new IllegalStateException("Unable to generate a unique ID after " + MAX_RANDOM_ATTEMPTS + " attempts.");
        }

        usedIds.add(generatedId);
        return generatedId;
    }
}