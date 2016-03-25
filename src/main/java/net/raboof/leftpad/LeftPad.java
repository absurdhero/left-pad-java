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

        int len = length - Character.codePointCount(inputString, 0, inputString.length());

        for(int i = 0; i < len; i++) {
            output.append(fill);
        }

        output.append(inputString);

        return output.toString();
    }
}
