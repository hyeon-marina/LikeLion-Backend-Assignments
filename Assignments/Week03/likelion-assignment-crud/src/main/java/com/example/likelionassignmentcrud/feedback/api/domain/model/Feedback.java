package com.example.likelionassignmentcrud.feedback.api.domain.model;

import com.example.likelionassignmentcrud.session.domain.model.Session;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")

    private Long id;

    private String message;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")

    private Session session;

    @Builder
    private Feedback(String message, LocalDateTime createdAt, Session session) {
        this.message = message;
        this.createdAt = createdAt;
        this.session = session;
    }


}
