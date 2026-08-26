package Persistence.Json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Minimal, dependency-free JSON value model, parser and writer.
 *
 * The Save & Load system deliberately avoids Java's built-in object
 * serialization mechanism and avoids depending on a third-party JSON
 * library: the save file should represent game state as plain, structured
 * data rather than implementation details of Java classes (see
 * docs/SAVE_LOAD_DESIGN.md, section 7 - Serialization Strategy).
 *
 * This class only knows about JSON structure (objects, arrays, strings,
 * numbers, booleans, null). It has no knowledge of World, Hex, Unit, or any
 * other game model - that mapping lives entirely in the Persistence.*IO
 * classes.
 */
public final class Json {

    private Json() { }

    // ---------------------------------------------------------------
    // Value model
    // ---------------------------------------------------------------

    public static abstract class Value {
        public boolean isNull() { return false; }

        public Obj asObject() {
            if (this instanceof Obj obj) return obj;
            throw new IllegalStateException("Expected a JSON object but found " + describe());
        }

        public Arr asArray() {
            if (this instanceof Arr arr) return arr;
            throw new IllegalStateException("Expected a JSON array but found " + describe());
        }

        public String asString() {
            if (this instanceof Str str) return str.value;
            throw new IllegalStateException("Expected a JSON string but found " + describe());
        }

        public int asInt() {
            if (this instanceof Num num) return (int) Math.round(num.value);
            throw new IllegalStateException("Expected a JSON number but found " + describe());
        }

        public boolean asBoolean() {
            if (this instanceof Bool bool) return bool.value;
            throw new IllegalStateException("Expected a JSON boolean but found " + describe());
        }

        private String describe() { return getClass().getSimpleName(); }
    }

    public static final class Obj extends Value {
        private final Map<String, Value> members = new LinkedHashMap<>();

        public Obj put(String key, Value value) { members.put(key, value == null ? Null.INSTANCE : value); return this; }
        public Obj put(String key, String value) { return put(key, value == null ? Null.INSTANCE : new Str(value)); }
        public Obj put(String key, int value) { return put(key, new Num(value)); }
        public Obj put(String key, boolean value) { return put(key, new Bool(value)); }

        public boolean has(String key) { return members.containsKey(key) && !members.get(key).isNull(); }

        public Value get(String key) {
            Value value = members.get(key);
            if (value == null) throw new IllegalStateException("Missing required field: " + key);
            return value;
        }

        public String getString(String key) { return get(key).asString(); }
        public int getInt(String key) { return get(key).asInt(); }
        public boolean getBoolean(String key) { return get(key).asBoolean(); }
        public Obj getObject(String key) { return get(key).asObject(); }
        public Arr getArray(String key) { return get(key).asArray(); }

        public Integer getIntOrNull(String key) { return has(key) ? getInt(key) : null; }
        public String getStringOrNull(String key) { return has(key) ? getString(key) : null; }
        public int getIntOr(String key, int fallback) { return has(key) ? getInt(key) : fallback; }
        public boolean getBooleanOr(String key, boolean fallback) { return has(key) ? getBoolean(key) : fallback; }
        public Arr getArrayOrEmpty(String key) { return has(key) ? getArray(key) : new Arr(); }
        public Obj getObjectOrEmpty(String key) { return has(key) ? getObject(key) : new Obj(); }

        public Iterable<Map.Entry<String, Value>> entries() { return members.entrySet(); }
    }

    public static final class Arr extends Value {
        private final List<Value> items = new ArrayList<>();

        public Arr add(Value value) { items.add(value == null ? Null.INSTANCE : value); return this; }
        public int size() { return items.size(); }
        public Value get(int index) { return items.get(index); }
        public List<Value> items() { return items; }
    }

    public static final class Str extends Value {
        final String value;
        public Str(String value) { this.value = value; }
    }

    public static final class Num extends Value {
        final double value;
        public Num(double value) { this.value = value; }
    }

