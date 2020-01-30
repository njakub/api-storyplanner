package com.java.storyplanner.controllers;

import java.io.IOException;
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
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.storyplanner.models.StoryProject;
import com.java.storyplanner.services.StoryProjectService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/projects")
public class StoryProjectController {

    @Autowired
    private StoryProjectService storyProjectService;

    @GetMapping
    public List<StoryProject> list() {
        List<StoryProject> storyProjects = storyProjectService.listAll();
        return storyProjects;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(@RequestBody String storyProjectJson)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        StoryProject storyProject = mapper.readValue(storyProjectJson, StoryProject.class);
        storyProjectService.saveOrUpdate(storyProject);

        return new ResponseEntity<>("fdsfds", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public StoryProject get(@PathVariable("id") long id) {
        return storyProjectService.getById(id);
    }

}
