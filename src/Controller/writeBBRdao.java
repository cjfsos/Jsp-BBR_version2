package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.BBR_DTO;
import DB.DAO;

/**
 * Servlet implementation class writeBBRdao
 */
@WebServlet("/writeBBRdao")
public class writeBBRdao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public writeBBRdao() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd");
		Date time = new Date();
		String Stime = fm.format(time);
//		System.out.println(Stime+"수정날짜");

		HttpSession Ss = request.getSession();
		String id = (String) Ss.getAttribute("ID");
		String pw = request.getParameter("modPW");

		DAO dao = DAO.getInstance();
		boolean modLogCheck = dao.login(id, pw);
		if (modLogCheck) {
			BBR_DTO Bdto = new BBR_DTO();
			Bdto.setNo(Integer.parseInt(request.getParameter("modNO")));
//			System.out.println(request.getParameter("modTitle")+" BBRdao.java");
			Bdto.setTitle(request.getParameter("modTitle"));
//			System.out.println(request.getParameter("modContents")+" BBRdao.java");
			Bdto.setContents(request.getParameter("modContents"));
			
			Bdto.setNdate(Stime);
			int k;
			k = dao.modBBR(Bdto);
			if (k == 1) {
			System.out.println("수정성공");
			response.sendRedirect("Index");
			} else {
			out.print("수정에 실패했습니다. 관리자에게 문의하세요.");
			}
		} else {
			out.print("수정에 실패했습니다. pw를 다시 확인해 주세요.");
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