    public static final class Bool extends Value {
        final boolean value;
        public Bool(boolean value) { this.value = value; }
    }

    public static final class Null extends Value {
        public static final Null INSTANCE = new Null();
        private Null() { }
        @Override public boolean isNull() { return true; }
    }

    // ---------------------------------------------------------------
    // Parsing
    // ---------------------------------------------------------------

    /** @throws IllegalArgumentException if the text is not well-formed JSON. */
    public static Value parse(String text) {
        Parser parser = new Parser(text);
        Value value = parser.parseValue();
        parser.skipWhitespace();
        if (!parser.atEnd()) {
            throw new IllegalArgumentException("Unexpected trailing content at position " + parser.position);
        }
        return value;
    }

    private static final class Parser {
        private final String text;
        private int position;

        Parser(String text) { this.text = text; }

        boolean atEnd() { return position >= text.length(); }

        void skipWhitespace() {
            while (position < text.length() && Character.isWhitespace(text.charAt(position))) position++;
        }

        char peek() {
            if (position >= text.length()) throw new IllegalArgumentException("Unexpected end of JSON input");
            return text.charAt(position);
        }

        char next() {
            char c = peek();
            position++;
            return c;
        }

        void expect(char expected) {
            char actual = next();
            if (actual != expected) {
                throw new IllegalArgumentException(
                        "Expected '" + expected + "' but found '" + actual + "' at position " + (position - 1));
            }
        }

        Value parseValue() {
            skipWhitespace();
            char c = peek();
            return switch (c) {
                case '{' -> parseObject();
                case '[' -> parseArray();
                case '"' -> new Str(parseString());
                case 't', 'f' -> parseBoolean();
                case 'n' -> parseNull();
                default -> parseNumber();
            };
        }

        Obj parseObject() {
            expect('{');
            Obj obj = new Obj();
            skipWhitespace();
            if (peek() == '}') { position++; return obj; }
            while (true) {
                skipWhitespace();
                String key = parseString();
                skipWhitespace();
                expect(':');
                Value value = parseValue();
                obj.put(key, value);
                skipWhitespace();
                char c = next();
                if (c == '}') break;
                if (c != ',') throw new IllegalArgumentException("Expected ',' or '}' in object at position " + (position - 1));
            }
            return obj;
        }

        Arr parseArray() {
            expect('[');
            Arr arr = new Arr();
            skipWhitespace();
            if (peek() == ']') { position++; return arr; }
            while (true) {
                Value value = parseValue();
                arr.add(value);
                skipWhitespace();
                char c = next();
                if (c == ']') break;
                if (c != ',') throw new IllegalArgumentException("Expected ',' or ']' in array at position " + (position - 1));
            }
            return arr;
        }

