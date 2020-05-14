package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.BBR_DTO;
import DB.DAO;

/**
 * Servlet implementation class Indedx
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession Ss = request.getSession();

		DAO dao = DAO.getInstance();
		ArrayList<BBR_DTO> bbrlist = dao.getIndex();
		request.setAttribute("list", bbrlist);

		String id = (String) Ss.getAttribute("ID");
		System.out.println(id + "로 로그인");

		if (id == null) {
			String view = "Index.jsp";
			RequestDispatcher RD = request.getRequestDispatcher(view);
			RD.forward(request, response);
		} else {
			String view = "logIndex.jsp";
			RequestDispatcher RD = request.getRequestDispatcher(view);
			RD.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
