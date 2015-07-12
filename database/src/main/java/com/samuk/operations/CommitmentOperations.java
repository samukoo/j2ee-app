package com.samuk.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.samuk.orm.DbCommitment;

@Stateless
public class CommitmentOperations {

	@PersistenceContext
	private EntityManager em;
	
	
	public void saveCommitment(DbCommitment commitment){
		em.persist(commitment);
	}
	
	
	
}
