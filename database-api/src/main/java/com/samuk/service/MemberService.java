package com.samuk.service;

import java.util.List;

import javax.ejb.Local;

import com.samuk.orm.DbTeamMember;

@Local
public interface MemberService {

	public void addMember(DbTeamMember member);
	public String addMember(String firstname, String lastname, String teamId, String role);
	public DbTeamMember getMemberById(Long memberId);
	public List<DbTeamMember> listAllMembers();
	public List<DbTeamMember> listAllTeamMembers(String teamId);
	public List<DbTeamMember> listAllTeamMembersBySprint(String sprintId);
	public void deleteMember(DbTeamMember member);
}
