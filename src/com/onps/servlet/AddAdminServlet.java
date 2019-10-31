package com.onps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onps.model.Admin;

import com.onps.service.AdminServiceImpl;
import com.onps.service.IAdminService;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
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
		//doGet(request, response);
		
		response.setContentType("text/html");

		Admin admin = new Admin();
		
		admin.setUsername(request.getParameter("username"));
		admin.setNic(request.getParameter("nic"));
		admin.setPassword(request.getParameter("password"));
		admin.setEmail(request.getParameter("email"));
		admin.setUserType(request.getParameter("userType"));
		admin.setFname(request.getParameter("fname"));
		admin.setLname(request.getParameter("lname"));
		admin.setAddress(request.getParameter("address"));
		admin.setDistrict(request.getParameter("district"));
		admin.setProvince(request.getParameter("province"));
		admin.setGender(request.getParameter("gender"));
		admin.setDoB(request.getParameter("DoB"));
		admin.setPhoneNo(request.getParameter("phoneNo"));

		IAdminService iAdminService = new AdminServiceImpl();
		
		iAdminService.addAdmin(admin);

		request.setAttribute("admin", admin);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListAdmins.jsp");
		dispatcher.forward(request, response);
	}
}
