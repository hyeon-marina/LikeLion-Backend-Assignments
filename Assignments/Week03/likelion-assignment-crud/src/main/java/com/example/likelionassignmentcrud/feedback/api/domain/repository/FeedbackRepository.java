package com.example.likelionassignmentcrud.feedback.api.domain.repository;

import com.example.likelionassignmentcrud.feedback.api.domain.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("SELECT f FROM Feedback f JOIN FETCH f.session")
    List<Feedback> findAllWithSession();
}