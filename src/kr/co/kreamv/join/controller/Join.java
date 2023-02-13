package kr.co.kreamv.join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.join.service.IJoinService;
import kr.co.kreamv.join.service.JoinServiceImpl;
import kr.co.kreamv.vo.SampleMemberVO;


@WebServlet("/Join.do")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		String id = request.getParameter("idcheck");
		
		IJoinService service = JoinServiceImpl.getInstance();
		
		int intResult = service.idCheck(id);
		
		String stringResult = null;
		
		Gson gson = new Gson();
		
		if(intResult > 0) {
			stringResult = gson.toJson("사용불가");
		}else {
			stringResult = gson.toJson("사용가능");
		}
		
		out.println(stringResult);
		response.flushBuffer();
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String mem_id = request.getParameter("id");
		String mem_pass = request.getParameter("pass");
		String mem_name = request.getParameter("name");
		String mem_bir = request.getParameter("bir");
		String mem_email = request.getParameter("email");
		String mem_hp = request.getParameter("hp");
		String mem_addr1 = request.getParameter("addr1");
		String mem_addr2 = request.getParameter("addr2");

		
		int mem_gen = 0;
		
		if(request.getParameter("gen").equals("male")) {
			mem_gen = 0;
		}else if(request.getParameter("gen").equals("male")) {
			mem_gen = 1;
		}
		
		int size = Integer.parseInt(request.getParameter("size"));
		
		SampleMemberVO vo = new SampleMemberVO();
		vo.setMem_gen(mem_gen);
		vo.setMem_id(mem_id);
		vo.setMem_pass(mem_pass);
		vo.setMem_nm(mem_name);
		vo.setMem_bir(mem_bir);
		vo.setMem_mail(mem_email);
		vo.setMem_hp(mem_hp);
		vo.setMem_addr1(mem_addr1);
		vo.setMem_addr2(mem_addr2);
		vo.setMem_shoes(size);
		
		IJoinService service = JoinServiceImpl.getInstance();
		
		int result = service.insertMember(vo);
		
	
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/view/main.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/view/main.jsp");
		}
		
		

		
//		request.setAttribute("result", result);
//		
//		request.getRequestDispatcher(request.getContextPath() + "/view/join.jsp").forward(request, response);
		
	}

}
