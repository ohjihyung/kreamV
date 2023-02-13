package kr.co.kreamv.stylegram.dao;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.StyleProdVO;


public interface IStylegramDao {
	
	// 최신 스타일그램 리스트 출력
	public List<StyleProdVO> stylegramNewList();
	
	// 인기 스타일그램 리스트 출력
	public List<StyleProdVO> stylegramHitList();
	
	//배송정보에서 구입한 상품 목록
	public List<ProdVO> stylegramProd(String id);
	
	//선택한 스타일그램 상세보기
	public List<StyleProdVO> stylegramDetail(int gramNum);
	
	// 스타일그램 글 작성
	public int stylegramInsert(Map<String, String> map);
	
	
	// 스타일그램 글 수정
	public int updateBoard();
	
	
	// 스타일그램 글 삭제
	public int deleteBoard();

	/**
	 * 회원이 좋아요를 누른 스타일그램 리스트를 가져오는 메서드
	 * @param mem_id 회원ID
	 * @return 회원의 스타일그램 좋아요 리스트
	 */
	public List<StyleProdVO> stylegramLikeList(String mem_id);
	
	/**
	 * 회원이 해당 스타일그램에 좋아요를 눌렀는지 확인하는 메서드
	 * @param map 회원ID, 그램NUM
	 * @return 좋아요 눌렀으면 1, 안눌렀으면 0
	 */
	public int checkLikeGram(Map<String, Object> map);
	
	
	
}
