package com.samuk.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuk.operations.SprintOperations;
import com.samuk.orm.DbSprint;
import com.samuk.service.SprintService;
import com.samuk.service.TeamService;

/**
 * Sprint service implementation. Handles Sprint related business logic
 * @author kotissa
 *
 */
@Stateless
public class SprintServiceImpl implements SprintService {

	@EJB
	private TeamService teamService;
	
	@Inject
	private SprintOperations sprintOps;
	
	@Inject
	private DbSprint sprint;
	
	
	@Override
	public void addSprint(DbSprint sprint) {
		
		
		
		sprintOps.persistSprint(sprint);
	}
	
	@Override
	public void addSprint(String week, String description, String teamId) {
		sprintOps.persistSprint(sprint.setWeek(Integer.parseInt(week))
				 					  .setDescription(description)
				 					  .setTeam(teamService.findTeamById(teamId)));
	}
	
	
	@Override
	public DbSprint findSprintById(String sprintId) {
		return sprintOps.getSprintById(Long.parseLong(sprintId));
	}

	@Override
	public List<DbSprint> getAllSprints() {
		return sprintOps.getAllSprints();
	}

	@Override
	public void deleteSprint(DbSprint sprint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printSprint(DbSprint sprint) {
		sprintOps.printSprint(sprint);
	}

	

}
