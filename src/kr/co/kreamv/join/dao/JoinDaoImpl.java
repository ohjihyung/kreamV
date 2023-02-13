package kr.co.kreamv.join.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.SampleMemberVO;

public class JoinDaoImpl implements IJoinDao {
	private SqlMapClient smc;
	private static IJoinDao instance;
	
	private JoinDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IJoinDao getInstance() {
		if(instance == null) {
			instance = new JoinDaoImpl();
		}
		return instance;
	}

	@Override
	public int insertMember(SampleMemberVO vo) {
		int result = 0;
		
		try {
			result = smc.update("join.insertMember", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		return result;
	}

	@Override
	public int idCheck(String id) {
		int result = 0;
		
		try {
			result = (int)smc.queryForObject("join.idCheck", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
	
}
