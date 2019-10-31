package pservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eVote.Voter;

/**
 * Servlet implementation class Addvoter
 */
@WebServlet("/Addvoter")
public class Addvoter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addvoter() {
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
		response.setContentType("text/html");

		Voter voter = new Voter();

		voter.setVoterID(request.getParameter("voterID"));
		voter.setName(request.getParameter("name"));

		String VoterID = request.getParameter("VoterID");
		String name = request.getParameter("name");

		if (VoterID.equals("12300") && name.equals("akalanka")) {
			response.sendRedirect("selectElection.jsp");
		} else {
			response.sendRedirect("vote.jsp");

		}

		doGet(request, response);
	}
}