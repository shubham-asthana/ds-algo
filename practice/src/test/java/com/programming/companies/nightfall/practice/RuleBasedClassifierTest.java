package com.programming.companies.nightfall.practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.programming.companies.nightfall.practice.dataclassification.Category;
import com.programming.companies.nightfall.practice.dataclassification.service.DataClassifier;
import com.programming.companies.nightfall.practice.dataclassification.service.impl.RuleBasedDataClassifier;

public class RuleBasedClassifierTest {

    private DataClassifier dataClassifier;

    @BeforeEach
    void setup() {
        dataClassifier = new RuleBasedDataClassifier();
    }

    @Test
    void testPiiText() {
        String piiText = "Email: shubham@gmail.com, Phone: 789-569-1234";
        assertTrue(dataClassifier.classifyData(piiText).contains(Category.PII));
        assertFalse(dataClassifier.classifyData(piiText).contains(Category.OTHER));
    }

    @Test
    void testFinancialText() {
        String finanicalText = "Credit card: 7894-5698-1223-7894. Pay using your bank account";
        assertTrue(dataClassifier.classifyData(finanicalText).contains(Category.FINANCIAL));
        assertFalse(dataClassifier.classifyData(finanicalText).contains(Category.HEALTH));
    }

    @Test
    void testHealthText() {
        String healthText = "Your prescription from the doctor is ready. Keep a check on your health. Email: shubham@gmail.com";
        assertTrue(dataClassifier.classifyData(healthText).contains(Category.HEALTH));
        assertTrue(dataClassifier.classifyData(healthText).contains(Category.PII));
    }

    @Test
    void testOtherText() {
        String otherText = "Some general text";
        assertTrue(dataClassifier.classifyData(otherText).contains(Category.OTHER));
        assertFalse(dataClassifier.classifyData(otherText).contains(Category.PII));
    }

    @Test
    void testInvalidText() {
        assertThrows(IllegalArgumentException.class, () -> dataClassifier.classifyData(null));
        assertThrows(IllegalArgumentException.class, () -> dataClassifier.classifyData(""));
    }
}
