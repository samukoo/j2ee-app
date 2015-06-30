package com.samuk.service;

import java.util.List;

import javax.ejb.Local;

import com.samuk.orm.DbSprint;

/**
 * Sprint service interface
 * @author kotissa
 *
 */
@Local
public interface SprintService {
	/**
	 * Add sprint to db
	 * @param sprint
	 * @return
	 */
	public DbSprint addSprint(DbSprint sprint);
	public DbSprint findSprintById(Long sprintId);
	public List<DbSprint> getAllSprints();
	public void deleteSprint(DbSprint sprint);
	public void printSprint(DbSprint sprint);
}
