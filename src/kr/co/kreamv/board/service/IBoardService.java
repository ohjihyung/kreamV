package kr.co.kreamv.board.service;

import java.util.List;

import kr.co.kreamv.vo.BoardVO;

public interface IBoardService {


	// 공지사항
	public List<BoardVO> noticeList();
		
	// 공지사항 글 작성
	public int insertNotice();
		
	// 공지사항 글 수정
	public int updateNotice();
		
	// 공지사항 글 삭제
	public int deleteNotice();
		
	// 자주묻는 질문(Q&A)
	public List<BoardVO> qnaList();
		
	// Q&A 작성
	public int insertQna();
		
	// Q&A 수정
	public int updateQna();
		
	// Q&A 삭제
	public int deleteQna();
	
	//검수기준
	public List<BoardVO> standardList();

	
}
