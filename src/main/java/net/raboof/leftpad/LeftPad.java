package net.raboof.leftpad;

import java.util.function.Function;

/**
 * Pad a string on the left-hand-side with a designated character
 */
public class LeftPad implements Function<CharSequence, String> {
    private final int length;
    private final char fill;

    /**
     * Create an instance which can be applied to any number of input strings.
     *
     * @param length how long a padded-out string should be.
     * @param fill   what character to fill in if the input string is shorter than the length
     */
    public LeftPad(int length, char fill) {
        this.length = length;
        this.fill = fill;
    }

    /**
     * Pads out strings with a space character
     */
    public LeftPad(int length) {
        this(length, ' ');
    }


    /**
     * Apply the padding policy to an input string
     *
     * @param inputString the string to pad
     * @return the padded string
     * @throws NullPointerException if the input is null
     */
    public String apply(CharSequence inputString) {
        StringBuilder output = new StringBuilder();

        int len = length - Character.codePointCount(inputString, 0, inputString.length());

        for (int i = 0; i < len; i++) {
            output.append(fill);
        }

        output.append(inputString);

        return output.toString();
    }
}
