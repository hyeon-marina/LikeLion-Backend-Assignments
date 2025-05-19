package com.example.likelionassignmentcrud.feedback.api.dto.response;

import com.example.likelionassignmentcrud.feedback.api.domain.model.Feedback;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FeedbackInfoResponseDto(
        String message,
        LocalDateTime createdAt,
        String sessionSubject
) {
    public static FeedbackInfoResponseDto from(Feedback feedback) {
        return FeedbackInfoResponseDto.builder()
                .message(feedback.getMessage())
                .createdAt(feedback.getCreatedAt())
                .sessionSubject(feedback.getSession().getSubject()) //fetch join으로 인해 즉시 로딩됨
                .build();
    }
}