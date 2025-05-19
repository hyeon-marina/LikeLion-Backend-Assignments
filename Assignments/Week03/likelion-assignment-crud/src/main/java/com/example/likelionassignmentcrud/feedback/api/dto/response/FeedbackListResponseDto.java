package com.example.likelionassignmentcrud.feedback.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record FeedbackListResponseDto(
        List<FeedbackInfoResponseDto> feedbacks
) {
    public static FeedbackListResponseDto from(List<FeedbackInfoResponseDto> feedbacks) {
        return FeedbackListResponseDto.builder()
                .feedbacks(feedbacks)
                .build();
    }
}