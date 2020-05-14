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

import DB.DAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = DAO.getInstance();
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		if (dao.login(id, pw)) {
			System.out.println("로그인 성공");
			HttpSession Ss = request.getSession();
			Ss.setAttribute("ID", id);
			Ss.setAttribute("PW", pw);
			
//			String view ="Index";
//			
//			RequestDispatcher RD = request.getRequestDispatcher(view);
//			RD.forward(request, response);
			
			response.sendRedirect("Index");//로그인 후 jsp로!
		
		} else {
			System.out.println("로그인 실패");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out =response.getWriter();
			out.print("로그인 실패. ID/PW을 재확인!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
