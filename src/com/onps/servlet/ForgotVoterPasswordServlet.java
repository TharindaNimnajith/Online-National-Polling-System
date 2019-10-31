package com.onps.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.onps.service.VoterServiceImpl;

import com.onps.util.CommonConstants;
import com.onps.util.DBConnectionUtil;
import com.onps.util.EmailUtil;
import com.onps.util.PasswordGenerator;
import com.onps.util.QueryUtil;

/**
 * Servlet implementation class ForgotVoterPasswordServlet
 */
@WebServlet("/ForgotVoterPasswordServlet")
public class ForgotVoterPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
   
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        
        host  = context.getInitParameter("host");
        port  = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name  = context.getInitParameter("name");
        pass  = context.getInitParameter("pass");
    }
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotVoterPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String page = "voterReset.jsp";
		
        request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		/** Initialize logger */
		final Logger log = Logger.getLogger(VoterServiceImpl.class.getName());

		Connection DBconnection = null;

		try {
			DBconnection = DBConnectionUtil.getDBConnection();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}

		String Email = request.getParameter("Email");

		String newPassword = PasswordGenerator.getAlphaNumericString();

		String recipient = request.getParameter("Email");

		String subject = "Your Password has been reset";
		String content = "Your new password: " + newPassword;

		String message = "";

		try {
			PreparedStatement statement = DBconnection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PASSWORD_VOTER));

			statement.setString(CommonConstants.COLUMN_INDEX_ONE, newPassword);
			statement.setString(CommonConstants.COLUMN_INDEX_TWO, Email);

			int result = statement.executeUpdate();

			switch (result) {
			case 1:
				EmailUtil.sendEmail(host, port, email, name, pass, recipient, subject, content);

				message = "Your password has been reset. Please check your e-mail.";

				request.setAttribute("message", message);

				// redirecting the response into message.jsp page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/message.jsp");
				dispatcher.forward(request, response);

				break;

			default:
				message = "Error occured. Please try again.";

				request.setAttribute("message", message);

				RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/voterLogin.jsp");
				dispatcher1.forward(request, response);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch (SAXException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
	}
}
