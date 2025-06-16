package com.programming.companies.nightfall.practice.todo.dto;

import java.time.Instant;

import org.apache.commons.lang3.StringUtils;

public class TodoDto {

    private final Long id;
    private String title;
    private String description;
    private boolean isCompleted;
    private Instant createdAt;
    private Instant updatedAt;

    public TodoDto(Long id, String title, String description, boolean isCompleted, Instant createdAt,
            Instant updatedAt) {
        if (StringUtils.isBlank(title)) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        this.id = id;
        this.title = title;
        this.description = null == description ? "" : description;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (StringUtils.isBlank(title)) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = null == description ? "" : description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "TodoDto [id=" + id + ", title=" + title + ", description=" + description + ", isCompleted="
                + isCompleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }
}
