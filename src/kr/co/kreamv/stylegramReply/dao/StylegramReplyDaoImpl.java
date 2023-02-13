package kr.co.kreamv.stylegramReply.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.StylegramReplyVO;

public class StylegramReplyDaoImpl implements IStylegramReplyDao {

	private SqlMapClient smc;
	private static IStylegramReplyDao dao;
	
	private StylegramReplyDaoImpl(){
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IStylegramReplyDao getInstance(){
		if(dao==null) dao = new StylegramReplyDaoImpl();
		
		return dao;
	}
	
	//해당게시물의 댓글리스트 출력
	@Override
	public List<StylegramReplyVO> gramReplyList(int gramNum) {
		List<StylegramReplyVO> list = null;
		
		try {
			list = smc.queryForList("style.gramReplyList", gramNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//댓글 insert
	@Override
	public int insertBoardReply(Map<String, Object> map) {
		int count = 0;
		
		try {
			count = smc.update("style.insertBoardReply", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int updateBoardReply() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardReply() {
		// TODO Auto-generated method stub
		return 0;
	}

}
