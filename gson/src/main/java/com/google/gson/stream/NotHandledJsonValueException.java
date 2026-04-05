package com.google.gson.stream;

import java.io.IOException;

public final class NotHandledJsonValueException extends IOException {

    public NotHandledJsonValueException(String message) {
        super(message);
    }
}
