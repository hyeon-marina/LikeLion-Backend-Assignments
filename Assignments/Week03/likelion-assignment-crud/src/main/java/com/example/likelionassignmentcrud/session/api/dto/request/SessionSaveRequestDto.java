package com.example.likelionassignmentcrud.session.api.dto.request;

import java.time.LocalDateTime;

public record SessionSaveRequestDto(
        String subject,
        int duration,
        LocalDateTime completedAt
) {
}
