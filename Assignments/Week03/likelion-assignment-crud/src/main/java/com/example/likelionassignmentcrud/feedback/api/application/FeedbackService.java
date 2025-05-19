package com.example.likelionassignmentcrud.feedback.api.application;

import com.example.likelionassignmentcrud.feedback.api.dto.request.FeedbackSaveRequestDto;
import com.example.likelionassignmentcrud.feedback.api.dto.response.FeedbackInfoResponseDto;
import com.example.likelionassignmentcrud.feedback.api.dto.response.FeedbackListResponseDto;
import com.example.likelionassignmentcrud.feedback.api.domain.model.Feedback;
import com.example.likelionassignmentcrud.feedback.api.domain.repository.FeedbackRepository;
import com.example.likelionassignmentcrud.feedback.api.exception.FeedbackNotFoundException;
import com.example.likelionassignmentcrud.session.domain.model.Session;
import com.example.likelionassignmentcrud.session.domain.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FeedbackService {

    private final SessionRepository sessionRepository;
    private final FeedbackRepository feedbackRepository;

    // 피드백 저장
    @Transactional
    public void feedbackSave(FeedbackSaveRequestDto dto) {
        Session session = sessionRepository.findById(dto.sessionId())
                .orElseThrow(() -> new FeedbackNotFoundException("해당 세션을 찾을 수 없습니다."));
        Feedback feedback = Feedback.builder()
                .message(dto.message())
                .createdAt(LocalDateTime.now())
                .session(session)
                .build();

        feedbackRepository.save(feedback);
    }

    // 전체 피드백 조회
    public FeedbackListResponseDto feedbackFindAll() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        List<FeedbackInfoResponseDto> dtos = feedbacks.stream()
                .map(FeedbackInfoResponseDto::from)
                .toList();
        return FeedbackListResponseDto.from(dtos);
    }

    // 특정 세션의 피드백 목록 조회
    public FeedbackListResponseDto getFeedbacksBySession(Long sessionId) {
        Session session = getSessionOrThrow(sessionId);  // 👍 단일 책임화
        List<Feedback> feedbacks = feedbackRepository.findAllWithSession();
        List<FeedbackInfoResponseDto> dtos = feedbacks.stream()
                .map(FeedbackInfoResponseDto::from)
                .toList();

        return FeedbackListResponseDto.from(dtos);
    }

    // 💡 세션 유효성 검사는 별도 메서드로
    private Session getSessionOrThrow(Long sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new FeedbackNotFoundException("해당 세션을 찾을 수 없습니다."));
    }
}