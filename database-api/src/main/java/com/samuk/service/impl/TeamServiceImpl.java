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

	@Inject private TeamOperations teamOps;
	@Inject private DbTeam team;
	
	public TeamServiceImpl() {}

	/**
	 * Persist {@link DbTeam} object
	 */
	@Override
	public void addTeam(DbTeam team) {
		teamOps.persistTeam(team);
	}
	
	/**
	 * Persist {@link DbTeam} which is constructed from name and description Strings
	 */
	@Override
	public void addTeam(String name, String description) {
		team.setName(name)
			.setDescription(description);
		teamOps.persistTeam(team);
	}
	
	/**
	 * Find team by Id 
	 * @return {@link DbTeam}
	 */
	@Override
	public DbTeam findTeamById(String teamId) {
		Long id = Long.parseLong(teamId);
		return teamOps.getTeam(id);
		
		
	}

	/**
	 * Returns all Team objects
	 * @return List {@link DbTeam}
	 */
	@Override
	public List<DbTeam> getAllTeams() {
		return teamOps.getAllTeams();
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

	/**
	 * Calls objects print method 
	 */
	@Override
	public void printTeam(DbTeam team) {
		teamOps.printTeam(team);
	}

	

}
