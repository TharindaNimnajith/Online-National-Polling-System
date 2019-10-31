package com.onps.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.onps.service.CandidateServiceImpl;

import com.onps.util.CommonConstants;
import com.onps.util.DBConnectionUtil;
import com.onps.util.QueryUtil;

/**
 * Servlet implementation class CandidateLoginServlet
 */
@WebServlet("/CandidateLoginServlet")
public class CandidateLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateLoginServlet() {
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

		/** Initialize logger */
		final Logger log = Logger.getLogger(CandidateServiceImpl.class.getName());

		Connection DBconnection = null;

		try {
			DBconnection = DBConnectionUtil.getDBConnection();
		} 
		catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch(SQLException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch(Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}

		// Fetching the login details
		String username = request.getParameter("username");
		String nic = request.getParameter("nic");
		String password = request.getParameter("password");

		boolean returnValue = false;

		try {
			PreparedStatement statement = DBconnection.
					prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_CANDIDATE));

			statement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
			statement.setString(CommonConstants.COLUMN_INDEX_TWO, nic);
			statement.setString(CommonConstants.COLUMN_INDEX_THREE, password);

			ResultSet result = statement.executeQuery();

			if(result.next())
				returnValue = true;
		} 
		catch(SQLException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch(SAXException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch(ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch(Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}

		// Validating the login details with the database
		if(returnValue) {
			// Setting a session
			try {
				PreparedStatement statement = DBconnection.
						prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_CANDIDATE_ID));

				statement.setString(CommonConstants.COLUMN_INDEX_ONE, nic);

				ResultSet result = statement.executeQuery();
				result.next();

				PreparedStatement statement1 = DBconnection.
						prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_TYPE_CANDIDATE));

				statement1.setString(CommonConstants.COLUMN_INDEX_ONE, nic);

				ResultSet result1 = statement1.executeQuery();
				result1.next();

				HttpSession session = request.getSession();
				
				session.setAttribute("id", result);
				session.setAttribute("userType", result1);

				response.sendRedirect("candidateHome.jsp");
			} 
			catch(SQLException e) {
				// TODO Auto-generated catch block
				log.log(Level.SEVERE, e.getMessage());
			} 
			catch(SAXException e) {
				// TODO Auto-generated catch block
				log.log(Level.SEVERE, e.getMessage());
			} 
			catch(ParserConfigurationException e) {
				// TODO Auto-generated catch block
				log.log(Level.SEVERE, e.getMessage());
			} 
			catch(Exception e) {
				// TODO Auto-generated catch block
				log.log(Level.SEVERE, e.getMessage());
			}
		} 
		else {
			response.sendRedirect("candidateLogin.jsp");
		}
	}
}
