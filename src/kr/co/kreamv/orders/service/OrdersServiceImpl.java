package kr.co.kreamv.orders.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.orders.dao.IOrdersDao;
import kr.co.kreamv.orders.dao.OrdersDaoImpl;
import kr.co.kreamv.vo.OrdersVO;

public class OrdersServiceImpl implements IOrdersService {
	private static IOrdersService service = null;
	private IOrdersDao dao = null;
	private OrdersServiceImpl() {
		dao = OrdersDaoImpl.getInstance();
	}
	public static IOrdersService getInstance() {
		if(service == null) service = new OrdersServiceImpl();
		return service;
	}
	
	@Override
	public int insertOrders(OrdersVO OrdersVo) {
		return dao.insertOrders(OrdersVo);
	}
	@Override
	public int updateOrderState(Map<String, Object> map) {
		return dao.updateOrderState(map);
	}
	@Override
	public OrdersVO getOrders(String order_id) {
		return dao.getOrders(order_id);
	}
	@Override
	public List<OrdersVO> getMKPrice(String prod_id) {
		return dao.getMKPrice(prod_id);
	}

}
