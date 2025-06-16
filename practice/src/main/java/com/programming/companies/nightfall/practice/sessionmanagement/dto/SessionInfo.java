package com.programming.companies.nightfall.practice.sessionmanagement.dto;

import java.time.Instant;

public class SessionInfo {

    long userId;
    Instant creationTime;

    public SessionInfo(long userId, Instant creationTime) {
        this.userId = userId;
        this.creationTime = creationTime;
    }

    public long getUserId() {
        return userId;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (userId ^ (userId >>> 32));
        result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SessionInfo other = (SessionInfo) obj;
        if (userId != other.userId)
            return false;
        if (creationTime == null) {
            if (other.creationTime != null)
                return false;
        } else if (!creationTime.equals(other.creationTime))
            return false;
        return true;
    }
}
