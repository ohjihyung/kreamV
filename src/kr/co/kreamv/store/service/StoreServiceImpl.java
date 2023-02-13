package kr.co.kreamv.store.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.store.dao.IStoreDao;
import kr.co.kreamv.store.dao.StoreDaoImpl;
import kr.co.kreamv.vo.SellableVO;

public class StoreServiceImpl implements IStoreService {
	private static IStoreService service = null;
	private IStoreDao dao = null;
	private StoreServiceImpl() {
		dao = StoreDaoImpl.getInstance();
	}
	public static IStoreService getInstance() {
		if(service == null) service = new StoreServiceImpl();
		return service;
	}
	
	@Override
	public int checkStore(String mem_id) {
		return dao.checkStore(mem_id);
	}
	@Override
	public List<SellableVO> getSellableStore(Map<String, Object> map) {
		return dao.getSellableStore(map);
	}
	@Override
	public int updateBidCheck(Map<String, Object> map) {
		return dao.updateBidCheck(map);
	}
	@Override
	public int updateStoreState(Map<String, Object> map) {
		return dao.updateStoreState(map);
	}

}
