package com.samuk.rest;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.samuk.service.MemberService;

@Path("users")
public class MemberRestInterface {

	@EJB
	private MemberService memberservice;
	
	public MemberRestInterface() {
	
		String name = "java:global/application/rest/MemberServiceImpl!com.samuk.service.MemberService";
		try {
			memberservice = (MemberService) InitialContext.doLookup(name);
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param teamId
	 * @param role
	 * @return String "ok" or error message with error cause
	 */
	@GET
	@Path("adduser")
	@Produces(MediaType.APPLICATION_JSON)
	public String addMember(@QueryParam("firstname") String firstname, 
						  @QueryParam("lastname") String lastname,
						  @QueryParam("teamId") String teamId,
						  @QueryParam("role") String role) {
	
		return memberservice.addMember(firstname, lastname, teamId, role);

	}
	
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test(@QueryParam("name") String name, @QueryParam("lastname") String lastname){
		return "hello " + name + " " + lastname;
	}
	
	
	
}
