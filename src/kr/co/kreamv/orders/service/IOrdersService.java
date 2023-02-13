package kr.co.kreamv.orders.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.OrdersVO;

public interface IOrdersService {
	/**
	 * 주문 테이블에 새로운 데이터 생성하는 메서드
	 * @param orderVo 주문테이블에 들어갈 정보
	 * @return 성공 : 1,  실패 : 0
	 */
	public int insertOrders(OrdersVO ordersVo);

	/**
	 * 주문 상태값을 변경하고 날짜를 오늘로 변경하는 메서드
	 * @param map 주문번호, 주문상태 값
	 * @return 변경 개수
	 */
	public int updateOrderState(Map<String, Object> map);
	
	/**
	 * order_id값에 해당하는 orders데이터를 가져온다.
	 * @param order_id 주문번호
	 * @return OrdersVO
	 */
	public OrdersVO getOrders(String order_id);
	
	
	/**
	 * 해당 상품의 최근 거래가격 7개를 가져오는 메서드
	 * @param prod_id 상품ID
	 * @return 거래가격 list
	 */
	public List<OrdersVO> getMKPrice(String prod_id);
}
