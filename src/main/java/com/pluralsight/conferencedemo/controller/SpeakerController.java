package com.pluralsight.conferencedemo.controller;

import com.pluralsight.conferencedemo.model.SpeakerModel;
import com.pluralsight.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

    private final SpeakerRepository speakerRepository;

    @Autowired
    public SpeakerController(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @GetMapping
    public List<SpeakerModel> getAll(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public SpeakerModel get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpeakerModel create(@RequestBody final SpeakerModel speakerModel){
        return speakerRepository.saveAndFlush(speakerModel);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public SpeakerModel update(@PathVariable Long id, SpeakerModel speakerModel){
        SpeakerModel existingSpeakerModel = speakerRepository.getOne(id);
        BeanUtils.copyProperties(existingSpeakerModel, speakerModel, "speakerId");
        return speakerRepository.saveAndFlush(speakerModel);
    }
}




