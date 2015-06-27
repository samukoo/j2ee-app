package com.samuk.operations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.samuk.orm.DbTeam;
import com.samuk.service.TeamService;

/**
 * Session Bean implementation class TeamOperations
 */
@Stateless
public class TeamOperations implements TeamService {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TeamOperations() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see TeamService#deleteTeam(DbTeam)
     */
    public void deleteTeam(DbTeam team) {
        // TODO Auto-generated method stub
    }

	/**
     * @see TeamService#getAllTeams()
     */
    public List<DbTeam> getAllTeams() {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see TeamService#findTeamById(String)
     */
    public DbTeam findTeamById(String teamId) {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see TeamService#updateTeam(DbTeam, DbTeam)
     */
    public DbTeam updateTeam(DbTeam newTeam, DbTeam targetTeam) {
        // TODO Auto-generated method stub
			return null;
    }

	/**
     * @see TeamService#addTeam()
     */
    public DbTeam addTeam() {
        // TODO Auto-generated method stub
			return null;
    }

	@Override
	public void printTeam(DbTeam team) {
		System.out.println(team.toString());
	}

}
