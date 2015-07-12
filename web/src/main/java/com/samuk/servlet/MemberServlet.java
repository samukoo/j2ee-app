package com.samuk.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.orm.DbRole;
import com.samuk.service.MemberService;
import com.samuk.service.TeamService;
import com.samuk.utils.PropertyLoader;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/members")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private MemberService memberService;
	
	@EJB
	private TeamService teamService;
	
	private PropertyLoader pl = new PropertyLoader();
    private final String FILE = "teamtool_fi.properties";
	
    public MemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher r = request.getRequestDispatcher("pages/members.jsp");
		request.setAttribute("prop", pl.getProperties(FILE));
		
		request.setAttribute("teams", teamService.getAllTeams());
		request.setAttribute("members", memberService.listAllMembers());
		request.setAttribute("roles", DbRole.values());
		
		r.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		memberService.addMember(request.getParameter("firstname"),
				request.getParameter("lastname"),
				request.getParameter("team"),
				request.getParameter("role"));
		
		doGet(request, response);
	}

}
