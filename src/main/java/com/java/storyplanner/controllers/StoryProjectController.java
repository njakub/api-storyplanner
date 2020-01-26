package com.java.storyplanner.controllers;

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

import com.java.storyplanner.models.StoryProject;
import com.java.storyplanner.services.StoryProjectService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/story-projects")
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
    public void create(@RequestBody StoryProject storyProject) {
        storyProjectService.saveOrUpdate(storyProject);
    }

    @GetMapping("/{id}")
    public StoryProject get(@PathVariable("id") long id) {
        return storyProjectService.getById(id);
    }

}
