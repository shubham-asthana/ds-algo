package com.programming.companies.nightfall.practice.dataclassification;

import com.programming.companies.nightfall.practice.dataclassification.service.DataClassifier;
import com.programming.companies.nightfall.practice.dataclassification.service.impl.RuleBasedDataClassifier;

public class Driver {

    public static void main(String[] args) {
        DataClassifier dataClassifier = new RuleBasedDataClassifier();
        String piiText = "Email: shubham@gmail.com, Phone: 789-569-1234";
        System.out.println(dataClassifier.classifyData(piiText).contains(Category.PII));
        String finanicalText = "Credit card: 7894-5698-1223-7894. Pay using your bank account";
        System.out.println(dataClassifier.classifyData(finanicalText).contains(Category.FINANCIAL));
        String healthText = "Your prescription from the doctor is ready. Keep a check on your health";
        System.out.println(dataClassifier.classifyData(healthText).contains(Category.HEALTH));
        String otherText = "The quick brown fox jumps over the lazy dog";
        System.out.println(dataClassifier.classifyData(otherText).contains(Category.OTHER));
    }
}
