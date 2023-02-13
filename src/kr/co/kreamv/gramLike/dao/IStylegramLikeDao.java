package kr.co.kreamv.gramLike.dao;


import java.util.List;

import kr.co.kreamv.vo.LikegramVO;

public interface IStylegramLikeDao {
	
	// 스타일그램 좋아요
	public int likeGram(LikegramVO vo);
	
	//좋아요 리스트
	public List<LikegramVO> likeGramList(String memId);
	
	// 좋아요갯수 새로고침 없이 가져오는 메소드
	public int getLikeCount(int gramNum);
	
	// 좋아요 취소
	public int minuLike(LikegramVO vo);
}
