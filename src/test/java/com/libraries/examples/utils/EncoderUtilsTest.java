package com.libraries.examples.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EncoderUtilsTest {

    @Test
    void generatedEncoder_isOk() {
        assertNotNull(EncoderUtils.generatedEncoder("VAluesTeste"));
        assertEquals("",EncoderUtils.generatedEncoder(""));
    }
}