package kr.co.kreamv.sellBid.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.sellBid.dao.ISellBidDao;
import kr.co.kreamv.sellBid.dao.SellBidDaoImpl;
import kr.co.kreamv.vo.SellBidVO;

public class SellBidServiceImpl implements ISellBidService {
	private ISellBidDao dao;
	private static ISellBidService service;
	private SellBidServiceImpl() {
		dao = SellBidDaoImpl.getInstance();
	}
	public static ISellBidService getInstance() {
		if(service==null) service = new SellBidServiceImpl();
		return service;
	}
	
	@Override
	public SellBidVO minSellBid(String detail_id) {
		return dao.minSellBid(detail_id);
	}

	@Override
	public SellBidVO sellBidInfo(String sell_bid_id) {
		return dao.sellBidInfo(sell_bid_id);
	}
	@Override
	public int insertSellBid(SellBidVO sellBidVo) {
		return dao.insertSellBid(sellBidVo);
	}
	@Override
	public String getConfirmId(String sell_bid_id) {
		return dao.getConfirmId(sell_bid_id);
	}
	@Override
	public int updateSellBidState(Map<String, String> map) {
		return dao.updateSellBidState(map);
	}
	@Override
	public SellBidVO getSellBid(String confirm_id) {
		return dao.getSellBid(confirm_id);
	}
	@Override
	public int changeSellBid(Map<String, Object> map) {
		return dao.changeSellBid(map);
	}
	@Override
	public int deleteSellBid(String confirm_id) {
		return dao.deleteSellBid(confirm_id);
	}

}
