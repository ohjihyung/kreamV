package kr.co.kreamv.buyBid.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.buyBid.service.BuyBidServiceImpl;
import kr.co.kreamv.buyBid.service.IBuyBidService;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.proddetail.service.IProdDetailService;
import kr.co.kreamv.proddetail.service.ProdDetailServiceImpl;
import kr.co.kreamv.sellBid.service.ISellBidService;
import kr.co.kreamv.sellBid.service.SellBidServiceImpl;
import kr.co.kreamv.vo.BuyBidVO;
import kr.co.kreamv.vo.ProdDetailVO;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.SellBidVO;

@WebServlet("/buyBidInfo.do")
public class BuyBidInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		IProdDetailService servicePD = ProdDetailServiceImpl.getInstance();
		ProdDetailVO prodDetailVo = servicePD.GetProdDetail(request.getParameter("detail_id"));
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		ProdVO prodVo = serviceP.getProd(prodDetailVo.getProd_id());
		
		IBuyBidService serviceBB = BuyBidServiceImpl.getInstance();
		BuyBidVO BuyBidVo = (BuyBidVO)serviceBB.minBuyBid(request.getParameter("detail_id"));
		
		if(type==3) {
			ISellBidService serviceSB = SellBidServiceImpl.getInstance();
			SellBidVO sellBidVo = serviceSB.getSellBid(request.getParameter("confirm_id"));
			request.setAttribute("sellBidVo", sellBidVo);
		}
		
		request.setAttribute("confirm_id", request.getParameter("confirm_id"));
		request.setAttribute("type", type);
		request.setAttribute("prodDetailVo", prodDetailVo);
		request.setAttribute("buyBidVo", BuyBidVo);
		request.setAttribute("prodVo", prodVo);
		
		request.getRequestDispatcher("view/sell1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
