package com.google.gson.internal.bind.util;

import java.util.TimeZone;

public class ParsedTimeZone {
    int offset;
    TimeZone timezone;

    ParsedTimeZone(int offset, TimeZone timezone) {
        this.offset = offset;
        this.timezone = timezone;
    }

    int getOffset() {
        return offset;
    }

    TimeZone getTimezone() {
        return timezone;
    }
}
