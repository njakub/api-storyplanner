package com.java.storyplanner.services;

import java.util.List;

import com.java.storyplanner.models.ActorCharacter;

public interface ActorCharacterService {

	List<ActorCharacter> listAll();

	ActorCharacter getById(Long id);

	ActorCharacter saveOrUpdate(ActorCharacter actorCharacter);

	void delete(Long id);

	// ActorCharacter saveOrUpdateActorCharacterForm(ActorCharacterForm
	// actorCharacterForm);

}
