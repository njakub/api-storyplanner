package com.java.storyplanner.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StoryProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(access = Access.READ_ONLY)
	private Long storyProjectId;

	private String storyProjectName;

	@OneToMany(mappedBy = "storyProject")
	@JsonManagedReference
	private Set<ActorCharacter> actorCharacters;

	public Long getStoryProjectId() {
		return this.storyProjectId;
	}

	public void setStoryProjectId(Long storyProjectId) {
		this.storyProjectId = storyProjectId;
	}

	public String getStoryProjectName() {
		return this.storyProjectName;
	}

	public void setStoryProjectName(String storyProjectName) {
		this.storyProjectName = storyProjectName;
	}

	public Set<ActorCharacter> getActorCharacters() {
		return this.actorCharacters;
	}

	public void setActorCharacters(Set<ActorCharacter> actorCharacters) {
		this.actorCharacters = actorCharacters;
	}

}
