package com.java.storyplanner.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.storyplanner.models.ActorCharacterAppearance;
import com.java.storyplanner.repositories.ActorCharacterAppearanceRepository;

@Service
public class ActorCharacterAppearanceImpl implements ActorCharacterAppearanceService {

    @Autowired
    private ActorCharacterAppearanceRepository actorCharacterAppearanceRepository;

    @Override
    public List<ActorCharacterAppearance> listAll() {
        List<ActorCharacterAppearance> actorCharacterAppearances = new ArrayList<>();
        actorCharacterAppearanceRepository.findAll().forEach(actorCharacterAppearances::add);
        return actorCharacterAppearances;
    }

    @Override
    public ActorCharacterAppearance saveOrUpdate(ActorCharacterAppearance actorCharacterAppearance) {
        actorCharacterAppearanceRepository.save(actorCharacterAppearance);
        return actorCharacterAppearance;
    }

    @Override
    public void delete(Long id) {
        actorCharacterAppearanceRepository.deleteById(id);
    }

    @Override
    public ActorCharacterAppearance getById(Long id) {
        return actorCharacterAppearanceRepository.getOne(id);
    }

}
