package com.programming.companies.intercom.assignmentsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class OptimalAssignmentSystem implements AssignmentSystem {

    private final Map<String, Agent> agentsByName = new LinkedHashMap<>();
    private final PriorityQueue<Agent> heap;
    private long seq = 0L;
    private final Map<String, String> conversationToAgent = new HashMap<>();

    public OptimalAssignmentSystem(List<String> agentNames) {
        int i = 0;
        for (String name : agentNames)
            agentsByName.put(name, new Agent(name, i++));
        // PriorityQueue uses comparator over current live Agent objects
        heap = new PriorityQueue<>(AssignmentSystemDemo.agentComparator);
        heap.addAll(agentsByName.values());
    }

    @Override
    public void setLimit(String agentName, int limit) {
        Agent agent = agentsByName.get(agentName);
        if (agent == null)
            throw new IllegalArgumentException("Unknown agent: " + agentName);
        agent.limit = limit;
    }

    @Override
    public String assign(String conversationId) {
        List<Agent> skipped = new ArrayList<>();
        Agent selected = null;
        while (!heap.isEmpty()) {
            Agent cand = heap.poll();
            if (cand.current >= cand.limit) {
                skipped.add(cand);
                continue;
            }
            selected = cand;
            break;
        }
        heap.addAll(skipped);
        if (selected == null)
            return null;
        selected.current += 1;
        selected.lastAssigned = seq++;
        conversationToAgent.put(conversationId, selected.name);
        // push back to heap with updated priority
        heap.offer(selected);
        return selected.name;
    }

    @Override
    public List<String> previewAssignments(int count) {
        PriorityQueue<Agent> localHeap = new PriorityQueue<>(AssignmentSystemDemo.agentComparator);
        for (Agent agent : agentsByName.values())
            localHeap.offer(agent.copy());
        List<String> res = new ArrayList<>();
        long localSeq = seq;
        for (int i = 0; i < count; i++) {
            Agent selected = null;
            List<Agent> skipped = new ArrayList<>();
            while (!localHeap.isEmpty()) {
                Agent cand = localHeap.poll();
                if (cand.current >= cand.limit) {
                    skipped.add(cand);
                    continue;
                }
                selected = cand;
                break;
            }
            localHeap.addAll(skipped);
            if (selected == null)
                break;
            res.add(selected.name);
            selected.current += 1;
            selected.lastAssigned = localSeq++;
            localHeap.offer(selected);
        }
        return res;
    }
}
