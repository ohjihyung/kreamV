package kr.co.kreamv.askBoard.service;

import java.util.List;

import kr.co.kreamv.vo.BoardVO;

public interface IaskBoardService {
	
	// 게시판 리스트 조회
	public List<BoardVO> BoardList(String board_dnm);
	
	// 게시글 작성(저장하기)
	public int BoardInsert(BoardVO vo);
	
	// 배송문의 게시판 수정
	public int UpdateDe(BoardVO vo);
	
	// 배송문의 게시판 삭제
	public int DeleteDe(String mem_id);
	
	// 배송문의 게시판 상세보기
	public BoardVO GetDetailDe(String board_num);
	
	
	// 매니저 게시판 조회
	public List<BoardVO> ManaList(String board_nm);
	
	// 상품문의 게시판 작성
	public int BoardInsert1(BoardVO vo);
	
	// 상품문의 게시판 수정
	public int UpdateQu(BoardVO vo);
	
	// 상품문의 게시판 삭제
	public int DeleteQu(String mem_id);	
	
	// 상품문의 게시판 상세보기
	public BoardVO GetDetailQu(String board_num);
      
}
