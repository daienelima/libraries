package com.libraries.examples.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsUtilsTest {

    @Test
    void leftZeros_isOk() {
        assertEquals("", StringsUtils.leftZeros("",4));
        assertEquals("0001", StringsUtils.leftZeros("1",4));
    }
}