package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.model.SpeakerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<SpeakerModel, Long> {
}
