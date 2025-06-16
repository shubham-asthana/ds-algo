package com.programming.companies.nightfall.practice.dataclassification.service;

import java.util.Set;

import com.programming.companies.nightfall.practice.dataclassification.Category;

public interface DataClassifier {

    Set<Category> classifyData(String inputText);
}
