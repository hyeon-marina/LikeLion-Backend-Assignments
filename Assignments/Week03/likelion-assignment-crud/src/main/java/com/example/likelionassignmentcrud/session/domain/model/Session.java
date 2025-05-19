package com.example.likelionassignmentcrud.session.domain.model;


import com.example.likelionassignmentcrud.feedback.api.domain.model.Feedback;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    private String subject;

    private int duration;

    private LocalDateTime completedAt;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks = new ArrayList<>();

    @Builder
    private Session(String subject, int duration, LocalDateTime completedAt) {
        this.subject = subject;
        this.duration = duration;
        this.completedAt = completedAt;
    }
}
