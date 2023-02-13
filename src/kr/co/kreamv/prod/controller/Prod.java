package kr.co.kreamv.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kreamv.orders.service.IOrdersService;
import kr.co.kreamv.orders.service.OrdersServiceImpl;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.vo.OrdersVO;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.WishVO;
import kr.co.kreamv.wish.service.IWishService;
import kr.co.kreamv.wish.service.WishServiceImpl;

@WebServlet("/getProd.do")
public class Prod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String prodId = request.getParameter("prodId");
		
		HttpSession session = request.getSession();
		
		IprodService service = ProdServiceImpl.getInstance();
		IWishService serviceW = WishServiceImpl.getInstance();

		String mem_id = null;
		int wishCheck = 0;
		if((mem_id=(String)session.getAttribute("loginId"))!=null) {
			WishVO wishVo = new WishVO();
			wishVo.setMem_id(mem_id);
			wishVo.setProd_id(prodId);
			
			wishCheck = serviceW.checkWish(wishVo);
		}
		
		request.setAttribute("wishCheck", wishCheck);

		int wishCount = serviceW.countWish(prodId);
		request.setAttribute("wishCount", wishCount);
		
		ProdVO prodVO = service.getProd(prodId);
		request.setAttribute("prodVO", prodVO);
		
		
		IOrdersService serviceO = OrdersServiceImpl.getInstance();
		List<OrdersVO> ordersList = serviceO.getMKPrice(request.getParameter("prodId"));
		request.setAttribute("ordersList", ordersList);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/products.jsp");
		rd.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
