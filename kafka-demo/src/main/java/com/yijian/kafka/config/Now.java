package com.yijian.kafka.config;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author heyueling
 */
public class Now {

    private static final Clock clock = Clock.systemUTC();

    public static long millis() {
        return clock.millis();
    }

    public static long seconds() {
        return seconds(millis());
    }

    public static long seconds(long millis) {
        return TimeUnit.MILLISECONDS.toSeconds(millis);
    }

    private static final ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    public static ZoneId getZoneId() {
        return zoneId;
    }

    public static String format(long millis, DateTimeFormatter formatter) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), getZoneId()).format(formatter);
    }

    public static long parse(String text, DateTimeFormatter formatter) {
        return LocalDateTime.parse(text, formatter).atZone(getZoneId()).toInstant().toEpochMilli();
    }
}
