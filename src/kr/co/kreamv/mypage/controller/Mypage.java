package kr.co.kreamv.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.sampleMember.dao.IsampleMemberDao;
import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;
import kr.co.kreamv.vo.SampleMemberVO;


@WebServlet("/Mypage.do")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath() + "/view/mypage.jsp");
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식으로 받아서   SampleMembervo를 받아와서 mypage.jsp로 뿌린다~~
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id = (String)request.getParameter("loginId");
		
		System.out.println(id);
		
		//회원쪽 -- samplememberservice에 있는 곳에 접근 
		IsampleMemberService service = SampleMemberServiceImpl.getInstance();
		SampleMemberVO  vo = service.getprofile(id);
		
		Gson gson = new Gson();
		String profile = gson.toJson(vo);
		
		PrintWriter out = response.getWriter();
		
		out.print(profile);
		out.flush();
		
	}

}
