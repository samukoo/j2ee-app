package com.samuk.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuk.operations.TeamOperations;
import com.samuk.orm.DbTeam;
import com.samuk.service.TeamService;


/**
 * Team service implementation. Handles Team related business logic
 * @author kotissa
 *
 */
@Stateless
public class TeamServiceImpl implements TeamService {

	@Inject
	private TeamOperations teamOps;
	
	
	public TeamServiceImpl() {
    }

	@Override
	public DbTeam addTeam(DbTeam team) {
		teamOps.persistTeam(team);
		return team;
	}

	@Override
	public DbTeam findTeamById(String teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DbTeam> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeam(DbTeam team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DbTeam updateTeam(DbTeam newTeam, DbTeam targetTeam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printTeam(DbTeam team) {
		teamOps.printTeam(team);
	}

}
