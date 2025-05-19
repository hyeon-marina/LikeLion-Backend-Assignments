package com.example.likelionassignmentcrud.session.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record SessionListResponseDto(
        List<SessionInfoResponseDto> sessions
) {
    public static SessionListResponseDto from(List<SessionInfoResponseDto> sessions) {
        return SessionListResponseDto.builder()
                .sessions(sessions)
                .build();
    }
}