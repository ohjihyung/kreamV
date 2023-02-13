package kr.co.kreamv.orders.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.buyBid.service.BuyBidServiceImpl;
import kr.co.kreamv.buyBid.service.IBuyBidService;
import kr.co.kreamv.deliver.service.DeliverServiceImpl;
import kr.co.kreamv.deliver.service.IDeliverService;
import kr.co.kreamv.orders.service.IOrdersService;
import kr.co.kreamv.orders.service.OrdersServiceImpl;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.sellBid.service.ISellBidService;
import kr.co.kreamv.sellBid.service.SellBidServiceImpl;
import kr.co.kreamv.store.service.IStoreService;
import kr.co.kreamv.store.service.StoreServiceImpl;
import kr.co.kreamv.vo.OrdersVO;

@WebServlet("/insertOrders.do")
public class InsertOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	      	<input type="text" class="data" name="sell_bid_price" value="<%=request.getAttribute("sell_bid_price")%>">
//	      	<input type="text" class="data" name="sell_bid_id" value="<%=request.getAttribute("sell_bid_id")%>">
//	      	<input type="text" class="data" name="datail_id" value="<%=prodDetailVo.getDetail_id()%>">
//	      	<input type="text" class="data" name="mem_id" value="<%=vo.getMem_id()%>">
	      	
		//즉시 구매와 즉시 판매가 있다.
		request.setCharacterEncoding("utf-8");
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		IOrdersService serviceO = OrdersServiceImpl.getInstance();
		ISellBidService serviceSB = SellBidServiceImpl.getInstance();
		IBuyBidService serviceBB = BuyBidServiceImpl.getInstance();
		IStoreService serviceS = StoreServiceImpl.getInstance();
		IDeliverService serviceD = DeliverServiceImpl.getInstance();
		OrdersVO ordersVo = new OrdersVO();
		
			if(request.getParameter("type").equals("buy")) {	// 즉시 구매일 경우
				ordersVo.setBuy_bid_id("-");			
				ordersVo.setSell_bid_id(request.getParameter("sell_bid_id"));	

				String confirm_id = serviceSB.getConfirmId(request.getParameter("sell_bid_id"));
				ordersVo.setConfirm_id(confirm_id);
	
				ordersVo.setMem_id((String)request.getParameter("mem_id"));
				ordersVo.setOrder_price(Integer.parseInt(request.getParameter("sell_bid_price")));
				ordersVo.setOrder_state(2);
				
				serviceO.insertOrders(ordersVo);
				
				serviceD.insertDeliver(confirm_id);
				
				HashMap<String, String> map1 = new HashMap<String, String>();
				map1.put("sell_bid_state", "2");
				map1.put("sell_bid_id", (String)request.getParameter("sell_bid_id"));
				
				serviceSB.updateSellBidState(map1);
				
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("store_state", "2");
				map2.put("confirm_id", confirm_id);
				serviceS.updateStoreState(map2);
				
				Map<String, Object> map3 = new HashMap<String, Object>();
				map3.put("prod_mkprice", Integer.parseInt(request.getParameter("sell_bid_price")));
				map3.put("prod_id", request.getParameter("prod_id"));
				serviceP.updateMKPrice(map3);				// 최근 거래가 변경
				
				request.setAttribute("completeType", 2);	// 결제 완료 타입
				
			}else {	// 즉시 판매일 경우
				if(Integer.parseInt(request.getParameter("storeType"))==3)	{// 입찰상품 -> 즉시판매
					serviceSB.deleteSellBid(request.getParameter("confirm_id"));
					
				}
	
				ordersVo.setMem_id(serviceBB.getBuyBidMemId(request.getParameter("buy_bid_id")));
				ordersVo.setBuy_bid_id(request.getParameter("buy_bid_id"));
				ordersVo.setSell_bid_id("-");
				ordersVo.setConfirm_id(request.getParameter("confirm_id"));
				ordersVo.setOrder_price(Integer.parseInt(request.getParameter("price")));
				ordersVo.setOrder_state(1);
				serviceO.insertOrders(ordersVo);
				
				HashMap<String, Object> map1 = new HashMap<String, Object>();
				map1.put("confirm_id", request.getParameter("confirm_id"));
				map1.put("bid_check", 2);
				serviceS.updateBidCheck(map1);

				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("buy_bid_state", 1);
				map2.put("buy_bid_id", request.getParameter("buy_bid_id"));
				serviceBB.updateBuyBidState(map2);
				
				request.setAttribute("completeType", 4);	// 결제 완료 타입
				
			}
			request.setAttribute("prodVo", serviceP.getProd(request.getParameter("prod_id")));
		request.getRequestDispatcher("view/completeBid.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
