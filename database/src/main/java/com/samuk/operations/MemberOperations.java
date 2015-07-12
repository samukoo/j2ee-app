package com.samuk.operations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.samuk.orm.DbTeam;
import com.samuk.orm.DbTeamMember;

@Stateless
public class MemberOperations {

	@PersistenceContext
	private EntityManager em; 
	
	/**
	 * Persist new member
	 * @param {@link DbTeamMember}
	 */
	public void persistMember(DbTeamMember member){
		em.persist(member);
	}

	/**
	 * find member by Id
	 * @param id (Long)
	 * @return {@link DbTeamMember}
	 */
	public DbTeamMember findMember(Long id){
		return em.find(DbTeamMember.class, id);
	}
	
	/**
	 * Get all members from members table
	 * @return {@link List} {@link DbTeamMember} 
	 */
	public List<DbTeamMember> getMembers() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DbTeamMember> query = cb.createQuery(DbTeamMember.class);
		Root<DbTeamMember> member = query.from(DbTeamMember.class);
		query.select(member);
		return em.createQuery(query).getResultList();
	}

	/**
	 * Get list of members by team
	 * @param {@link DbTeam}
	 * @return {@link List} {@link DbTeamMember}
	 */
	public List<DbTeamMember> getMembersByTeam(DbTeam team) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DbTeamMember> query = cb.createQuery(DbTeamMember.class);
		Root<DbTeamMember> members = query.from(DbTeamMember.class);
		query.where(cb.equal(members.get("team"), team));
		return em.createQuery(query).getResultList();
	}
	
	
	
}
