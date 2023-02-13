package kr.co.kreamv.stylegram.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.StyleProdVO;

public class StyleGrameDaoImpl implements IStylegramDao {

	private SqlMapClient smc;
	private static IStylegramDao dao;
	
	private StyleGrameDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IStylegramDao getInstance(){
		if(dao==null) dao = new StyleGrameDaoImpl();
		
		return dao;
	}

	
	
	//선택한 스타일그램 상세보기
	@Override
	public List<StyleProdVO> stylegramDetail(int gramNum) {
		List<StyleProdVO> list = null;
		
		try {
			list = smc.queryForList("style.stylegramDetail", gramNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//최신 스타일그램 리스트
	@Override
	public List<StyleProdVO> stylegramNewList() {
		List<StyleProdVO> list = null;
		
		try {
			list = smc.queryForList("style.stylegramNewList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//인기 스타일그램 리스트
	@Override
	public List<StyleProdVO> stylegramHitList() {
		List<StyleProdVO> list = null;
		
		try {
			list = smc.queryForList("style.stylegramHitList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//배송정보에서 구입한 상품 목록
	@Override
	public List<ProdVO> stylegramProd(String id) {
		List<ProdVO> list = null;
		
		try {
			list = smc.queryForList("style.stylegramProd", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//스타일그램 작성
	@Override
	public int stylegramInsert(Map<String, String> map) {
		int count = 0;
		
		try {
			count = smc.update("style.stylegramInsert", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StyleProdVO> stylegramLikeList(String mem_id) {
		List<StyleProdVO> list = null;
		
		try {
			list = smc.queryForList("style.stylegramLikeList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int checkLikeGram(Map<String, Object> map) {
		int count = 0;
		
		try {
			count = (int)smc.queryForObject("gramLike.checkLikeGram", map);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		
		return count;
	}

	





}
