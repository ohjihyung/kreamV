package kr.co.kreamv.orders.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.OrdersVO;

public class OrdersDaoImpl implements IOrdersDao {
	private SqlMapClient smc = null;
	private static IOrdersDao dao;
	private  OrdersDaoImpl() {
		smc  = SqlMapClientFactory.getSqlMapClient();
	}
	public static IOrdersDao getInstance() {
		if(dao == null) dao = new OrdersDaoImpl();
		return dao;
	}
	
	@Override
	public int insertOrders(OrdersVO ordersVo) {
		int count = 0;
		
		try {
			Object obj = smc.insert("orders.insertOrders", ordersVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public int updateOrderState(Map<String, Object> map) {
		int count = 0;
		
		try {
			count = smc.update("orders.updateOrderState", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public OrdersVO getOrders(String order_id) {
		OrdersVO ordersVo = null;
		
		try {
			ordersVo = (OrdersVO)smc.queryForObject("orders.getOrders", order_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ordersVo;
	}
	@Override
	public List<OrdersVO> getMKPrice(String prod_id) {
		List<OrdersVO> ordersList = null;
		
		try {
			ordersList = smc.queryForList("orders.getMKPrice", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ordersList;
	}

}
