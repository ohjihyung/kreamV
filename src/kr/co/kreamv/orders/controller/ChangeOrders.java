package kr.co.kreamv.orders.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.deliver.service.DeliverServiceImpl;
import kr.co.kreamv.deliver.service.IDeliverService;
import kr.co.kreamv.orders.service.IOrdersService;
import kr.co.kreamv.orders.service.OrdersServiceImpl;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.store.service.IStoreService;
import kr.co.kreamv.store.service.StoreServiceImpl;

@WebServlet("/changeOrders.do")
public class ChangeOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String confirm_id = request.getParameter("confirm_id");
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		IStoreService serviceS = StoreServiceImpl.getInstance();
		IDeliverService serviceD = DeliverServiceImpl.getInstance();
		IOrdersService serviceO = OrdersServiceImpl.getInstance();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("order_state", 2);
		map1.put("order_id", request.getParameter("order_id"));
		serviceO.updateOrderState(map1);			// 주문 상태 변경
		
		serviceD.insertDeliver(confirm_id);			// 배송 추가
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("store_state", "2");
		map2.put("confirm_id", confirm_id);
		serviceS.updateStoreState(map2);			// 보관 상태 변경
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("prod_mkprice", Integer.parseInt(request.getParameter("buy_bid_price")));
		map3.put("prod_id", request.getParameter("prod_id"));
		serviceP.updateMKPrice(map3);				// 최근 거래가 변경
		
		request.setAttribute("completeType", 2);	// 결제 완료 타입
		
		request.setAttribute("prodVo", serviceP.getProd(request.getParameter("prod_id")));
		request.getRequestDispatcher("view/completeBid.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
