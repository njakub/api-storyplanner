package com.java.storyplanner.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.storyplanner.models.ActorCharacter;
import com.java.storyplanner.repositories.ActorCharacterRepository;

@Service
public class ActorCharacterImpl implements ActorCharacterService{
	
	@Autowired
	private ActorCharacterRepository actorCharacterRepository;

	@Override
	public List<ActorCharacter> listAll() {
		List<ActorCharacter> actorCharacters = new ArrayList<>();
		actorCharacterRepository.findAll().forEach(actorCharacters::add);
		return actorCharacters;
	}

	@Override
	public ActorCharacter saveOrUpdate(ActorCharacter actorCharacter) {
		actorCharacterRepository.save(actorCharacter);
		return actorCharacter;
	}

	@Override
	public void delete(Long id) {
		actorCharacterRepository.deleteById(id);
	}

	@Override
	public ActorCharacter getById(Long id) {
		return actorCharacterRepository.getOne(id);
	}

}
