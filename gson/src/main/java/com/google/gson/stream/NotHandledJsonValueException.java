package com.google.gson.stream;

import java.io.IOException;

public final class NotHandledJsonValueException extends IOException {

    // to avoid error : "serializable class com.google.gson.stream.NotHandledJsonValueException has no definition of serialVersionUID"
    private static final long serialVersionUID = 1L;

    public NotHandledJsonValueException(String message) {
        super(message);
    }
}
