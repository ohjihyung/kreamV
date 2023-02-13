package kr.co.kreamv.stylegramReply.dao;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.StylegramReplyVO;


public interface IStylegramReplyDao {

	
	//해당게시물의 댓글리스트 출력
	public List<StylegramReplyVO> gramReplyList(int gramNum);
	
	// 스타일그램 댓글 작성
	public int insertBoardReply(Map<String, Object> map);
	
	// 스타일그램 댓글 수정
	public int updateBoardReply();
	
	// 스타일그램 글 삭제
	public int deleteBoardReply();
	
	
}
