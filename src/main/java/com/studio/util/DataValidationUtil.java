package com.studio.util;

import io.micrometer.common.util.StringUtils;

import java.util.regex.Pattern;

public class DataValidationUtil {

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean isValidEmail(final String emailAddress) {
        if (StringUtils.isBlank(emailAddress)) {
            return false;
        }
        final String regexPattern =
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return patternMatches(emailAddress, regexPattern);
    }
    public static boolean isValidName(final String name) {
        if (StringUtils.isBlank(name)) {
            return false;
        }
        final String regexPattern = "^[a-zA-Z._\\s]{1,255}$";
        return patternMatches(name, regexPattern);
    }
}
