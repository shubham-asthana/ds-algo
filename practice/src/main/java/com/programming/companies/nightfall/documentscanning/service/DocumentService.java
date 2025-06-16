package com.programming.companies.nightfall.documentscanning.service;

import java.util.List;

public interface DocumentService {

    // Adds a document to be scanned, returns a unique document ID
    String addDocument(String documentContent);

    // Returns the classification label of a document (e.g. "PII", "Financial",
    // "General")
    String classifyDocument(String documentId);

    // Deletes a document by ID
    boolean deleteDocument(String documentId);

    // Returns the list of all document IDs currently stored
    List<String> listDocuments();
}
