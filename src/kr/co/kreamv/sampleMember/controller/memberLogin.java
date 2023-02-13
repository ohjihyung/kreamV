package kr.co.kreamv.sampleMember.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;
import kr.co.kreamv.vo.SampleMemberVO;


@WebServlet("/memberLogin.do")
public class memberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

      
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		response.sendRedirect(request.getContextPath()+"/view/login.jsp");
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IsampleMemberService service = SampleMemberServiceImpl.getInstance();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		SampleMemberVO loginMember = new SampleMemberVO();
		loginMember.setMem_id(id);
		loginMember.setMem_pass(pass);
		
		int res = service.configMember(loginMember);  // 해당 아이디에 해당 비번 있으면 1 없으면 0 
		
		System.out.println(res);
		
		//로그인 성공 즉 res == 1 이면 세션에 저장 
		
		// 세션 객체 생성 
		HttpSession session = request.getSession();
		
		if(res == 1) {
				//만약 관리자면 
			 if(loginMember.getMem_id().equals("admin")) {
				 //세션 저장후  main페이지로 이동 
					session.setAttribute("loginMember", loginMember);
					session.setAttribute("loginId", loginMember.getMem_id());
					session.setAttribute("loginName", loginMember.getMem_nm());
					session.setAttribute("loginPhoto", loginMember.getMem_photo());
				response.sendRedirect(request.getContextPath()+"/view/manager.jsp");
				 return;
			 }else {				 
				 //세션 저장후  main페이지로 이동 
				session.setAttribute("loginMember", loginMember);
				session.setAttribute("loginId", loginMember.getMem_id());
				session.setAttribute("loginName", loginMember.getMem_nm());
				session.setAttribute("loginPhoto", loginMember.getMem_photo());
				
			 }
			
			//세션 저장후  main페이지로 이동 
			response.sendRedirect(request.getContextPath()+"/view/main.jsp");
		}

		else{
			// 로그인 실패시  sendredirect로 login.jsp로 보낸다.
			response.sendRedirect(request.getContextPath()+"/view/login.jsp");
		}

	}

}
