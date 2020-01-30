package com.java.storyplanner.services;

import java.util.List;

import com.java.storyplanner.models.ActorCharacterAppearance;

public interface ActorCharacterAppearanceService {

    List<ActorCharacterAppearance> listAll();

    ActorCharacterAppearance getById(Long id);

    ActorCharacterAppearance saveOrUpdate(ActorCharacterAppearance actorCharacter);

    void delete(Long id);

    // ActorCharacter saveOrUpdateActorCharacterForm(ActorCharacterForm
    // actorCharacterForm);

}
