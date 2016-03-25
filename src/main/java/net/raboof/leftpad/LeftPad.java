package net.raboof.leftpad;

import java.util.function.Function;

public class LeftPad implements Function<CharSequence, String> {
    private final int length;
    private final char fill;

    public LeftPad(int length, char fill) {
        this.length = length;
        this.fill = fill;
    }

    public LeftPad(int length) {
        this(length, ' ');
    }

    public String apply(CharSequence inputString) {
        StringBuilder output = new StringBuilder();

        int i = -1;

        int len = length - inputString.length();

        while (++i < len) {
            output.append(fill);
        }

        output.append(inputString);

        return output.toString();
    }
}
