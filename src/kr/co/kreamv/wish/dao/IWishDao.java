package kr.co.kreamv.wish.dao;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.WishVO;

public interface IWishDao {
	
	/**
	 * 회원이 찜한 상품 목록을 가져오는 메서드
	 * @param mem_id 회원ID
	 * @return 상품목록
	 */
	public List<ProdVO> wishList(String mem_id);

	// 상품 찜하기
	public int wishProd(WishVO WishVO);
	
	/**
	 * 찜 상품 취소
	 * @param wishVo
	 * @return 작업 성공 : 1
	 */
	public int wishCancelProd(WishVO wishVo);
	
	/**
	 * wish테이블에 데이터를 추가하는 메서드
	 * @param WishVO 회원ID, 상품ID
	 * @return 작업 성공 : 1
	 */
	public int insertWish(WishVO wishVo);
	
	/**
	 * 이미 등록된 관심상품인지 확인하는 메서드
	 * @param wishVo 
	 * @return 있으면 1 , 없으면 0
	 */
	public int checkWish(WishVO wishVo);
	
	/**
	 * 해당 상품의 찜 개수를 가져오는 메서드
	 * @param prod_id 상품 아이디
	 * @return 찜 개수
	 */
	public int countWish(String prod_id);
}
