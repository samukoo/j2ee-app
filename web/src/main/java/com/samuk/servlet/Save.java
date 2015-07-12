package com.samuk.servlet; 

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuk.orm.DbTeamMember;
import com.samuk.service.CommitmentService;
import com.samuk.service.MemberService;

/**
 * Servlet implementation class Save
 */
@WebServlet({ "/Save", "/save" })
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private CommitmentService commitmentService;
	
	@EJB
	private MemberService memberService;
	
	@Inject
	private SprintServlet sprintServlet;
	
    public Save() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * for commit points save. Servlet takes form parameters "sprint" and "commit points". <br>
	 * members is fetched from database based sprint id and commit points are mapped to their respective members in for loop.<br>
	 * after points are committed, sprintservlet.doGet is called.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sprintId = request.getParameter("sprint");
		
		for(DbTeamMember m : memberService.listAllTeamMembersBySprint(sprintId)){
			commitmentService.saveCommitment(m.getId(), request.getParameter(m.getName()), sprintId);
		}
		
		sprintServlet.doGet(request, response);
	
	}

}
