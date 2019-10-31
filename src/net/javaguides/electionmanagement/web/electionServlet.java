package net.javaguides.electionmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.electionmanagement.dao.electionDAO;
import net.javaguides.electionmanagement.model.election;


public class electionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private electionDAO electionDAO;
	
	public void init() {
		electionDAO = new electionDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertelection(request, response);
				break;
			case "/delete":
				deleteelection(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateelection(request, response);
				break;
			default:
				listelection(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listelection(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<election> listelection = electionDAO.selectAllelections();
		request.setAttribute("listelection", listelection);
		RequestDispatcher dispatcher = request.getRequestDispatcher("election-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("election-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		election existingelection = electionDAO.selectelection(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("election-form.jsp");
		request.setAttribute("election", existingelection);
		dispatcher.forward(request, response);

	}

	private void insertelection(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		election newelection = new election(name, email, country);
		electionDAO.insertelection(newelection);
		response.sendRedirect("list");
	}

	private void updateelection(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		election book = new election(id, name, email, country);
		electionDAO.updateelection(book);
		response.sendRedirect("list");
	}

	private void deleteelection(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		electionDAO.deleteelection(id);
		response.sendRedirect("list");

	}

}
