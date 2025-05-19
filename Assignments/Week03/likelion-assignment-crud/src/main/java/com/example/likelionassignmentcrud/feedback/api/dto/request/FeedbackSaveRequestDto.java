package com.example.likelionassignmentcrud.feedback.api.dto.request;

public record FeedbackSaveRequestDto(
        Long sessionId,
        String message
) {
}
