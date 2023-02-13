package kr.co.kreamv.proddetail.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.proddetail.service.IProdDetailService;
import kr.co.kreamv.proddetail.service.ProdDetailServiceImpl;
import kr.co.kreamv.sellBid.service.ISellBidService;
import kr.co.kreamv.sellBid.service.SellBidServiceImpl;
import kr.co.kreamv.vo.ProdDetailVO;
import kr.co.kreamv.vo.ProdVO;

@WebServlet("/sellProdDetailList.do")
public class SellProdDetailList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IProdDetailService service = ProdDetailServiceImpl.getInstance();
		List<ProdDetailVO> prodDetailList = (List<ProdDetailVO>)service.prodDetailList(request.getParameter("prodId"));
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		ProdVO prodVo = serviceP.getProd(request.getParameter("prodId"));
		
		/*
		ISellBidService serviceSB = SellBidServiceImpl.getInstance();
		HashMap<String, Integer> sellBidMap = null;
		for(ProdDetailVO prodDetailVo : prodDetailList) {
			int price;
			if(( price = serviceSB.minSellBid(prodDetailVo.getDetail_id()))!=0) {				
				sellBidMap.put(prodDetailVo.getDetail_id(), price);
			};
		}
		*/
		
		request.setAttribute("type", 1);
		request.setAttribute("prodDetailList", prodDetailList);
		request.setAttribute("prodVo", prodVo);
//		request.setAttribute("sellBidMap", sellBidMap);
		
		request.getRequestDispatcher("/view/prodDetail.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
