package com.samuk;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.samuk.orm.DbTeam;
import com.samuk.service.TeamService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("test")
public class MyResource {

	@EJB
	private TeamService teamservice;
	
	public MyResource() {

		try {
	        String lookupName = "java:global/application/rest/TeamServiceImpl!com.samuk.service.TeamService";
	        teamservice = (TeamService) InitialContext.doLookup(lookupName);
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	
	}
	
	@GET
	@Path("save")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        
		teamservice.addTeam("daölkda", "description");
		
		return "Got it!";
    }
	
	@GET
	@Path("listall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DbTeam> listAllTeams(){
		return teamservice.getAllTeams();
	}
	
	
}
