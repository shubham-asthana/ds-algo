package com.programming.companies.intercom.assignmentsystem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AssignmentSystemDemo {

    public static Comparator<Agent> agentComparator = (a, b) -> {
        if (a.current != b.current)
            return Integer.compare(a.current, b.current);
        if (a.lastAssigned != b.lastAssigned)
            return Long.compare(a.lastAssigned, b.lastAssigned);
        return Integer.compare(a.initIndex, b.initIndex);
    };

    public static void main(String[] args) {
        List<String> agents = Arrays.asList("Alice", "Bob", "Charlie");

        System.out.println("=== BruteAssignmentSystem demo ===");
        BruteForceAssignmentSystem brute = new BruteForceAssignmentSystem(agents);
        brute.setLimit("Bob", 4);
        brute.setLimit("Charlie", 3);
        System.out.println("Preview next 4 (brute): " + brute.previewAssignments(4)); // expected [Alice, Bob, Charlie,
                                                                                      // Alice]

        System.out.println("\nAssigning 4 conversations (brute):");
        for (int i = 1; i <= 4; i++) {
            String conv = "conv-" + i;
            String assigned = brute.assign(conv);
            System.out.println(conv + " -> " + assigned);
        }

        System.out.println("\n=== OptimalAssignmentSystem demo ===");
        OptimalAssignmentSystem opt = new OptimalAssignmentSystem(agents);
        opt.setLimit("Bob", 4);
        opt.setLimit("Charlie", 3);
        System.out.println("Preview next 4 (optimal): " + opt.previewAssignments(4)); // expected [Alice, Bob, Charlie,
                                                                                      // Alice]

        System.out.println("\nAssigning 4 conversations (optimal):");
        for (int i = 1; i <= 4; i++) {
            String conv = "c-" + i;
            String assigned = opt.assign(conv);
            System.out.println(conv + " -> " + assigned);
        }
    }
}
