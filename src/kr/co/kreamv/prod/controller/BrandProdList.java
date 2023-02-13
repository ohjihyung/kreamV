package kr.co.kreamv.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.vo.ProdVO;

@WebServlet("/brandProdList.do")
public class BrandProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IprodService service = ProdServiceImpl.getInstance();
		
		Gson gson = new Gson();
		
		String brand_nm = request.getParameter("brand_nm");

		List<ProdVO> brandProdList = service.brandProdList(brand_nm);
		
		String jsonData = gson.toJson(brandProdList);
		
		request.setAttribute("brandProdList",brandProdList);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
