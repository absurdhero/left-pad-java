package net.raboof.leftpad;


import org.junit.Test;

import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class LeftPadTest {

    @Test
    public void noPad_whenSameLengthAsString() {
        assertEquals("foo", new LeftPad(3).apply("foo"));
    }

    @Test
    public void noPad_whenLengthSmallerThanString() {
        assertEquals("foo", new LeftPad(1).apply("foo"));
    }

    @Test
    public void padOne_whenLengthOneLongerThanString() {
        assertEquals(" foo", new LeftPad(4).apply("foo"));
    }

    @Test
    public void padTwo_whenLengthTwoLongerThanString() {
        assertEquals("  foobar", new LeftPad(8).apply("foobar"));
    }

    @Test
    public void emptyString_whenZeroPaddingEmptyString() {
        assertEquals("", new LeftPad(0).apply(""));
    }


    @Test
    public void pad0_whenFillSetToZero() {
        assertEquals("00foobar", new LeftPad(8, '0').apply("foobar"));
    }

    @Test
    public void padToLength_whenMultiByteInput() {
        assertEquals("X\uD83D\uDCA9\uD83D\uDCA9", new LeftPad(3, 'X').apply("\uD83D\uDCA9\uD83D\uDCA9"));
    }

    @Test
    public void modifyElementsInStream_whenPadded() {
        assertEquals(
                asList(" x", " y", " z"),
                asList("x", "y", "z").stream().map(new LeftPad(2)).collect(Collectors.toList()));
    }
}