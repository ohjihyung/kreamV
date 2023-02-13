package kr.co.kreamv.store.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.store.service.IStoreService;
import kr.co.kreamv.store.service.StoreServiceImpl;

@WebServlet("/checkStore.do")
public class CheckStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IStoreService service = StoreServiceImpl.getInstance();
		
		Gson gson = new Gson();	// Gson객체 생성 ==> JSON으로 변환하는 객체
		String jsonData = null;
		
		int res = service.checkStore(request.getParameter("mem_id"));
		jsonData = gson.toJson(res);
		
//		response.setContentType("text/html; charset=utf-8"); // 기존 형태
//		response.setContentType("application/json; charset=utf-8");	// 응답을 JSON으로 하겠다는 설정
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
