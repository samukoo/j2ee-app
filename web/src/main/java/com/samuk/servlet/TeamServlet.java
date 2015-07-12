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
import com.samuk.service.TeamService;

@WebServlet({ "/team", "/Team" })
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private TeamService teamService;
	
	@EJB
	private MemberService memberService;
	
	public TeamServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher r;

		if (request.getParameter("id") != null) {
			r = request.getRequestDispatcher("/pages/team.jsp");
			
			request.setAttribute("team", teamService.findTeamById(request.getParameter("id")));
			request.setAttribute("members", memberService.listAllTeamMembers(request.getParameter("id")));
			
			
		} else {
			r = request.getRequestDispatcher("/pages/manageteams.jsp");
			request.setAttribute("teams", teamService.getAllTeams());
		}
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		teamService.addTeam(request.getParameter("name"),
				request.getParameter("description"));
		
		doGet(request, response);
	}

}
