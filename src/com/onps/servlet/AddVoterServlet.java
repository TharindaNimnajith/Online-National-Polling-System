package com.onps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onps.model.Voter;

import com.onps.service.VoterServiceImpl;
import com.onps.service.IVoterService;

/**
 * Servlet implementation class AddVoterServlet
 */
@WebServlet("/AddVoterServlet")
public class AddVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVoterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		response.setContentType("text/html");

		Voter voter = new Voter();
		
		voter.setUsername(request.getParameter("username"));
		voter.setNic(request.getParameter("nic"));
		voter.setPassword(request.getParameter("password"));
		voter.setEmail(request.getParameter("email"));
		voter.setUserType(request.getParameter("userType"));
		voter.setFname(request.getParameter("fname"));
		voter.setLname(request.getParameter("lname"));
		voter.setAddress(request.getParameter("address"));
		voter.setDistrict(request.getParameter("district"));
		voter.setProvince(request.getParameter("province"));
		voter.setGender(request.getParameter("gender"));
		voter.setDoB(request.getParameter("DoB"));
		voter.setPhoneNo(request.getParameter("phoneNo"));

		IVoterService iVoterService = new VoterServiceImpl();
		
		iVoterService.addVoter(voter);

		request.setAttribute("voter", voter);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListVoters.jsp");
		dispatcher.forward(request, response);
	}
}
