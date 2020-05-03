package com.pluralsight.conferencedemo.repository;

import com.pluralsight.conferencedemo.model.SpeakerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("speaker")
public interface SpeakerRepository extends JpaRepository<SpeakerModel, Long> {
}
