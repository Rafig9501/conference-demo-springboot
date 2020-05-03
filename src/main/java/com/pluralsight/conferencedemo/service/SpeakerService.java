package com.pluralsight.conferencedemo.service;

import com.pluralsight.conferencedemo.model.SpeakerModel;
import com.pluralsight.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {

    private final SpeakerRepository speakerRepository;

    @Autowired
    public SpeakerService(@Qualifier("speaker") SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public SpeakerModel create(SpeakerModel speakerModel) {
        return speakerRepository.saveAndFlush(speakerModel);
    }

    public SpeakerModel get(Long id) {
        return speakerRepository.getOne(id);
    }

    public List<SpeakerModel> getAll() {
        return speakerRepository.findAll();
    }

    public SpeakerModel update(Long id, SpeakerModel speakerModel) {
        SpeakerModel existingSpeakerModel = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speakerModel, existingSpeakerModel,"speakerId");
        return speakerRepository.saveAndFlush(existingSpeakerModel);
    }

    public void delete(Long id) {
        speakerRepository.deleteById(id);
    }
}
