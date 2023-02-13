package kr.co.kreamv.orders.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kreamv.buyBid.service.BuyBidServiceImpl;
import kr.co.kreamv.buyBid.service.IBuyBidService;
import kr.co.kreamv.orders.service.IOrdersService;
import kr.co.kreamv.orders.service.OrdersServiceImpl;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.proddetail.service.IProdDetailService;
import kr.co.kreamv.proddetail.service.ProdDetailServiceImpl;
import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;
import kr.co.kreamv.vo.BuyBidVO;
import kr.co.kreamv.vo.OrdersVO;
import kr.co.kreamv.vo.ProdDetailVO;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.SampleMemberVO;

@WebServlet("/payOrdersTemp.do")
public class PayOrdersTemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String order_id = request.getParameter("order_id");
		
		IOrdersService serviceO = OrdersServiceImpl.getInstance();
		IBuyBidService serviceBB = BuyBidServiceImpl.getInstance();
		IProdDetailService servicePD = ProdDetailServiceImpl.getInstance();
		IprodService serviceP = ProdServiceImpl.getInstance();
		
		//confirm_id 가져오기
		OrdersVO ordersVo = serviceO.getOrders(order_id);
		
		//bid 가져오기
		BuyBidVO buyBidVo = serviceBB.getBuyBidByOrderId(order_id);
		
		//detail 가져오기
		ProdDetailVO prodDetailVo = servicePD.GetProdDetail(buyBidVo.getDetail_id());
		
		//prod 가져오기
		ProdVO prodVo = serviceP.getProd(prodDetailVo.getProd_id());
		
		HttpSession session = request.getSession();
		IsampleMemberService serviceM = SampleMemberServiceImpl.getInstance();
		SampleMemberVO memberVo = serviceM.getprofile((String)session.getAttribute("loginId"));
		request.setAttribute("memberVo", memberVo);
		
		request.setAttribute("type", 2);
		request.setAttribute("prodVo", prodVo);
		request.setAttribute("prodDetailVo", prodDetailVo);
		request.setAttribute("buy_bid_price", Integer.toString(buyBidVo.getBuy_bid_price()));
		request.setAttribute("order_id", order_id);
		request.setAttribute("confirm_id", ordersVo.getConfirm_id());
	
		request.getRequestDispatcher("view/pay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
