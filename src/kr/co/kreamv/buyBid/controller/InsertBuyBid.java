package kr.co.kreamv.buyBid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import kr.co.kreamv.buyBid.service.BuyBidServiceImpl;
import kr.co.kreamv.buyBid.service.IBuyBidService;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.vo.BuyBidVO;
import kr.co.kreamv.vo.SampleMemberVO;

/**
 * Servlet implementation class InsertBuyBid
 */
@WebServlet("/insertBuyBid.do")
public class InsertBuyBid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BuyBidVO buyBidVo = new BuyBidVO();
		
		buyBidVo.setDetail_id(request.getParameter("datail_id"));
		buyBidVo.setBuy_bid_price(Integer.parseInt(request.getParameter("buy_bid_price")));
		buyBidVo.setBuy_bid_fdate(request.getParameter("buy_bid_fdate"));
		buyBidVo.setMem_id(request.getParameter("mem_id"));
		
		IBuyBidService service = BuyBidServiceImpl.getInstance();
		service.insertBuyBid(buyBidVo);
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		request.setAttribute("prodVo", serviceP.getProd(request.getParameter("prod_id")));
		request.setAttribute("completeType", 3);	// 입찰 완료 타입

		request.getRequestDispatcher("view/completeBid.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
