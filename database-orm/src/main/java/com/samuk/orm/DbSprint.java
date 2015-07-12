package com.samuk.orm;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DbSprint {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	int week;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(nullable=true, referencedColumnName = "id")
	private DbTeam team;
	
	private String description;
	
	public DbSprint(){}

	public Long getId() {
		return id;
	}

	public int getWeek() {
		return week;
	}

	public Date getDate() {
		return date;
	}

	public DbTeam getTeam() {
		return team;
	}

	public String getDescription() {
		return description;
	}

	public DbSprint setId(Long id) {
		this.id = id;
		return this;
	}

	public DbSprint setWeek(int week) {
		this.week = week;
		return this;
	}

	public DbSprint setDate(Date date) {
		this.date = date;
		return this;
	}

	public DbSprint setTeam(DbTeam team) {
		this.team = team;
		return this;
	}

	public DbSprint setDescription(String description) {
		this.description = description;
		return this;
	}

	
	
	
	
}
