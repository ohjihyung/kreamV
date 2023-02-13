package kr.co.kreamv.boardReply.service;

import java.util.List;

import kr.co.kreamv.vo.BoardReplyVO;


public interface IBoardReplyService {

	
	// Q&A 댓글 작성
	public int insertQnaReply();
	
	// Q&A 댓글 수정
	public int updateQnaReply();
	
	// Q&A 댓글 삭제
	public int deleteQnaReply();
	
	// Q&A 댓글 리스트 보기
	public List<BoardReplyVO> replyList();

	
}
