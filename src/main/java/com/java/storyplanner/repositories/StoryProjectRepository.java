package com.java.storyplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.storyplanner.models.StoryProject;

public interface StoryProjectRepository extends JpaRepository<StoryProject, Long> {
}
