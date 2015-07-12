package com.samuk.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.samuk.orm.DbCommitment;
import com.samuk.service.CommitmentService;

@Path("sprint")
public class Sprint {

	@EJB
	private CommitmentService cs;

	public Sprint() {
		try {
	        String lookupName = "java:global/application/rest/CommitmentServiceImpl!com.samuk.service.CommitmentService";
	        cs = (CommitmentService) InitialContext.doLookup(lookupName);
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String restTest(){
		return "works";
	}
	
	@GET
	@Path("listall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DbCommitment> listAllSprintCommitments(){
		return cs.listAll();
	}
	
}
