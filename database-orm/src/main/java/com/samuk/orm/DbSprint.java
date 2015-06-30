package com.samuk.orm;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DbSprint {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date date;
	
//	private DbTeam team;
	
	public DbSprint(){}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public DbTeam getTeam() {
//		return team;
//	}
//
//	public void setTeam(DbTeam team) {
//		this.team = team;
//	}

	@Override
	public String toString() {
		return "DbSprint [id=" + id + ", date=" + date + ", team]";
	}
	
	
	
	
	
}
