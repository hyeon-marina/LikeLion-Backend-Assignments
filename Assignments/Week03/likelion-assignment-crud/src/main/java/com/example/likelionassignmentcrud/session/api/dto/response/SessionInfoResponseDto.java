package com.example.likelionassignmentcrud.session.api.dto.response;

import com.example.likelionassignmentcrud.session.domain.model.Session;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SessionInfoResponseDto(
        String subject,
        int duration,
        LocalDateTime completedAt
) {
    public static SessionInfoResponseDto from(Session session) {
        return SessionInfoResponseDto.builder()
                .subject(session.getSubject())
                .duration(session.getDuration())
                .completedAt(session.getCompletedAt())
                .build();
    }
}