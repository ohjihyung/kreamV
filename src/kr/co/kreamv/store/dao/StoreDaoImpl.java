package kr.co.kreamv.store.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.SellableVO;

public class StoreDaoImpl implements IStoreDao {
	private SqlMapClient smc = null;
	private static IStoreDao dao;
	private  StoreDaoImpl() {
		smc  = SqlMapClientFactory.getSqlMapClient();
	}
	public static IStoreDao getInstance() {
		if(dao == null) dao = new StoreDaoImpl();
		return dao;
	}
	
	@Override
	public int checkStore(String mem_id) {
		int count = 0;
		
		try {
			count = (int)smc.queryForObject("store.checkStore", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	@Override
	public List<SellableVO> getSellableStore(Map<String, Object> map) {
		List<SellableVO> sellableList = null;
		
		try {
			sellableList = (List<SellableVO>)smc.queryForList("store.getSellableStore", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sellableList;
	}
	
	@Override
	public int updateBidCheck(Map<String, Object> map) {
		int count = 0;
		
		try {
			count = smc.update("store.updateBidCheck", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public int updateStoreState(Map<String, Object> map) {
		int count = 0;
		
		try {
			count = smc.update("store.updateStoreState", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	

}
