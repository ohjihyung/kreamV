package kr.co.kreamv.wish.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.wish.service.IWishService;
import kr.co.kreamv.wish.service.WishServiceImpl;

@WebServlet("/wishList.do")
public class WishList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		IWishService service = WishServiceImpl.getInstance();
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("loginId");
		
		List<ProdVO> wishList = service.wishList(mem_id);
		request.setAttribute("wishList", wishList);
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
	
		out.write(gson.toJson(wishList));
		
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
