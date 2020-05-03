package com.pluralsight.conferencedemo.controller;

import com.pluralsight.conferencedemo.model.SpeakerModel;
import com.pluralsight.conferencedemo.repository.SpeakerRepository;
import com.pluralsight.conferencedemo.service.SpeakerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("api/v1/speaker")
public class SpeakerController {

    private final SpeakerService speakerService;

    @Autowired
    public SpeakerController(@Qualifier("speakerService") SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping
    public List<SpeakerModel> getAll() {
        return speakerService.getAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public SpeakerModel get(@PathVariable Long id) {
        return speakerService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpeakerModel create(@RequestBody final SpeakerModel speakerModel) {
        return speakerService.create(speakerModel);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public SpeakerModel update(@PathVariable Long id, @RequestBody SpeakerModel speakerModel) {
        return speakerService.update(id, speakerModel);
    }
}




