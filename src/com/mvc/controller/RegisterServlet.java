package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;

/**
 * Servlet implementation class VRegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		 String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String address = request.getParameter("address");
			String DoB = request.getParameter("DoB");
			String gender = request.getParameter("gender");
			String district = request.getParameter("district");
			String province = request.getParameter("province");
			String nic = request.getParameter("nic");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String phoneNo = request.getParameter("phoneNo");
		    String password = request.getParameter("password");
		    RegisterBean registerBean = new RegisterBean();
		    //Using Java Beans - An easiest way to play with group of related data
		    registerBean.setFname(fname);
		    registerBean.setLname(lname);
		    registerBean.setAddress(address);
		    registerBean.setDoB(DoB);
		    registerBean.setGender(gender);
		    registerBean.setDistrict(district);
		    registerBean.setProvince(province);
		    registerBean.setNic(nic);
		    registerBean.setUsername(username);
		    registerBean.setEmail(email);
		    registerBean.setPhoneNo(phoneNo);
		    registerBean.setPassword(password); 
		    
		    RegisterDao registerDao = new RegisterDao();
		    
		    //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		    String userRegistered = registerDao.registerUser(registerBean);
		    
		    if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		    {
		    request.getRequestDispatcher("/Home1.jsp").forward(request, response);
		    }
		    else   //On Failure, display a meaningful message to the User.
		    {
		    request.setAttribute("errMessage", userRegistered);
		    request.getRequestDispatcher("/Register.jsp").forward(request, response);
		    }
		doGet(request, response);
	}

}
