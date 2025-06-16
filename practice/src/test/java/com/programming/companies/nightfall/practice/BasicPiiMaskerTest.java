package com.programming.companies.nightfall.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.programming.companies.nightfall.practice.piimasking.service.PiiMasker;
import com.programming.companies.nightfall.practice.piimasking.service.impl.BasicPiiMasker;

public class BasicPiiMaskerTest {

    private PiiMasker piiMasker;

    @BeforeEach
    void setup() {
        piiMasker = new BasicPiiMasker();
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> piiMasker.mask(null));
        assertThrows(IllegalArgumentException.class, () -> piiMasker.mask(""));
    }

    @Test
    void testMaskEmail() {
        String inputText = "Email: shubham@gmail.com";
        assertEquals("Email: *****************", piiMasker.mask(inputText));
    }

    @Test
    void testMaskPhoneSSN() {
        String inputText = "Contact: 1234567894 and SSN: 123-23-7895";
        assertEquals("Contact: ********** and SSN: ***********", piiMasker.mask(inputText));
    }

    @Test
    void testMaskCreditCard() {
        String inputText = "Credit Card: 3798-681445-11006";
        assertEquals("Credit Card: *****************", piiMasker.mask(inputText));
    }

    @Test
    void testNoMask() {
        assertEquals("I am Shubham", piiMasker.mask("I am Shubham"));
    }
}
