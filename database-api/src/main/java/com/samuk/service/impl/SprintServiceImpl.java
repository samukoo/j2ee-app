package com.samuk.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuk.operations.SprintOperations;
import com.samuk.orm.DbSprint;
import com.samuk.service.SprintService;

/**
 * Sprint service implementation. Handles Sprint related business logic
 * @author kotissa
 *
 */
@Stateless
public class SprintServiceImpl implements SprintService {

	@Inject
	private SprintOperations sprintOps;
	
	@Override
	public DbSprint addSprint(DbSprint sprint) {
		sprintOps.persistSprint(sprint);
		return sprint;
	}

	@Override
	public DbSprint findSprintById(Long sprintId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DbSprint> getAllSprints() {
		// TODO Auto-generated method stub
		return null;
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
