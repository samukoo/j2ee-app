package com.samuk.operations;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

	public List<DbTeam> getAllTeams() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DbTeam> query = cb.createQuery(DbTeam.class);
		Root<DbTeam> teams = query.from(DbTeam.class);
		query.select(teams);
		return em.createQuery(query).getResultList();
	}

	public DbTeam getTeam(Long id) {
		return em.find(DbTeam.class, id);
	}

}
