package com.samuk.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.service.MemberService;
import com.samuk.service.SprintService;
import com.samuk.service.TeamService;

@WebServlet({ "/sprint", "/Sprint" })
public class SprintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private SprintService sprintService;
	
	@EJB
	private TeamService teamService;
	
	@EJB
	private MemberService memberService;
	
    public SprintServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher r; 
		if(request.getParameter("id") == null){
		
		r = request.getRequestDispatcher("pages/sprints.jsp");
		
			request.setAttribute("sprints", sprintService.getAllSprints());
			request.setAttribute("teams", teamService.getAllTeams());
		}else{
			
		r = request.getRequestDispatcher("pages/sprint.jsp");
		
			request.setAttribute("members", memberService.
					listAllTeamMembersBySprint(request.getParameter("id")));
			request.setAttribute("sprint", sprintService.findSprintById(request.getParameter("id")));
		
		}
			
		r.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		sprintService.addSprint(request.getParameter("week"), 
								request.getParameter("description"),
								request.getParameter("team"));
		doGet(request, response);
	}

}
