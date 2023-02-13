package kr.co.kreamv.boardReply.dao;

import java.util.List;

import kr.co.kreamv.vo.BoardReplyVO;




public interface IBoardReplyDao {

	
	
	// Q&A 댓글 작성
	public int insertQnaReply();
	
	// Q&A 댓글 수정
	public int updateQnaReply();
	
	// Q&A 댓글 삭제
	public int deleteQnaReply();
	
	// Q&A 댓글 리스트 보기
	public List<BoardReplyVO> replyList();
	
	// ⑤ 문의 게시판 댓글 조회
	
	
	// ⑥ 문의 게시판 댓글 작성
	
	
	// ⑦ 문의 게시판 댓글 수정
	
	
	// ⑧ 문의 게시판 댓글 삭제
	
	
}
