package com.example.likelionassignmentcrud.session.application;

import com.example.likelionassignmentcrud.session.api.dto.request.SessionSaveRequestDto;
import com.example.likelionassignmentcrud.session.api.dto.response.SessionInfoResponseDto;
import com.example.likelionassignmentcrud.session.api.dto.response.SessionListResponseDto;
import com.example.likelionassignmentcrud.session.domain.model.Session;
import com.example.likelionassignmentcrud.session.domain.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SessionService {

    private final SessionRepository sessionRepository;

    // 공부 세션 저장
    @Transactional
    public void sessionSave(SessionSaveRequestDto sessionSaveRequestDto) {
        Session session = Session.builder()
                .subject(sessionSaveRequestDto.subject())
                .duration(sessionSaveRequestDto.duration())
                .completedAt(sessionSaveRequestDto.completedAt())
                .build();
        sessionRepository.save(session);
    }

    // 모든 공부 세션 조회
    public SessionListResponseDto sessionFindAll() {
        List<Session> sessions = sessionRepository.findAll();
        List<SessionInfoResponseDto> responseDtoList = sessions.stream()
                .map(SessionInfoResponseDto::from)
                .toList();
        return SessionListResponseDto.from(responseDtoList);
    }

    // 단일 공부 세션 조회
    public SessionInfoResponseDto sessionFindOne(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(IllegalArgumentException::new);
        return SessionInfoResponseDto.from(session);
    }
}