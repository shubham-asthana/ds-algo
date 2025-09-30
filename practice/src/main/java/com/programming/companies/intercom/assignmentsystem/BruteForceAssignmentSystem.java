package com.programming.companies.intercom.assignmentsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BruteForceAssignmentSystem implements AssignmentSystem {

    private final Map<String, Agent> agentsByName = new LinkedHashMap<>();
    private long seq = 0L;
    private final Map<String, String> conversationToAgent = new HashMap<>();

    public BruteForceAssignmentSystem(List<String> agentNames) {
        int i = 0;
        for (String name : agentNames)
            agentsByName.put(name, new Agent(name, i + 1));
    }

    @Override
    public void setLimit(String agentName, int limit) {
        Agent agent = agentsByName.get(agentName);
        if (null == agent)
            throw new IllegalArgumentException("Unknow agent: " + agent);
        agent.limit = limit;
    }

    @Override
    public String assign(String conversationId) {
        Agent assigned = null;
        for (Agent agent : agentsByName.values()) {
            if (agent.current >= agent.limit)
                continue;
            if (null == assigned || AssignmentSystemDemo.agentComparator.compare(agent, assigned) < 0)
                assigned = agent;
        }
        if (null == assigned)
            return null;
        assigned.current += 1;
        assigned.lastAssigned = seq++;
        conversationToAgent.put(conversationId, assigned.name);
        return assigned.name;
    }

    @Override
    public List<String> previewAssignments(int count) {
        List<Agent> list = new ArrayList<>();
        for (Agent agent : agentsByName.values())
            list.add(agent.copy());
        List<String> res = new ArrayList<>();
        long localSeq = seq;
        for (int i = 0; i < count; i++) {
            Agent best = null;
            for (Agent agent : list) {
                if (agent.current >= agent.limit)
                    continue;
                if (best == null || AssignmentSystemDemo.agentComparator.compare(agent, best) < 0)
                    best = agent;
            }
            if (best == null)
                break;
            res.add(best.name);
            best.current += 1;
            best.lastAssigned = localSeq++;
        }
        return res;
    }
}
