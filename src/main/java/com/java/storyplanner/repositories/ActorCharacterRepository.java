package com.java.storyplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.storyplanner.models.ActorCharacter;

public interface ActorCharacterRepository extends JpaRepository<ActorCharacter, Long> {
}
