package kr.co.kreamv.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.co.kreamv.mypage.service.ImypageService;
import kr.co.kreamv.mypage.service.mypageServiceImpl;

/**
 * Servlet implementation class MypageUpdate
 */
@WebServlet("/MypageUpdate2.do")
public class MypageUpdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String updateHp = request.getParameter("updateHp");
		HttpSession session =  request.getSession();
		String id = (String) session.getAttribute("loginId");

			
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("updateId", id);
		map.put("updateHp", updateHp);
		
		ImypageService service = mypageServiceImpl.getInstance();
		
		int result = service.updateHp(map);
		
		String nameResult = null;
		Gson gson = new Gson();
		
//		System.out.println(result);
		
		if(result > 0) {
			nameResult = gson.toJson("핸드폰 번호 수정이 완료 되었습니다");
			out.println(nameResult);
			response.flushBuffer();
		}else {
			nameResult = gson.toJson("핸드폰 번호 수정에 실패 하었습니다");
			out.println(nameResult);
			response.flushBuffer();
		}
		
	}
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String updateSize = request.getParameter("updateSize");
		HttpSession session =  request.getSession();
		String id = (String) session.getAttribute("loginId");

			
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("updateId", id);
		map.put("updateSize", updateSize);
		
		ImypageService service = mypageServiceImpl.getInstance();
		
		int result = service.updateSize(map);
		
		String nameResult = null;
		Gson gson = new Gson();
		
		System.out.println(result);
		
		if(result > 0) {
			nameResult = gson.toJson("신발 사이즈 수정이 완료 되었습니다");
			out.println(nameResult);
			response.flushBuffer();
		}else {
			nameResult = gson.toJson("신발 사이즈 수정에 실패했습니다");
			out.println(nameResult);
			response.flushBuffer();
		}
	}
	
}
