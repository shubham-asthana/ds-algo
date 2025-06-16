package com.programming.companies.nightfall.practice.piimasking;

import com.programming.companies.nightfall.practice.piimasking.service.PiiMasker;
import com.programming.companies.nightfall.practice.piimasking.service.impl.BasicPiiMasker;

public class Driver {

    public static void main(String[] args) {
        PiiMasker piiMasker = new BasicPiiMasker();
        String inputText = "SSN: 123-45-6789, Phone: 800-555-1212 Card: 1234-5678-9012-3456 Contact: test@example.com \"Hello world!";
        System.out.println(piiMasker.mask(inputText));
    }
}
