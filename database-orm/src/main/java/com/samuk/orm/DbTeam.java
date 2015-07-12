package com.samuk.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DbTeam {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	
	public DbTeam() {
		super();
	}
	public Long getId() {
		return id;
	}
	public DbTeam setId(Long id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public DbTeam setName(String name) {
		this.name = name;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public DbTeam setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public String toString() {
		return "DbTeam [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
}
