package com.abdelhalim.egypt.clinics.utils;

import org.springframework.lang.NonNull;

import java.util.UUID;

public class RandomUtils {
    private RandomUtils() {
    }

    @NonNull
    public static Long getRandomLong() {
        return (UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
    }
}
