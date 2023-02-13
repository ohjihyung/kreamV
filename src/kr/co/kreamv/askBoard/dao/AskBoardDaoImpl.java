package kr.co.kreamv.askBoard.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.BoardVO;

public class AskBoardDaoImpl implements IaskBoardDao {
	private SqlMapClient smc;
	private static IaskBoardDao dao;
	
	private AskBoardDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IaskBoardDao getInstance() {
		if(dao == null) dao = new AskBoardDaoImpl();
		return dao;
	}
	
	// 게시판 조회
	@Override
	public List<BoardVO> BoardList(String board_dnm) {
		List<BoardVO> list = null;
		try {
			list = smc.queryForList("askBoard.BoardList", board_dnm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 게시판 저장
	@Override
	public int BoardInsert(BoardVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("askBoard.BoardInsert", vo);
			if(obj==null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 배송 게시판 수정
	@Override
	public int UpdateDe(BoardVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("askBoard.UpdateDe", vo);
			if(obj==null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	// 배송 게시판 삭제 
	@Override
	public int DeleteDe(String mem_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("askBoard.DeleteDe", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	// 배송 게시판 상세보기
	@Override
	public BoardVO GetDetailDe(String board_num) {
		BoardVO getDetailDe = null;
		try {
			getDetailDe = (BoardVO) smc.queryForList("askBoard.GetDetailDe", board_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getDetailDe;
	}

	// 상품문의 게시판 조회
    @Override
    public List<BoardVO> ManaList(String board_nm) {
        List<BoardVO> ManaList = null;
        try {
        	ManaList = smc.queryForList("askBoard.ManaList", board_nm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ManaList;
    }
    
	@Override
	public int BoardInsert1(BoardVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("askBoard.BoardInsert1", vo);
			if(obj==null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int UpdateQu(BoardVO vo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("askBoard.UpdateQu", vo);
			if(obj==null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int DeleteQu(String mem_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("askBoard.DeleteQu", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public BoardVO GetDetailQu(String board_num) {
		BoardVO getDetailQu = null;
		try {
			getDetailQu = (BoardVO) smc.queryForList("askBoard.GetDetailQu", board_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getDetailQu;
	}


	

}
