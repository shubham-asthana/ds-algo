package com.programming.companies.nightfall.documentscanning.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.programming.companies.nightfall.documentscanning.service.DocumentService;

public class DocumentServiceImpl implements DocumentService {

    Map<String, String> documents = new HashMap<>();

    @Override
    public String addDocument(String documentContent) {
        String documentId = UUID.randomUUID().toString();
        documents.put(documentId, documentContent);
        return documentId;
    }

    @Override
    public String classifyDocument(String documentId) {
        String documentType = StringUtils.EMPTY;
        if (documents.containsKey(documentId)) {
            String documentContent = documents.get(documentId);
            if (StringUtils.containsIgnoreCase(documentContent, "SSN")
                    || StringUtils.containsIgnoreCase(documentContent, "credit card")) {
                documentType = "PII";
            } else if (StringUtils.containsIgnoreCase(documentContent, "invoice")
                    || StringUtils.containsIgnoreCase(documentContent, "payment")) {
                documentType = "Financial";
            } else {
                documentType = "General";
            }
        } else {
            // log document does not exist
        }
        return documentType;
    }

    @Override
    public boolean deleteDocument(String documentId) {
        return documents.remove(documentId) != null;
    }

    @Override
    public List<String> listDocuments() {
        return new ArrayList<>(documents.keySet());
    }
}
