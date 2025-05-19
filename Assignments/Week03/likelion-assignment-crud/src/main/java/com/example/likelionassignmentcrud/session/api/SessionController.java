package com.example.likelionassignmentcrud.session.api;

import com.example.likelionassignmentcrud.session.api.dto.request.SessionSaveRequestDto;
import com.example.likelionassignmentcrud.session.api.dto.response.SessionInfoResponseDto;
import com.example.likelionassignmentcrud.session.api.dto.response.SessionListResponseDto;
import com.example.likelionassignmentcrud.session.application.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    // 세션 저장
    @PostMapping
    public ResponseEntity<String> sessionSave(@RequestBody SessionSaveRequestDto requestDto) {
        sessionService.sessionSave(requestDto);
        return new ResponseEntity<>("세션 저장 완료!", HttpStatus.CREATED);
    }

    // 전체 세션 조회
    @GetMapping
    public ResponseEntity<SessionListResponseDto> sessionFindAll() {
        SessionListResponseDto responseDto = sessionService.sessionFindAll();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 특정 세션 조회
    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionInfoResponseDto> sessionFindOne(@PathVariable Long sessionId) {
        SessionInfoResponseDto responseDto = sessionService.sessionFindOne(sessionId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}