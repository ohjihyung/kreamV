package kr.co.kreamv.buyBid.dao;

import java.util.Map;

import kr.co.kreamv.vo.BuyBidVO;

public interface IBuyBidDao {
	public int insertBuyBid(BuyBidVO buyBidVo);
	
	public BuyBidVO minBuyBid(String detail_id);
	
	/**
	 * 구매입찰의 입찰상태 값을 바꾸는 메서드
	 * @param map 구매입찰번호, 상태값
	 * @return 변경 개수
	 */
	public int updateBuyBidState(Map<String, Object> map);
	
	/**
	 * 구매 입찰 올린 회원 ID를 가져오는 메서드
	 * @param buy_bid_id 구매입찰번호
	 * @return 회원ID
	 */
	public String getBuyBidMemId(String buy_bid_id);
	
	/**
	 * order_id값을 이용해서 buy_bid 테이블에서 데이터를 가져오는 메서드
	 * @param order_id 주문 번호
	 * @return BuyBidVO
	 */
	public BuyBidVO getBuyBidByOrderId(String order_id);
}
