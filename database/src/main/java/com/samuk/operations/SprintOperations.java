package com.samuk.operations;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.samuk.orm.DbSprint;

/**
 * SprintOperations Data Access Object.
 * @author kotissa
 *
 */
@Default
@Stateless
public class SprintOperations {

	@PersistenceContext
	private EntityManager em;
	
	public void persistSprint(DbSprint sprint){
		em.persist(sprint);
	}
	
	public void printSprint(DbSprint sprint){
		System.out.println(sprint.toString());
	}
	
	public DbSprint getSprintById(Long id){
		return em.find(DbSprint.class, id);
	}
	
	public List<DbSprint> getAllSprints(){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DbSprint> query = cb.createQuery(DbSprint.class);
		Root<DbSprint> sprints = query.from(DbSprint.class);
		query.select(sprints);
		return em.createQuery(query).getResultList();
	}
	
	
	
}
