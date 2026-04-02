package com.google.gson.internal.bind.util;

public class ParsedTime {

    int offset;
    int hour;
    int minutes;
    int seconds;
    int milliseconds;

    ParsedTime(int offset, int hour, int minutes, int seconds, int milliseconds) {
        this.offset = offset;
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    int getOffset() {
        return offset;
    }

    int getHour() {
        return hour;
    }

    int getMinutes() {
        return minutes;
    }

    int getSeconds() {
        return seconds;
    }

    int getMilliseconds() {
        return milliseconds;
    }
}
