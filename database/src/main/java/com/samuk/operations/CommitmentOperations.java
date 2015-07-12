package com.samuk.operations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.samuk.orm.DbCommitment;

/**
 * DAO class for {@link DbCommitment}
 * @author kotissa
 *
 */
@Stateless
public class CommitmentOperations {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Persist commitment
	 * @param commitment
	 */
	public void saveCommitment(DbCommitment commitment){
		//TODO refactor saveCommitment -> persistCommitment 
		em.persist(commitment);
	}

	/**
	 * Get all commitments
	 * @return List {@link DbCommitment}
	 */
	public List<DbCommitment> getAll() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DbCommitment> query = cb.createQuery(DbCommitment.class);
		Root<DbCommitment> commitment = query.from(DbCommitment.class);
		query.select(commitment);
		return em.createQuery(query).getResultList();
	}
	
	
	
}
