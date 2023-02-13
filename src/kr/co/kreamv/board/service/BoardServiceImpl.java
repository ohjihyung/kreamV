package kr.co.kreamv.board.service;

import java.util.List;

import kr.co.kreamv.board.dao.BoardDaoImpl;
import kr.co.kreamv.board.dao.IBoardDao;
import kr.co.kreamv.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService boardService;
	private IBoardDao dao; 
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static IBoardService getInstance(){
		if(boardService==null) boardService = new BoardServiceImpl();
		return boardService;
	}

	//공지사항
	@Override
	public List<BoardVO> noticeList() {
		return dao.noticeList();
	}

	@Override
	public int insertNotice() {
		return 0;
	}

	@Override
	public int updateNotice() {
		return 0;
	}

	@Override
	public int deleteNotice() {
		return 0;
	}

	//자주묻는질문
	@Override
	public List<BoardVO> qnaList() {
		return dao.qnaList();
	}

	@Override
	public int insertQna() {
		return 0;
	}

	@Override
	public int updateQna() {
		return 0;
	}

	@Override
	public int deleteQna() {
		return 0;
	}
	
	//검수기준
	@Override
	public List<BoardVO> standardList() {
		return dao.standardList();
	}
	


}
