package kr.co.kreamv.gramLike.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.LikegramVO;


public class StylegramLikeDaoImpl implements IStylegramLikeDao {

	private SqlMapClient smc;
	private static IStylegramLikeDao dao;
	
	private StylegramLikeDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IStylegramLikeDao getInstance(){
		if(dao==null) dao = new StylegramLikeDaoImpl();
		
		return dao;
	}
	
	//좋아요insert
	@Override
	public int likeGram(LikegramVO vo) {
		int count = 0;
		
		try {
			count = smc.update("gramLike.likegram", vo);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	//좋아요list
	@Override
	public List<LikegramVO> likeGramList(String memId) {
		List<LikegramVO> list = null;
		
		try {
			list = (List<LikegramVO>)smc.queryForList("gramLike.likeGramList", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getLikeCount(int gramNum) {
		int getNumLikeCount = 0;
		try {
			getNumLikeCount = (int)smc.queryForObject("gramLike.getLikeCount", gramNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getNumLikeCount;
	}

	@Override
	public int minuLike(LikegramVO vo) {
		// TODO Auto-generated method stub
		int minusLikeResult = 0;
		try {
			minusLikeResult = smc.update("gramLike.minuLike", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return minusLikeResult;
	}


}
