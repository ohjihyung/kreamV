package kr.co.kreamv.wish.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kreamv.vo.WishVO;
import kr.co.kreamv.wish.service.IWishService;
import kr.co.kreamv.wish.service.WishServiceImpl;

@WebServlet("/wishCancelProd.do")
public class WishCancelProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("loginId");
		String prod_id = request.getParameter("prod_id");
		
		IWishService serviceW = WishServiceImpl.getInstance();
		
		WishVO wishVo = new WishVO();
		wishVo.setMem_id(mem_id);
		wishVo.setProd_id(prod_id);
		
		int res = serviceW.wishCancelProd(wishVo);
		
		PrintWriter out = response.getWriter();
		out.print(res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
