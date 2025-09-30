package com.programming.companies.intercom.assignmentsystem;

public class Agent {

    String name;
    int limit = 2;
    int current = 0;
    long lastAssigned = -1L;
    int initIndex;

    public Agent(String name, int initIndex) {
        this.name = name;
        this.initIndex = initIndex;
    }

    public Agent copy() {
        Agent agent = new Agent(this.name, this.initIndex);
        agent.limit = this.limit;
        agent.current = this.current;
        agent.lastAssigned = this.lastAssigned;
        return agent;
    }
}
