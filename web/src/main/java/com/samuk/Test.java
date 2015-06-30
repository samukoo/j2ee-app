package com.samuk;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.orm.DbSprint;
import com.samuk.orm.DbTeam;
import com.samuk.service.SprintService;
import com.samuk.service.TeamService;


/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private TeamService teamService;

	@EJB
	private SprintService sprintService;
	
	@Inject
	private DbSprint s;
	
	@Inject
	private DbTeam t;
	
	public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		t.setName("Mörkö");
		teamService.printTeam(t);
		teamService.addTeam(t);
		
		s.setDate(new Date(1232134L));
		sprintService.printSprint(s);
		sprintService.addSprint(s);
		
		
	}

}
