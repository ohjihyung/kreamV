package kr.co.kreamv.sellBid.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.SellBidVO;

public class SellBidDaoImpl implements ISellBidDao {
	private SqlMapClient smc;
	private static ISellBidDao dao;
	private SellBidDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static ISellBidDao getInstance() {
		if(dao==null) dao = new SellBidDaoImpl();
		return dao;
	}

	@Override
	public SellBidVO minSellBid(String detail_id) {
		SellBidVO sellBidVo = null;
		 
		try {
			sellBidVo = (SellBidVO)smc.queryForObject("sellBid.minSellBid", detail_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sellBidVo;
	}

	@Override
	public SellBidVO sellBidInfo(String sell_bid_id) {
		SellBidVO sellBidVo = null;
		
		try {
			sellBidVo = (SellBidVO) smc.queryForObject("sellBid.sellBidInfo", sell_bid_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sellBidVo;
	}
	@Override
	public int insertSellBid(SellBidVO sellBidVo) {
		int count = 0;
		
		try {
			Object obj = smc.insert("sellBid.insertSellBid", sellBidVo);
			if(obj == null) {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public String getConfirmId(String sell_bid_id) {
		String confirm_id = null;
		
		try {
			confirm_id = (String)smc.queryForObject("sellBid.getConfirmId", sell_bid_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return confirm_id;
	}
	@Override
	public int updateSellBidState(Map<String, String> map) {
		int count = 0;
		
		try {
			count = smc.update("sellBid.updateSellBidState", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public SellBidVO getSellBid(String confirm_id) {
		SellBidVO sellBidVo = null;
		
		try {
			sellBidVo = (SellBidVO) smc.queryForObject("sellBid.getSellBid", confirm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sellBidVo;
	}
	@Override
	public int changeSellBid(Map<String, Object> map) {
		int count = 0;
		
		try {
			count = smc.update("sellBid.changeSellBid", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public int deleteSellBid(String confirm_id) {
		int count = 0;
		
		try {
			count = smc.delete("sellBid.deleteSellBid", confirm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
