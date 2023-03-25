package group6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsServlet
 */
@WebServlet("/InsServlet")
public class InsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		Double gpa = Double.parseDouble(request.getParameter("gpa"));
		String grade = request.getParameter("grade");
		out.println("<b>in Insert servlet : " + request.getParameter("sname") + "</b>");
		out.println("<br><b>" + sname + "</b>");
		Csam e = new Csam();
		e.setSid(sid);
		e.setSname(sname);
		e.setGpa(gpa);
		e.setGrade(grade);
		int status = CsamDAO.save(e);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("default.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}
	}

}
