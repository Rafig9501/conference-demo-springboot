package com.pluralsight.conferencedemo.controller;

import com.pluralsight.conferencedemo.model.SessionModel;
import com.pluralsight.conferencedemo.repository.SessionRepository;
import com.pluralsight.conferencedemo.service.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/session")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(@Qualifier("sessionService") SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<SessionModel> getAll() {
        //get all
        return sessionService.getAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public SessionModel get(@PathVariable Long id) {
        return sessionService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SessionModel create(@RequestBody final SessionModel sessionModel) {
        return sessionService.create(sessionModel);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public SessionModel update(@PathVariable Long id, @RequestBody SessionModel sessionModel) {
        return sessionService.update(id, sessionModel);
    }
}
