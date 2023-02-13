package kr.co.kreamv.store.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.SellableVO;

public interface IStoreService {
	/**
	 * 회원이 보관하고있는 상품 개수를 출력하는 메서드
	 * @param mem_id 회원 아이디
	 * @return 보관 상품 개수
	 */
	public int checkStore(String mem_id);
	
	/**
	 * 회원의 보관 상품 중 판매입찰이 가능한 상품들만 가져오는 메서드
	 * (입찰을 넣지 않은 보관 상품과 입찰중이지만 주문이 이루어지지 않은 보관 상품)
	 * @param map 회원ID와 상품 디테일ID를 담는다.
	 * @return 보관상품 리스트 반환
	 */
	public List<SellableVO> getSellableStore(Map<String, Object> map);
	
	/**
	 * 보관 테이블의 입찰 여부값을 변경하는 메서드
	 * @param bid_check 입찰 여부 값
	 * @return 변경 컬럼 개수
	 */
	public int updateBidCheck(Map<String, Object> map);
	
	/**
	 * 검수번호를 이용하여 보관테이블의 상품 보관 상태를 변경하는 메서드
	 * @param map confirm_id, 보관상태값
	 * @return 변경 개수
	 */
	public int updateStoreState(Map<String, Object> map);
}
