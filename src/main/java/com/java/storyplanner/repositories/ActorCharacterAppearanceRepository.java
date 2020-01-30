package com.java.storyplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.storyplanner.models.ActorCharacterAppearance;

public interface ActorCharacterAppearanceRepository extends JpaRepository<ActorCharacterAppearance, Long> {
}
