package com.java.storyplanner.services;

import java.util.List;

import com.java.storyplanner.models.StoryProject;

public interface StoryProjectService {
	
	List<StoryProject> listAll();
	
	StoryProject getById(Long id);
	
	StoryProject saveOrUpdate(StoryProject storyProject);
	
	void delete(Long id);
	
//	ActorCharacter saveOrUpdateActorCharacterForm(ActorCharacterForm actorCharacterForm);

}
