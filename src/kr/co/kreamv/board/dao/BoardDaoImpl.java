package kr.co.kreamv.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {

	private SqlMapClient smc;
	private static IBoardDao dao;
	
	private BoardDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBoardDao getInstance(){
		if(dao==null) dao = new BoardDaoImpl();
		
		return dao;
	}

	//공지사항
	@Override
	public List<BoardVO> noticeList() {
		List<BoardVO> notceiList = null;
		
		try {
			notceiList = smc.queryForList("board.noticeList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notceiList;
	}

	@Override
	public int insertNotice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//자주묻는 질문
	@Override
	public List<BoardVO> qnaList() {
		List<BoardVO> qnaList = null;
		
		try {
			qnaList = smc.queryForList("board.qnaList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaList;
	}

	@Override
	public int insertQna() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQna() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteQna() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//검수기준
	@Override
	public List<BoardVO> standardList() {
		List<BoardVO> standardList = null;
		
		try {
			standardList = smc.queryForList("board.standardList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return standardList;
	}
	
}
