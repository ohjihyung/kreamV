package kr.co.kreamv.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.vo.ProdVO;

@WebServlet("/searchProdList.do")
public class SearchProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		IprodService service = ProdServiceImpl.getInstance();
		
		Gson gson = new Gson();
		
		String search = request.getParameter("search");

		List<ProdVO> searchProdList = service.searchProdList(search);
		
		String jsonData = gson.toJson(searchProdList);
		
		//request.setAttribute("searchProdList",searchProdList);
		System.out.println(jsonData);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
