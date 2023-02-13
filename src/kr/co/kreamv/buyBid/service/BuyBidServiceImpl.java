package kr.co.kreamv.buyBid.service;

import java.util.Map;

import kr.co.kreamv.buyBid.dao.BuyBidDaoImpl;
import kr.co.kreamv.buyBid.dao.IBuyBidDao;
import kr.co.kreamv.vo.BuyBidVO;
import kr.co.kreamv.vo.SellBidVO;

public class BuyBidServiceImpl implements IBuyBidService {
	private IBuyBidDao dao;
	private static IBuyBidService service;
	private BuyBidServiceImpl() {
		dao = BuyBidDaoImpl.getInstance();
	}
	public static IBuyBidService getInstance() {
		if(service==null) service = new BuyBidServiceImpl();
		return service;
	}
	
	@Override
	public BuyBidVO minBuyBid(String detail_id) {
		return dao.minBuyBid(detail_id);
	}
	
	@Override
	public int insertBuyBid(BuyBidVO buyBidVo) {
		return dao.insertBuyBid(buyBidVo);
	}
	@Override
	public int updateBuyBidState(Map<String, Object> map) {
		return dao.updateBuyBidState(map);
	}
	@Override
	public String getBuyBidMemId(String buy_bid_id) {
		return dao.getBuyBidMemId(buy_bid_id);
	}
	@Override
	public BuyBidVO getBuyBidByOrderId(String order_id) {
		return dao.getBuyBidByOrderId(order_id);
	}

}
