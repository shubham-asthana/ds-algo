package com.programming.companies.nightfall.practice.piimasking.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.programming.companies.nightfall.practice.piimasking.service.PiiMasker;

public class BasicPiiMasker implements PiiMasker {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\b[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}\\b");
    private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile("\\b(?:\\d[ -]*?){13,16}\\b");
    private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile("\\b\\d{3}-?\\d{3}-?\\d{4}\\b");
    private static final Pattern SSN_PATTERN = Pattern.compile("\\b\\d{3}-?\\d{2}-?\\d{4}\\b");

    private static final List<Pattern> patterns = Arrays.asList(EMAIL_PATTERN, CREDIT_CARD_PATTERN,
            MOBILE_NUMBER_PATTERN, SSN_PATTERN);

    @Override
    public String mask(String inputText) {
        if (StringUtils.isBlank(inputText))
            throw new IllegalArgumentException("Invalid input. Input string cannot be null or blank");
        String maskedText = inputText;
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(maskedText);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String matched = matcher.group();
                String replacedString = replace('*', matched.length());
                matcher.appendReplacement(sb, replacedString);
            }
            matcher.appendTail(sb);
            maskedText = sb.toString();
        }
        return maskedText;
    }

    private String replace(char ch, int length) {
        char[] charArr = new char[length];
        Arrays.fill(charArr, ch);
        return new String(charArr);
    }
}
