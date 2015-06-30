package com.samuk.service;

import java.util.List;

import javax.ejb.Local;

import com.samuk.orm.DbTeam;

@Local
public interface TeamService {
	public DbTeam addTeam(DbTeam team);
	public DbTeam findTeamById(String teamId);
	public List<DbTeam> getAllTeams();
	public void deleteTeam(DbTeam team);
	public DbTeam updateTeam(DbTeam newTeam, DbTeam targetTeam);
	public void printTeam(DbTeam team);
}
