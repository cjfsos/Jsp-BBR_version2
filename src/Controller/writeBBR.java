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

import DB.BBR_DTO;
import DB.DAO;

/**
 * Servlet implementation class writeBBR
 */
@WebServlet("/writeBBR")
public class writeBBR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public writeBBR() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd");
		Date time = new Date();
		String Stime = fm.format(time);
		
		BBR_DTO Bdto = new BBR_DTO();
		Bdto.setTitle(request.getParameter("title"));
		Bdto.setId(request.getParameter("writer"));
		Bdto.setContents(request.getParameter("contents"));
		Bdto.setNdate(Stime);
		
//		System.out.println("제목 : "+s1);
//		System.out.println("작성자 : "+s2);
//		System.out.println("내용 : "+s3);
//		System.out.println("날짜 : "+s4);
		DAO dao = DAO.getInstance();
		
		int k;
		k = dao.InWrite(Bdto);
		
		if (k == 1) {
			System.out.println("글 작성 성공");
			response.sendRedirect("Index");
		} else if (k == 0) {
			System.out.println("글 작성 실패");
			out.print("작성실패!");
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
