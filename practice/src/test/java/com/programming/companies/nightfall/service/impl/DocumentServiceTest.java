package com.programming.companies.nightfall.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.programming.companies.nightfall.documentscanning.service.DocumentService;
import com.programming.companies.nightfall.documentscanning.service.impl.DocumentServiceImpl;

public class DocumentServiceTest {

    private DocumentService documentService;

    @BeforeEach
    void setup() {
        documentService = new DocumentServiceImpl();
    }

    @Test
    void testAddAndListDocuments() {
        String id1 = documentService.addDocument("My SSN is 1234-4567-8910");
        String id2 = documentService.addDocument("Invoice for payment due");
        assertEquals(2, documentService.listDocuments().size());
        assertTrue(documentService.listDocuments().contains(id1));
        assertTrue(documentService.listDocuments().contains(id2));
    }

    @Test
    void testDeleteDocument() {
        String id = documentService.addDocument("Document to be deleted");
        assertTrue(documentService.deleteDocument(id));
        assertFalse(documentService.listDocuments().contains(id));
        assertFalse(documentService.deleteDocument(id));
    }

    @Test
    void testClassifyDocument() {
        String id1 = documentService.addDocument("Credit card no: 1234-4568-7890-1123");
        String id2 = documentService.addDocument("Invoice #12312");
        String id3 = documentService.addDocument("Some Generic document");

        assertEquals("PII", documentService.classifyDocument(id1));
        assertEquals("Financial", documentService.classifyDocument(id2));
        assertEquals("General", documentService.classifyDocument(id3));
    }
}
