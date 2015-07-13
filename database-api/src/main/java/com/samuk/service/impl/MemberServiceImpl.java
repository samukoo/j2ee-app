package com.samuk.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuk.operations.MemberOperations;
import com.samuk.orm.DbRole;
import com.samuk.orm.DbTeam;
import com.samuk.orm.DbTeamMember;
import com.samuk.service.MemberService;
import com.samuk.service.SprintService;
import com.samuk.service.TeamService;
import com.samuk.service.exceptions.MemberException;

@Stateless
public class MemberServiceImpl implements MemberService {

	@EJB private TeamService teamService;
	@EJB private SprintService sprintService;
	@Inject private MemberOperations memOps;
	@Inject private DbTeamMember member;
	@Inject private DbTeam team;
	
	@Override
	public void addMember(DbTeamMember member) {
		memOps.persistMember(member);
	}
	
	/**
	 * Add member based on arguments. Only mandatory arguments should be firstname & lastname
	 */
	@Override
	public String addMember(String firstname, String lastname, String teamId, String role){
		
		if(firstname==null || lastname==null){
			try {
				throw new MemberException(firstname, lastname);
			} catch (MemberException e) {
				return e.errorMsg();
			}
		}
		
		team = teamId == null ? null : teamService.findTeamById(teamId);
		if(role!=null){
		member.setRole(DbRole.valueOf(role));
		}
		
		member.setName(firstname + " " + lastname);
		member.setTeam(team);
		memOps.persistMember(member);
		
		return "ok";
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
