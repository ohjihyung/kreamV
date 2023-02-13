package kr.co.kreamv.confirm.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.buyBid.dao.BuyBidDaoImpl;
import kr.co.kreamv.buyBid.dao.IBuyBidDao;
import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.ConfirmVO;

public class ConfirmDaoImpl implements IconfirmDao {
	private SqlMapClient smc;
	private static IconfirmDao dao;
	private ConfirmDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static IconfirmDao getInstance(){
		if(dao==null) dao = new ConfirmDaoImpl();
		return dao;
	}
	
	@Override
	public int insertConfirm(ConfirmVO confirmVo) {
		int count=0;
		
		try {
			Object obj = smc.insert("confirm.insertConfirm", confirmVo);
			if(obj==null) count = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
