package com.programming.companies.intercom.assignmentsystem;

import java.util.List;

public interface AssignmentSystem {

    void setLimit(String agentName, int limit);

    String assign(String conversationId);

    List<String> previewAssignments(int count);
}
