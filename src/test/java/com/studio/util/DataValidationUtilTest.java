package com.studio.util;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataValidationUtilTest {

    @Test
    public void testValidEmail() {
        String emailAddress = "username@domain.com";
        assertTrue(DataValidationUtil.isValidEmail(emailAddress));
    }

    @Test
    public void testInvalidEmail() {
        String emailAddress = "username@domain.com123";
        assertFalse(DataValidationUtil.isValidEmail(emailAddress));
    }

    @Test
    public void testIsValidName() {
        String name = "Test My Name";
        assertTrue(DataValidationUtil.isValidName(name));
    }

    @Test
    public void testIsInvalidName() {
        String name = "Test My Name 123";
        assertFalse(DataValidationUtil.isValidName(name));
    }
}
