package kr.co.kreamv.deliver.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.confirm.dao.ConfirmDaoImpl;
import kr.co.kreamv.confirm.dao.IconfirmDao;

public class DeliverDaoImpl implements IDeliverDao {
	private SqlMapClient smc;
	private static IDeliverDao dao;
	private DeliverDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static IDeliverDao getInstance(){
		if(dao==null) dao = new DeliverDaoImpl();
		return dao;
	}
	
	@Override
	public int insertDeliver(String confirm_id) {
		int count = 0;
		
		try {
			Object obj = smc.insert("deliver.insertDeliver", confirm_id);
			if(obj==null) count = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
