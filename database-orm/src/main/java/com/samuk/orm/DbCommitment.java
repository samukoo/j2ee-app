package com.samuk.orm;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DbCommitment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int committedPoints;
	
	@OneToOne
	@JoinColumn(nullable=true, referencedColumnName="id")
	private DbTeamMember member;
	
	@OneToOne
	@JoinColumn(nullable=true, referencedColumnName="id")
	private DbSprint sprint;


	public DbCommitment(){
		super();
	}
	
	public long getId() {
		return id;
	}

	public int getCommittedPoints() {
		return committedPoints;
	}

	public DbTeamMember getMember() {
		return member;
	}

	public DbSprint getSprint() {
		return sprint;
	}

	public DbCommitment setId(long id) {
		this.id = id;
		return this;
	}

	public DbCommitment setCommittedPoints(int committedPoints) {
		this.committedPoints = committedPoints;
		return this;
	}

	public DbCommitment setMember(DbTeamMember member) {
		this.member = member;
		return this;
	}

	public DbCommitment setSprint(DbSprint sprint) {
		this.sprint = sprint;
		return this;
		}
	
	
	
}