        String parseString() {
            expect('"');
            StringBuilder builder = new StringBuilder();
            while (true) {
                char c = next();
                if (c == '"') break;
                if (c == '\\') {
                    char escaped = next();
                    switch (escaped) {
                        case '"' -> builder.append('"');
                        case '\\' -> builder.append('\\');
                        case '/' -> builder.append('/');
                        case 'b' -> builder.append('\b');
                        case 'f' -> builder.append('\f');
                        case 'n' -> builder.append('\n');
                        case 'r' -> builder.append('\r');
                        case 't' -> builder.append('\t');
                        case 'u' -> {
                            if (position + 4 > text.length()) {
                                throw new IllegalArgumentException("Truncated unicode escape at position " + position);
                            }
                            String hex = text.substring(position, position + 4);
                            position += 4;
                            builder.append((char) Integer.parseInt(hex, 16));
                        }
                        default -> throw new IllegalArgumentException("Unknown escape sequence: \\" + escaped);
                    }
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        }

        Bool parseBoolean() {
            if (text.startsWith("true", position)) { position += 4; return new Bool(true); }
            if (text.startsWith("false", position)) { position += 5; return new Bool(false); }
            throw new IllegalArgumentException("Invalid literal at position " + position);
        }

        Null parseNull() {
            if (text.startsWith("null", position)) { position += 4; return Null.INSTANCE; }
            throw new IllegalArgumentException("Invalid literal at position " + position);
        }

        Num parseNumber() {
            int start = position;
            if (peek() == '-') position++;
            if (position >= text.length() || !Character.isDigit(text.charAt(position))) {
                throw new IllegalArgumentException("Invalid number at position " + start);
            }
            while (position < text.length() && Character.isDigit(text.charAt(position))) position++;
            if (position < text.length() && text.charAt(position) == '.') {
                position++;
                while (position < text.length() && Character.isDigit(text.charAt(position))) position++;
            }
            if (position < text.length() && (text.charAt(position) == 'e' || text.charAt(position) == 'E')) {
                position++;
                if (position < text.length() && (text.charAt(position) == '+' || text.charAt(position) == '-')) position++;
                while (position < text.length() && Character.isDigit(text.charAt(position))) position++;
            }
            return new Num(Double.parseDouble(text.substring(start, position)));
        }
    }

    // ---------------------------------------------------------------
    // Writing (pretty-printed, stable key order)
    // ---------------------------------------------------------------

    public static String write(Value value) {
        StringBuilder builder = new StringBuilder();
        writeValue(value, builder, 0);
        return builder.toString();
    }

    private static void writeValue(Value value, StringBuilder builder, int indent) {
        if (value instanceof Obj obj) {
            writeObject(obj, builder, indent);
        } else if (value instanceof Arr arr) {
            writeArray(arr, builder, indent);
        } else if (value instanceof Str str) {
            writeString(str.value, builder);
        } else if (value instanceof Num num) {
            writeNumber(num.value, builder);
        } else if (value instanceof Bool bool) {
            builder.append(bool.value);
        } else {
            builder.append("null");
        }
    }

    private static void writeObject(Obj obj, StringBuilder builder, int indent) {
        if (isEmpty(obj)) { builder.append("{}"); return; }
        builder.append("{\n");
        int childIndent = indent + 1;
        boolean first = true;
        for (Map.Entry<String, Value> entry : obj.entries()) {
            if (!first) builder.append(",\n");
            first = false;
            indent(builder, childIndent);
            writeString(entry.getKey(), builder);
            builder.append(": ");
            writeValue(entry.getValue(), builder, childIndent);
        }
        builder.append("\n");
        indent(builder, indent);
        builder.append("}");
    }

    private static boolean isEmpty(Obj obj) {
        for (Map.Entry<String, Value> ignored : obj.entries()) return false;
        return true;
    }

    private static void writeArray(Arr arr, StringBuilder builder, int indent) {
        if (arr.size() == 0) { builder.append("[]"); return; }
        builder.append("[\n");
        int childIndent = indent + 1;
        for (int index = 0; index < arr.size(); index++) {
            if (index > 0) builder.append(",\n");
            indent(builder, childIndent);
            writeValue(arr.get(index), builder, childIndent);
        }
        builder.append("\n");
        indent(builder, indent);
        builder.append("]");
    }

    private static void writeString(String value, StringBuilder builder) {
        builder.append('"');
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '"' -> builder.append("\\\"");
                case '\\' -> builder.append("\\\\");
                case '\n' -> builder.append("\\n");
                case '\r' -> builder.append("\\r");
                case '\t' -> builder.append("\\t");
                default -> {
                    if (c < 0x20) {
                        builder.append(String.format("\\u%04x", (int) c));
                    } else {
                        builder.append(c);
                    }
                }
            }
        }
        builder.append('"');
    }

    private static void writeNumber(double value, StringBuilder builder) {
        if (value == Math.rint(value) && !Double.isInfinite(value)) {
            builder.append((long) value);
        } else {
            builder.append(value);
        }
    }

    private static void indent(StringBuilder builder, int level) {
        builder.append("  ".repeat(level));
    }
}