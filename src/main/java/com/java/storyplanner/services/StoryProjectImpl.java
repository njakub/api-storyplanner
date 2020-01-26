package com.java.storyplanner.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.storyplanner.models.StoryProject;
import com.java.storyplanner.repositories.StoryProjectRepository;

@Service
public class StoryProjectImpl implements StoryProjectService {

    @Autowired
    private StoryProjectRepository storyProjectRepository;

    @Override
    public List<StoryProject> listAll() {
        List<StoryProject> storyProjects = new ArrayList<>();
        storyProjectRepository.findAll().forEach(storyProjects::add);
        return storyProjects;
    }

    @Override
    public StoryProject saveOrUpdate(StoryProject storyProjects) {
        storyProjectRepository.save(storyProjects);
        return storyProjects;
    }

    @Override
    public void delete(Long id) {
        storyProjectRepository.deleteById(id);
    }

    @Override
    public StoryProject getById(Long id) {
        return storyProjectRepository.getOne(id);
    }

}
