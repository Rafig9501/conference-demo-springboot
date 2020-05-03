package com.pluralsight.conferencedemo.service;

import com.pluralsight.conferencedemo.model.SessionModel;
import com.pluralsight.conferencedemo.model.SpeakerModel;
import com.pluralsight.conferencedemo.repository.SessionRepository;
import com.pluralsight.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(@Qualifier("session") SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public SessionModel get(Long id) {
        return sessionRepository.getOne(id);
    }

    public SessionModel create(SessionModel sessionModel) {
        return sessionRepository.saveAndFlush(sessionModel);
    }

    public List<SessionModel> getAll() {
        return sessionRepository.findAll();
    }

    public SessionModel update(Long id, SessionModel sessionModel) {
        SessionModel existingSessionModel = sessionRepository.getOne(id);
        BeanUtils.copyProperties(sessionModel, existingSessionModel,"sessionId");
        return sessionRepository.saveAndFlush(existingSessionModel);
    }

    public void delete(Long id) {
        sessionRepository.deleteById(id);
    }
}