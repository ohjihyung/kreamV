package kr.co.kreamv.wish.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.WishVO;

public class WishDaoImpl implements IWishDao {

	private SqlMapClient smc = null;
	private static WishDaoImpl dao;
	private  WishDaoImpl() {
		smc  = SqlMapClientFactory.getSqlMapClient();
	}
	public static IWishDao getInstance() {
		if(dao == null) dao = new WishDaoImpl();
		return dao;
	}
	
	@Override
	public int wishProd(WishVO WishVO) {
		return 0;
	}


	@Override
	public int insertWish(WishVO wishVo) {
		int count = 0;
		
		try {
			Object obj = smc.insert("wish.insertWish", wishVo);
			if(obj==null) count = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int checkWish(WishVO wishVo) {
		int count = 0;
		
		try {
			count = (int) smc.queryForObject("wish.checkWish", wishVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int wishCancelProd(WishVO wishVo) {
		int count = 0;
		
		try {
			count = smc.delete("wish.wishCancelProd", wishVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int countWish(String prod_id) {
		int count = 0;
		
		try {
			count = (int)smc.queryForObject("wish.countWish", prod_id);
		} catch (SQLException e) {
			count=0;
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public List<ProdVO> wishList(String mem_id) {
		List<ProdVO> wishList = null;
		
		try {
			wishList = smc.queryForList("wish.wishList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wishList;
	}

}
