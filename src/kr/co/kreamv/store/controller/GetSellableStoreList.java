package kr.co.kreamv.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.store.service.IStoreService;
import kr.co.kreamv.store.service.StoreServiceImpl;
import kr.co.kreamv.vo.SellableVO;

@WebServlet("/getSellableStoreList.do")
public class GetSellableStoreList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", request.getParameter("mem_id"));
		map.put("detail_id", request.getParameter("detail_id"));
		
		IStoreService serviceS = StoreServiceImpl.getInstance();
		List<SellableVO> sellableList = (List<SellableVO>)serviceS.getSellableStore(map);
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		
		out.write(gson.toJson(sellableList));
		
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
