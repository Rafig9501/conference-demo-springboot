package com.pluralsight.conferencedemo.controller;

import com.pluralsight.conferencedemo.model.SessionModel;
import com.pluralsight.conferencedemo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @GetMapping
    public List<SessionModel> getAll() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("id={id}")
    public SessionModel get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SessionModel create(@RequestBody final SessionModel sessionModel) {
        return sessionRepository.saveAndFlush(sessionModel);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public SessionModel update(@PathVariable Long id, @RequestBody SessionModel sessionModel) {
        SessionModel existingModel = sessionRepository.getOne(id);
        BeanUtils.copyProperties(sessionModel, existingModel, "sessionId");
        return sessionRepository.saveAndFlush(existingModel);
    }
}



