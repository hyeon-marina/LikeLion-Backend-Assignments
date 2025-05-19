package com.example.likelionassignmentcrud.session.domain.repository;

import com.example.likelionassignmentcrud.session.domain.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
