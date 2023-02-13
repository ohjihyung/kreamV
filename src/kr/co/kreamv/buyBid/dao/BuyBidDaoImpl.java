package kr.co.kreamv.buyBid.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.proddetail.dao.IProdDetailDao;
import kr.co.kreamv.proddetail.dao.ProdDetailDaoImpl;
import kr.co.kreamv.vo.BuyBidVO;
import kr.co.kreamv.vo.SellBidVO;

public class BuyBidDaoImpl implements IBuyBidDao {
	private SqlMapClient smc;
	private static IBuyBidDao dao;
	private BuyBidDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static IBuyBidDao getInstance(){
		if(dao==null) dao = new BuyBidDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBuyBid(BuyBidVO buyBidVo) {
		int count = 0;
		
		try {
			Object obj = smc.insert("buyBid.insertBuyBid", buyBidVo);
			if(obj == null) {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public BuyBidVO minBuyBid(String detail_id) {
		BuyBidVO buyBidVo = null;
		 
		try {
			buyBidVo = (BuyBidVO)smc.queryForObject("buyBid.minBuyBid", detail_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buyBidVo;
	}
	@Override
	public int updateBuyBidState(Map<String, Object> map) {
		int count = 0;
		
		try {
			count = smc.update("buyBid.updateBuyBidState", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public String getBuyBidMemId(String buy_bid_id) {
		String mem_id = null;
		
		try {
			mem_id = (String)smc.queryForObject("buyBid.getBuyBidMemId", buy_bid_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mem_id;
	}
	@Override
	public BuyBidVO getBuyBidByOrderId(String order_id) {
		BuyBidVO buyBidVo = null;
		
		try {
			buyBidVo = (BuyBidVO)smc.queryForObject("buyBid.getBuyBidByOrderId", order_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buyBidVo;
	}

}
