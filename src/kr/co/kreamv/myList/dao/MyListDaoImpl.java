package kr.co.kreamv.myList.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.prod.dao.IprodDao;
import kr.co.kreamv.prod.dao.ProdDaoImpl;
import kr.co.kreamv.vo.MyBuyVO;

public class MyListDaoImpl implements IMyListDao {
	private SqlMapClient smc = null;
	private static IMyListDao dao;
	private  MyListDaoImpl() {
		smc  = SqlMapClientFactory.getSqlMapClient();
	}
	public static IMyListDao getInstance() {
		if(dao == null) dao = new MyListDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<MyBuyVO> myBuyBidList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.myBuyBidList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> myBuyOrderList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.myBuyOrderList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> myBuyStayList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.myBuyStayList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> mySellBidList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.mySellBidList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> mySellStayList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.mySellStayList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> mySellOrderList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.mySellOrderList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> myConfirmList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.myConfirmList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> myStoreList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.myStoreList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}
	@Override
	public List<MyBuyVO> mySendBackList(String mem_id) {
		List<MyBuyVO> myBuyList = null;
		
		try {
			myBuyList = smc.queryForList("myList.mySendBackList", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myBuyList;
	}

}
