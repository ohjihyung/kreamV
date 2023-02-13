package kr.co.kreamv.sellBid.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.SellBidVO;

public interface ISellBidService {
	public SellBidVO minSellBid(String detail_id);
	
	public SellBidVO sellBidInfo(String sell_bid_id);
	
	public int insertSellBid(SellBidVO sellBidVo);
	
	/**
	 * 판매 입찰 번호를 통해 검수 번호는 가져오는 메서드
	 * @param sell_bid_id 판매입찰번호
	 * @return 검수번호
	 */
	public String getConfirmId(String sell_bid_id);
	
	/**
	 * 판매 입찰 상태 값을 변경하는 메서드
	 * @param sell_bid_id 새로운 상태 값
	 * @return 성공 : 1, 실패 : 0
	 */
	public int  updateSellBidState(Map<String, String> map);
	
	/**
	 * 검수 번호를 이용하여 판매 입찰 정보를 가져온다.
	 * @param confirm_id 검수번호
	 * @return 판매입찰VO
	 */
	public SellBidVO getSellBid(String confirm_id);
	
	/**
	 * 기존 판매 입찰 데이터의 가격과 시작/종료 날짜를 변경하는 메서드
	 * @param map 검수번호, 입찰 가격, 입찰 종료날짜
	 * @return 업데이트 개수
	 */
	public int changeSellBid(Map<String, Object> map);
	
	/**
	 * 판매입찰 데이터를 삭제하는 메서드
	 * @param confirm_id 검수번호
	 * @return 삭제 개수
	 */
	public int deleteSellBid(String confirm_id);
}
