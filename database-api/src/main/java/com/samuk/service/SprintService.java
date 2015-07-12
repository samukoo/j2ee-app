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
	public void addSprint(DbSprint sprint);
	public void addSprint(String week, String description, String teamId);
	public DbSprint findSprintById(String sprintId);
	public List<DbSprint> getAllSprints();
	public void deleteSprint(DbSprint sprint);
	public void printSprint(DbSprint sprint);
}
