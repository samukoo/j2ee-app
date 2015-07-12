package com.samuk.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuk.operations.MemberOperations;
import com.samuk.orm.DbRole;
import com.samuk.orm.DbTeamMember;
import com.samuk.service.MemberService;
import com.samuk.service.SprintService;
import com.samuk.service.TeamService;

@Stateless
public class MemberServiceImpl implements MemberService {

	@EJB
	private TeamService teamService;
	
	@EJB
	private SprintService sprintService;
	
	@Inject
	private MemberOperations memOps;

	@Inject
	private DbTeamMember member;
	
	@Override
	public void addMember(DbTeamMember member) {
		memOps.persistMember(member);
	}

	@Override
	public void addMember(String firstname, String lastname, String teamId, String role) {

		member.setName(firstname + " " + lastname);
		member.setTeam(teamService.findTeamById(teamId));
		member.setRole(DbRole.valueOf(role));
		
		memOps.persistMember(member);
	} 
	
	@Override
	public List<DbTeamMember> listAllMembers() {
		return memOps.getMembers();
	}

	@Override
	public void deleteMember(DbTeamMember member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DbTeamMember> listAllTeamMembers(String teamId) {
		return memOps.getMembersByTeam(teamService.findTeamById(teamId));
	}

	/**
	 * Takes sprintId
	 * returns list of members binded to that sprint
	 */
	@Override
	public List<DbTeamMember> listAllTeamMembersBySprint(String sprintId) {
		
		return memOps.getMembersByTeam(sprintService
					 .findSprintById(sprintId)
					 .getTeam());
		
		
	}

	@Override
	public DbTeamMember getMemberById(Long memberId) {

		return memOps.findMember(memberId);
	}

	
	
	

}
