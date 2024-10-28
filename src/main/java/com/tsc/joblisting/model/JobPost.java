package com.tsc.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobpost")
public class JobPost {

	private String profile;

	private String description;

	private int experience;

	private String[] technologies;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String[] getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String[] technologies) {
		this.technologies = technologies;
	}

}
