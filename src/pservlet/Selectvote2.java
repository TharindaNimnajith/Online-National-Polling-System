package pservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Selectvote2
 */
@WebServlet("/Selectvote2")
public class Selectvote2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Selectvote2() {
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
		String vp = request.getParameter("vp");

		int q = Integer.parseInt(vp);

		int count2 = 0, count1 = 0;

		if (q == 1)
			count2++;

		if (q == 2)
			count1++;

		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);

		RequestDispatcher dispatcher = request.getRequestDispatcher("result2.jsp");
		dispatcher.forward(request, response);

		// response.sendRedirect("msg.jsp");

		doGet(request, response);
	}
}