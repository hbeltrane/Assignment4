package group6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Student Profile</h1>");
		String sid = request.getParameter("sid");
		Csam e = CsamDAO.getStudentById(sid);
		out.println("<h1>SID =" + sid + "</h1>");
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td>St ID :</td><td><input type='text' name='sid' value='" + sid + "'/></td></tr>");
		out.print(
				"<tr><td>St Name : </td><td><input type='text' name='sname' value='" + e.getSName() + "'/></td></tr>");
		out.print("<tr><td>Grade : </td><td><input type='text' name='grade' value='" + e.getGrade() + "'/> </td></tr>");
		out.print("<tr><td>Gpa :</td><td><input type='text' name='gpa' value='" + e.getGpa() + "'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
	}

}
