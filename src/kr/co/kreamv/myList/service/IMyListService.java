package kr.co.kreamv.myList.service;

import java.util.List;

import kr.co.kreamv.vo.MyBuyVO;

public interface IMyListService {

	/**
	 * 회원이 올려둔 구매 입찰 리스트를 가져오는 메서드
	 * @param mem_id 회원 아이디(구매자)
	 * @return 구매 입찰 리스트
	 */
	public List<MyBuyVO> myBuyBidList(String mem_id);

	/**
	 * 회원의 결제 완료 리스트를 가져오는 메서드
	 * @param mem_id 회원 아이디(구매자)
	 * @return 결제 완료 리스트
	 */
	public List<MyBuyVO> myBuyOrderList(String mem_id);

	/**
	 * 회원의 결제 대기 리스트를 가저오는 메서드
	 * @param mem_id 회원 아이디(구매자)
	 * @return 결제 대기 리스트
	 */
	public List<MyBuyVO> myBuyStayList(String mem_id);
	
	/**
	 * 회원이 올려둔 판매 입찰 리스트를 가져오는 메서드
	 * @param mem_id 회원 아이디(판매자)
	 * @return 판매 입찰 리스트
	 */
	public List<MyBuyVO> mySellBidList(String mem_id);

	/**
	 * 회원의 판매 대기 리스트를 가저오는 메서드
	 * @param mem_id 회원 아이디(판매자)
	 * @return 판매 대기 리스트
	 */
	public List<MyBuyVO> mySellStayList(String mem_id);

	/**
	 * 회원의 판매 완료된 리스트를 가져오는 메서드
	 * @param mem_id 회원 아이디(판매자)
	 * @return 판매 완료 리스트
	 */
	public List<MyBuyVO> mySellOrderList(String mem_id);
	
	/**
	 * 회원의 검수 신청 리스트를 가져오는 메서드
	 * @param mem_id 회원 아이디
	 * @return 검수 상품 리스트
	 */
	public List<MyBuyVO> myConfirmList(String mem_id);

	/**
	 * 회원의 보관 상품 리스트를 가져오는 메서드
	 * @param mem_id 회원 아이디
	 * @return 보관 상품 리스트
	 */
	public List<MyBuyVO> myStoreList(String mem_id);

	/**
	 * 회원의 반송 상품 리스트를 가져오는 메서드
	 * @param mem_id 회원 아이디
	 * @return 반송 상품 리스트
	 */
	public List<MyBuyVO> mySendBackList(String mem_id);
}
