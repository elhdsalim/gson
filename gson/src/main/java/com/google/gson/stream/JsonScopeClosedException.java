package com.google.gson.stream;

public final class JsonScopeClosedException extends IllegalStateException {

    // to avoid error : "serializable class com.google.gson.stream.JsonScopeClosedException has no definition of serialVersionUID"
    private static final long serialVersionUID = 1L;

    public JsonScopeClosedException(String message) {
        super(message);
    }
}
