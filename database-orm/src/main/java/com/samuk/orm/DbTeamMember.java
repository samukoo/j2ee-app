package com.samuk.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DbTeamMember {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private DbRole role;
	
	
	@ManyToOne
	@JoinColumn(nullable=true, referencedColumnName = "id")
	private DbTeam team;

	public DbTeamMember(){
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DbTeam getTeam() {
		return team;
	}

	public void setTeam(DbTeam team) {
		this.team = team;
	}

	public DbRole getRole() {
		return role;
	}

	public void setRole(DbRole role) {
		this.role = role;
	}
	
	
	
	
	
}
