package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DAO;
import DB.member_DTO;

/**
 * Servlet implementation class singup
 */
@WebServlet("/singup")
public class singup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public singup() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		member_DTO dto = new member_DTO();
		int k;
		dto.setId(request.getParameter("txt_id"));
		dto.setPw(request.getParameter("txt_pwdc"));
		dto.setName(request.getParameter("txt_name"));
		dto.setMail(request.getParameter("txt_email"));
		DAO dao = DAO.getInstance();
		k = dao.singup(dto);
//		System.out.println(k+" pst.executeUpdate()의 값");
		
		PrintWriter out = response.getWriter();
		
		if (k == 1) {
			System.out.println("회원가입 성공");			
			out.print("가입성공");
		} else if (k == 0) {
			System.out.println("회원가입 실패");
//			out.print("가입실패!");
			out.print("회원가입에 실패했습니다.");
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			response.sendRedirect("Index");
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
