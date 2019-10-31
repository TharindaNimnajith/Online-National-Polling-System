package com.onps.servelet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.onps.util.CommonConstants;
import com.onps.util.DBConnectionUtil;
import com.onps.util.QueryUtil;

import com.onps.service.CandidateServiceImpl;

/**
 * Servelet implementation class LoginServlet
 */
@WebServlet("/RegisterCandidateServelet")
public class RegisterCandidateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCandidateServelet() {
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
	
		String email = (request.getParameter("email"));
		String userType = (request.getParameter("userType"));
		
		String fname = (request.getParameter("fname"));
		String lname = (request.getParameter("lname"));
		String address =(request.getParameter("address"));
		
		String district =(request.getParameter("district"));
		
		String province =(request.getParameter("province"));
		String gender =(request.getParameter("gender"));
		String DoB =(request.getParameter("DoB"));
		String phoneNo =request.getParameter("phoneNo");
		
		boolean returnValue = false;
			
		try {		
			PreparedStatement statement = DBconnection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CANDIDATE));
			
			statement.setString(CommonConstants.COLUMN_INDEX_ONE, username);
			statement.setString(CommonConstants.COLUMN_INDEX_TWO, nic);
			statement.setString(CommonConstants.COLUMN_INDEX_THREE, password);
			statement.setString(CommonConstants.COLUMN_INDEX_FOUR, email);
			statement.setString(CommonConstants.COLUMN_INDEX_FIVE, userType);
			statement.setString(CommonConstants.COLUMN_INDEX_SIX, fname);
			statement.setString(CommonConstants.COLUMN_INDEX_SEVEN, lname);
			statement.setString(CommonConstants.COLUMN_INDEX_EIGHT, address);
			statement.setString(CommonConstants.COLUMN_INDEX_NINE, district);
			statement.setString(CommonConstants.COLUMN_INDEX_TEN, province);
			statement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, gender);
			statement.setString(CommonConstants.COLUMN_INDEX_TWELVE, DoB);
			statement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, phoneNo);
			
			int result = statement.executeUpdate();
			
			if(result == 1)
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
				PreparedStatement statement = DBconnection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SELECT_CANDIDATE_ID));
				
				statement.setString(CommonConstants.COLUMN_INDEX_ONE, nic);
			
				ResultSet result = statement.executeQuery();		
				result.next();
				
				HttpSession session = request.getSession();		
				session.setAttribute("id", result);
				
				request.setAttribute("username", username);

				RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher1.forward(request, response);
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
			response.sendRedirect("register.jsp");
		}
	}
}

