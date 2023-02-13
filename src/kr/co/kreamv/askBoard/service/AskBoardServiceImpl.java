package kr.co.kreamv.askBoard.service;

import java.util.List;

import kr.co.kreamv.askBoard.dao.AskBoardDaoImpl;
import kr.co.kreamv.askBoard.dao.IaskBoardDao;
import kr.co.kreamv.vo.BoardVO;
import kr.co.kreamv.vo.SampleMemberVO;

public class AskBoardServiceImpl implements IaskBoardService {
	
	private IaskBoardDao dao;
	private static IaskBoardService service;
	
	private AskBoardServiceImpl() {
		dao = AskBoardDaoImpl.getInstance();
	}
	
	public static IaskBoardService getInstance(){
		if(service == null) service = new AskBoardServiceImpl();
		return service;
	}

	
	@Override
	public List<BoardVO> BoardList(String board_dnm) {
		List<BoardVO> list = null;
		list = dao.BoardList(board_dnm);
		return list;
	}

	@Override
	public int BoardInsert(BoardVO vo) {
		return dao.BoardInsert(vo);
	}

	@Override
	public int UpdateDe(BoardVO vo) {
		return dao.UpdateDe(vo);
	}

	@Override
	public int DeleteDe(String mem_id) {
		return dao.DeleteDe(mem_id);
	}

	@Override
	public BoardVO GetDetailDe(String board_num) {
		BoardVO getDetailDe = null;
		return getDetailDe;
	}
	
	
	// 매니저 게시판 조회
	@Override
	public List<BoardVO> ManaList(String board_nm) {
		List<BoardVO> ManaList = null;
		ManaList = dao.ManaList(board_nm);
		return ManaList;
	}
	
	@Override
	public int BoardInsert1(BoardVO vo) {
		return dao.BoardInsert1(vo);
	}

	@Override
	public int UpdateQu(BoardVO vo) {
		return dao.UpdateQu(vo);
	}

	@Override
	public int DeleteQu(String mem_id) {
		return dao.DeleteQu(mem_id);
	}

	@Override
	public BoardVO GetDetailQu(String board_num) {
		BoardVO getDetailQu = null;
		return getDetailQu;
	}


	



}
