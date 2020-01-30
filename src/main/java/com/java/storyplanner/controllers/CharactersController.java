package com.java.storyplanner.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.java.storyplanner.models.ActorCharacter;
import com.java.storyplanner.models.ActorCharacterAppearance;
import com.java.storyplanner.models.StoryProject;
import com.java.storyplanner.services.ActorCharacterAppearanceService;
import com.java.storyplanner.services.ActorCharacterService;
import com.java.storyplanner.services.StoryProjectService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/characters")
public class CharactersController {

	@Autowired
	private ActorCharacterService actorCharacterService;

	@Autowired
	private ActorCharacterAppearanceService actorCharacterAppearanceService;

	@Autowired
	private StoryProjectService storyProjectService;

	@GetMapping
	public List<ActorCharacter> list() {
		List<ActorCharacter> actorCharacters = actorCharacterService.listAll();
		return actorCharacters;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity create(@RequestBody String actorCharacterJson)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ActorCharacter actorCharacter = mapper.readValue(actorCharacterJson, ActorCharacter.class);

		Long storyId = 1L;
		StoryProject storyProject = storyProjectService.getById(storyId);

		actorCharacter.setStoryProject(storyProject);

		actorCharacterService.saveOrUpdate(actorCharacter);
		return new ResponseEntity<>(actorCharacter, HttpStatus.OK);
	}

	@PostMapping("/appearance/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity addAppearance(@RequestBody String appearanceJson, @PathVariable("id") long actorCharacterId)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ActorCharacterAppearance actorCharacterAppearance = mapper.readValue(appearanceJson,
				ActorCharacterAppearance.class);

		ActorCharacter actorCharacter = actorCharacterService.getById(actorCharacterId);

		if (actorCharacter.getActorCharacterAppearance() == null) {
			actorCharacterAppearance.setActorCharacter(actorCharacter);
			actorCharacterAppearanceService.saveOrUpdate(actorCharacterAppearance);
			actorCharacter.setActorCharacterAppearance(actorCharacterAppearance);
			actorCharacterService.saveOrUpdate(actorCharacter);
		}
		return new ResponseEntity<>("fdsfds", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity replaceCharacter(@RequestBody String actorCharacterJson, @PathVariable Long id)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		ActorCharacter newActorCharacter = mapper.readValue(actorCharacterJson, ActorCharacter.class);
		ActorCharacter actorCharacter = actorCharacterService.getById(id);

		actorCharacter.setFirstName(newActorCharacter.getFirstName());
		actorCharacter.setLastName(newActorCharacter.getLastName());

		actorCharacterService.saveOrUpdate(actorCharacter);

		return new ResponseEntity<>(actorCharacter, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ActorCharacter get(@PathVariable("id") long id) {
		return actorCharacterService.getById(id);
	}

}
