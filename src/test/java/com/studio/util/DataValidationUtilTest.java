package com.studio.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataValidationUtilTest {

    @Test
    void testValidEmail() {
        String emailAddress = "username@domain.com";
        assertTrue(DataValidationUtil.isValidEmail(emailAddress));
    }

    @Test
    void testInvalidEmail() {
        String emailAddress = "username@domain.com123";
        assertFalse(DataValidationUtil.isValidEmail(emailAddress));
    }

    @Test
    void testIsValidName() {
        String name = "Test My Name";
        assertTrue(DataValidationUtil.isValidName(name));
    }

    @Test
    void testIsInvalidName() {
        String name = "Test My Name 123";
        assertFalse(DataValidationUtil.isValidName(name));
    }
}
