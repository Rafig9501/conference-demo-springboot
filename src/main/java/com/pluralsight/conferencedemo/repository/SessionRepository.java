package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.model.SessionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionModel, Long> {
    
}
