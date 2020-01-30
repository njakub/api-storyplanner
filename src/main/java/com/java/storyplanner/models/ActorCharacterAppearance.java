package com.java.storyplanner.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorCharacterAppearance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = Access.READ_ONLY)
    private Long actorCharacterAppearanceId;
    private String eyeColor;
    private String hairColor;
    private String build;
    private boolean wearsGlasses;
    private String levelOfGrooming;

    @OneToOne
    @JoinColumn(name = "actor_character_id")
    @JsonIgnore
    private ActorCharacter actorCharacter;

    public Long getActorCharacterAppearanceId() {
        return this.actorCharacterAppearanceId;
    }

    public void setActorCharacterAppearanceId(Long actorCharacterAppearanceId) {
        this.actorCharacterAppearanceId = actorCharacterAppearanceId;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getBuild() {
        return this.build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public boolean isWearsGlasses() {
        return this.wearsGlasses;
    }

    public boolean getWearsGlasses() {
        return this.wearsGlasses;
    }

    public void setWearsGlasses(boolean wearsGlasses) {
        this.wearsGlasses = wearsGlasses;
    }

    public String getLevelOfGrooming() {
        return this.levelOfGrooming;
    }

    public void setLevelOfGrooming(String levelOfGrooming) {
        this.levelOfGrooming = levelOfGrooming;
    }

    public ActorCharacter getActorCharacter() {
        return this.actorCharacter;
    }

    public void setActorCharacter(ActorCharacter actorCharacter) {
        this.actorCharacter = actorCharacter;
    }
}
