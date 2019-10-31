package pservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Selectvote
 */
@WebServlet("/Selectvote")
public class Selectvote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Selectvote() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p = request.getParameter("vp");

		int q = Integer.parseInt(p);

		int count2 = 0, count1 = 0;

		if (q == 2)
			count2++;

		if (q == 1)
			count1++;

		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);

		RequestDispatcher dispatcher = request.getRequestDispatcher("result1.jsp");
		dispatcher.forward(request, response);

		// response.sendRedirect("msg.jsp");

		doGet(request, response);
	}

}
