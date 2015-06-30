package com.samuk.operations;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.samuk.orm.DbTeam;

/**
 * TeamOperations Data Access Object
 * @author kotissa
 *
 */

@Default
@Stateless
public class TeamOperations{

	@PersistenceContext
	private EntityManager em;
	
	public void persistTeam(DbTeam team){
		em.persist(team);
	}
	
	public void printTeam(DbTeam team) {
		System.out.println(team.toString());
	}

}
