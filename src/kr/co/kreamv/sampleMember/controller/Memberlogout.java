package kr.co.kreamv.sampleMember.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Memberlogout.do")
public class Memberlogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		 //로그아웃시 해당 session 삭제 
		
		// 완전삭제방법 사용 
	
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		// 세션 삭제후 메인페이지 이동 
		response.sendRedirect(request.getContextPath()+"/view/main.jsp");
		
	}

}
