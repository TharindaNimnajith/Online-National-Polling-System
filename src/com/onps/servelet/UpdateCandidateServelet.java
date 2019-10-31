package com.onps.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onps.model.Candidate;

 

/**
 * Servelet implementation class UpdatecandidateServlet
 */
@WebServlet("/UpdateCandidateServlet")
public class UpdateCandidateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCandidateServelet() {
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

		Candidate candidate = new Candidate();
		
		String id = request.getParameter("id");
		
		candidate.setId(id);
		
		candidate.setUsername(request.getParameter("username"));
		candidate.setNic(request.getParameter("nic"));
		candidate.setPassword(request.getParameter("password"));
		candidate.setEmail(request.getParameter("email"));
		
		candidate.setFname(request.getParameter("fname"));
		candidate.setLname(request.getParameter("lname"));
		candidate.setAddress(request.getParameter("address"));
		candidate.setDistrict(request.getParameter("district"));
		candidate.setProvince(request.getParameter("province"));
		candidate.setGender(request.getParameter("gender"));
		candidate.setDoB(request.getParameter("DoB"));
		candidate.setPhoneNo(request.getParameter("phoneNo"));
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Listcandidates.jsp");
		dispatcher.forward(request, response);
	}
}
