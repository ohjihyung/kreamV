package kr.co.kreamv.mypage.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;


public class myPageDaoImpl implements ImypageDao{

	private static ImypageDao dao = null;
	private SqlMapClient smc = null;
	
	private myPageDaoImpl() {
		// TODO Auto-generated constructor stub
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ImypageDao getInstance() {
		if(dao == null) dao = new myPageDaoImpl();
		
		return dao;
	}

	@Override
	public int updateName(Map<String, String> map) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = smc.update("mypageUpdate.updateName", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int updatePass(Map<String, String> map) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = smc.update("mypageUpdate.updatePass", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateHp(Map<String, String> map) {
		int result = 0;
		try {
			result = smc.update("mypageUpdate.updateHp", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateSize(Map<String, String> map) {
		int result = 0;
		try {
			result = smc.update("mypageUpdate.updateSize", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	

}
