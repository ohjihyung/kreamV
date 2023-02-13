package kr.co.kreamv.myList.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.co.kreamv.myList.service.IMyListService;
import kr.co.kreamv.myList.service.MyListServiceImpl;
import kr.co.kreamv.vo.MyBuyVO;

@WebServlet("/myStoreList.do")
public class MyStoreList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		HttpSession session = request.getSession();
		IMyListService serviceML = MyListServiceImpl.getInstance();
		
		List<MyBuyVO> myBuyList = new ArrayList<MyBuyVO>();
		
		if(Integer.parseInt(request.getParameter("storeNo"))==1) {			
			myBuyList = serviceML.myConfirmList((String)session.getAttribute("loginId"));	// 검수 중 리스트
		}else if(Integer.parseInt(request.getParameter("storeNo"))==2) {
			myBuyList = serviceML.myStoreList((String)session.getAttribute("loginId"));	// 보관 중 리스트
		}else {
			myBuyList = serviceML.mySendBackList((String)session.getAttribute("loginId"));	// 반송 리스트
		}
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		
		out.write(gson.toJson(myBuyList));
		
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
