package com.programming.companies.nightfall.practice.dataclassification.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.programming.companies.nightfall.practice.dataclassification.Category;
import com.programming.companies.nightfall.practice.dataclassification.service.DataClassifier;

public class RuleBasedDataClassifier implements DataClassifier {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\b[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}\\b",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\b\\d{3}-?\\d{3}-?\\d{4}\\b");
    private static final Pattern CREDIT_CARD_PATTERN = Pattern.compile("\\b(?:\\d[ -]*?){13,16}\\b");
    private static final Pattern FINANCIAL_PATTERN = Pattern.compile("\\b(account|loan|credit|investment|bank)\\b",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern HEALTH_PATTERN = Pattern
            .compile("\\b(diagnosis|medical|prescription|doctor|health)\\b", Pattern.CASE_INSENSITIVE);

    private final Map<Category, List<Pattern>> patternsByCategory = new HashMap<>();

    public RuleBasedDataClassifier() {
        patternsByCategory.put(Category.PII, Arrays.asList(EMAIL_PATTERN, PHONE_NUMBER_PATTERN));
        patternsByCategory.put(Category.FINANCIAL, Arrays.asList(CREDIT_CARD_PATTERN, FINANCIAL_PATTERN));
        patternsByCategory.put(Category.HEALTH, Arrays.asList(HEALTH_PATTERN));
    }

    @Override
    public Set<Category> classifyData(String inputText) {
        if (StringUtils.isBlank(inputText))
            throw new IllegalArgumentException("Invalid input. Input cannot be null or blank");
        Set<Category> categories = new HashSet<>();
        for (Map.Entry<Category, List<Pattern>> map : patternsByCategory.entrySet()) {
            Category category = map.getKey();
            List<Pattern> patterns = map.getValue();
            for (Pattern pattern : patterns) {
                Matcher matcher = pattern.matcher(inputText);
                if (matcher.find()) {
                    categories.add(category);
                    break;
                }
            }
        }
        if (categories.isEmpty())
            categories.add(Category.OTHER);

        return categories;
    }
}
