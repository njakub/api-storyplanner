package com.java.storyplanner.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.java.storyplanner.models.ActorCharacter;
import com.java.storyplanner.services.ActorCharacterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/characters")
public class CharactersController {
	
	@Autowired
	private ActorCharacterService actorCharacterService; 	
	
	@GetMapping
	public List<ActorCharacter> list(){ 
		List<ActorCharacter> actorCharacters = actorCharacterService.listAll();
		return actorCharacters;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ActorCharacter actorCharacter) {
		actorCharacterService.saveOrUpdate(actorCharacter);
	}
	
	@GetMapping("/{id}")
	public ActorCharacter get(@PathVariable("id") long id) {
		return actorCharacterService.getById(id);
	}
	
}
