package com.samuk.service;

import java.util.List;

import javax.ejb.Local;

import com.samuk.orm.DbTeam;

@Local
public interface TeamService {
	/**
	 * Add new team into database
	 * @param team
	 * @return DbTeam
	 */
	public void addTeam(DbTeam team);
	public void addTeam(String name, String description);
	public DbTeam findTeamById(String teamId);
	public List<DbTeam> getAllTeams();
	public void deleteTeam(DbTeam team);
	public DbTeam updateTeam(DbTeam newTeam, DbTeam targetTeam);
	public void printTeam(DbTeam team);
	
}
