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

@WebServlet("/mySellList.do")
public class MySellList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		HttpSession session = request.getSession();
		IMyListService serviceML = MyListServiceImpl.getInstance();
		
		List<MyBuyVO> myBuyList = new ArrayList<MyBuyVO>();
		
		if(Integer.parseInt(request.getParameter("sellNo"))==1) {			
			myBuyList = serviceML.mySellBidList((String)session.getAttribute("loginId"));	// 입찰 중 리스트
		}else if(Integer.parseInt(request.getParameter("sellNo"))==2) {
			myBuyList = serviceML.mySellStayList((String)session.getAttribute("loginId"));	// 결제 대기 리스트
		}else {
			myBuyList = serviceML.mySellOrderList((String)session.getAttribute("loginId"));	// 결제 완료 리스트
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
