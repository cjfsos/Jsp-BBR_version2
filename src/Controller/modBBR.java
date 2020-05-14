package Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class modBBR
 */
@WebServlet("/modBBR")
public class modBBR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modBBR() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		DAO dao = DAO.getInstance();
		HttpSession Ss = request.getSession();
		String nowID = (String) Ss.getAttribute("ID");
		boolean idChenk = dao.idcheckBBR(no, nowID);
		if (idChenk) {
			BBR_DTO modCT = dao.Contests(no);
			request.setAttribute("modCT", modCT);

			String view = "modBBR.jsp";
			RequestDispatcher RD = request.getRequestDispatcher(view);
			RD.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("해당 게시글은 작성자 본인만 수정 할 수 있습니다.");
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
