package group6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
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
		out.println("<a href='default.html'>Add New Student</a>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main.css\">");
		out.println("<h1 style=color:blue;>Student List</h1>");
		List<Csam> list = CsamDAO.getAllStudents();
		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Student Id</th><th>Student Name</th><th> Grade </th><th>GPA</th><th>Edit</th><th>Delete</th></tr>");
		for (Csam e : list) {
			out.print("<tr><td>" + e.getSid() + "</td><td>" + e.getSname() + "</td><td>" + e.getGrade() + "</td> <td>"
					+ e.getGpa() + "</td>><td><a href='EditServlet?sid=" + e.getSid()
					+ "'>edit</a></td> <td><a href='DeleteServlet?sid=" + e.getSid() + "'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.close();
	}

}
