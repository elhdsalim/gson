package com.google.gson.internal.bind;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

abstract class AbstractNestingAdapter<T> {
    protected T readNestingValue(JsonReader in) throws IOException {
        // Either JsonArray or JsonObject
        T current;
        JsonToken peeked = in.peek();

        current = tryBeginNesting(in, peeked);
        if (current == null) {
            return readTerminal(in, peeked);
        }

        Deque<T> stack = new ArrayDeque<>();

        while (true) {
            while (in.hasNext()) {
                String name = null;
                // Name is only used for JSON object members
                if (isInstanceOf(current)) {
                    name = in.nextName();
                }

                peeked = in.peek();
                T value = tryBeginNesting(in, peeked);
                boolean isNesting = value != null;

                if (value == null) {
                    value = readTerminal(in, peeked);
                }

                add(current, name, value);

                if (isNesting) {
                    stack.addLast(current);
                    current = value;
                }
            }

            // End current element
            endHandling(in, current);

            if (stack.isEmpty()) {
                return current;
            } else {
                // Continue with enclosing element
                current = stack.removeLast();
            }
        }
    }

    abstract T tryBeginNesting(JsonReader in, JsonToken peeked) throws IOException;
    abstract T readTerminal(JsonReader in, JsonToken peeked) throws IOException;
    abstract boolean isInstanceOf(T value);
    abstract void add(T current, String name, T value);
    abstract void endHandling(JsonReader in, T current) throws IOException;
}
