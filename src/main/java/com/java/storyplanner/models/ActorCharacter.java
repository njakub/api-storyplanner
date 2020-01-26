package com.java.storyplanner.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(access = Access.READ_ONLY)
	private Long actorCharacterId;
	private String firstName;
	private String lastName;
	private String nickName;
	private String age;
	private String placeOfBirth;
	private String nationality;
	private String education;
	private String occupation;
	private String income;
	private String status;
	private String title;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	private Date dob;

	@OneToOne(mappedBy = "actorCharacter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ActorCharacterAppearance characterAppearance;

	@ManyToOne
	@JoinColumn(name = "story_project_id")
	@JsonIgnore
	private StoryProject storyProject;

	public Long getActorCharacterId() {
		return actorCharacterId;
	}

	public void setActorCharacterId(Long actorCharacterId) {
		this.actorCharacterId = actorCharacterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public StoryProject getStoryProject() {
		return this.storyProject;
	}

	public void setStoryProject(StoryProject storyProject) {
		this.storyProject = storyProject;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPlaceOfBirth() {
		return this.placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getIncome() {
		return this.income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ActorCharacterAppearance getcharacterAppearance() {
		return this.characterAppearance;
	}

	public void setCharacterAppearance(ActorCharacterAppearance characterAppearance) {
		this.characterAppearance = characterAppearance;
	}

}
