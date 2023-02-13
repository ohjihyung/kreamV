package kr.co.kreamv.proddetail.controller;

import java.io.IOException;
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
import kr.co.kreamv.vo.ProdDetailVO;
import kr.co.kreamv.vo.ProdVO;

@WebServlet("/buyProdDetailList.do")
public class BuyProdDetailList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IProdDetailService service = ProdDetailServiceImpl.getInstance();
		List<ProdDetailVO> prodDetailList = (List<ProdDetailVO>)service.prodDetailList(request.getParameter("prodId"));
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		ProdVO prodVo = serviceP.getProd(request.getParameter("prodId"));
		
		/*
		ISellBidService service2 = SellBidServiceImpl.getInstance();
		HashMap<String, Integer> sellBidMap = null;
		for(ProdDetailVO prodDetailVo : prodDetailList) {
			int price;
			if(( price = service2.minSellBid(prodDetailVo.getDetail_id()))!=0) {				
				sellBidMap.put(prodDetailVo.getDetail_id(), price);
			};
		}
		*/
		
		request.setAttribute("type", 0);
		request.setAttribute("prodDetailList", prodDetailList);
		request.setAttribute("prodVo", prodVo);
//		request.setAttribute("sellBidMap", sellBidMap);
		
		request.getRequestDispatcher("/view/prodDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
