package kr.co.kreamv.sellBid.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.sellBid.service.ISellBidService;
import kr.co.kreamv.sellBid.service.SellBidServiceImpl;
import kr.co.kreamv.store.service.IStoreService;
import kr.co.kreamv.store.service.StoreServiceImpl;
import kr.co.kreamv.vo.SellBidVO;

@WebServlet("/insertSellBid.do")
public class InsertSellBid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		판매 입찰
//		1) 보관 상품 입찰(storeType=2) -> 새로운 입찰 등록
//		2) 입찰 상품 입찰(storeType=3) -> 기존 입찰 수정
		
		int storeType = Integer.parseInt(request.getParameter("storeType"));		
		ISellBidService serviceSB = SellBidServiceImpl.getInstance();

		if(storeType==2) {	// 보관 상품 입찰 (입찰 등록)
			SellBidVO sellBidVo = new SellBidVO();
			
			sellBidVo.setDetail_id(request.getParameter("detail_id"));
			sellBidVo.setSell_bid_price(Integer.parseInt(request.getParameter("price")));
			sellBidVo.setConfirm_id(request.getParameter("confirm_id"));
			sellBidVo.setSell_bid_fdate(request.getParameter("sell_bid_fdate"));
			
			int res = serviceSB.insertSellBid(sellBidVo);
			if(res!=0) {
				IStoreService serviceSS = StoreServiceImpl.getInstance();
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("confirm_id", request.getParameter("confirm_id"));
				map.put("bid_check", 1);
				serviceSS.updateBidCheck(map);
			}
			
		}else {	// 입찰 상품 입찰 (입찰 수정)
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("sell_bid_price", request.getParameter("price"));
			map.put("sell_bid_fdate", request.getParameter("sell_bid_fdate"));
			map.put("confirm_id", request.getParameter("confirm_id"));
			serviceSB.changeSellBid(map);
		}
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		request.setAttribute("prodVo", serviceP.getProd(request.getParameter("prod_id")));
		request.setAttribute("completeType", 3);	// 입찰 완료 타입
		
		request.getRequestDispatcher("view/completeBid.jsp").forward(request, response);
	}		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
