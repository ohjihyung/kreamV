package kr.co.kreamv.myList.service;

import java.util.List;

import kr.co.kreamv.myList.dao.IMyListDao;
import kr.co.kreamv.myList.dao.MyListDaoImpl;
import kr.co.kreamv.vo.MyBuyVO;

public class MyListServiceImpl implements IMyListService {
	private static IMyListService service = null;
	private IMyListDao dao = null;
	private MyListServiceImpl() {
		dao = MyListDaoImpl.getInstance();
	}
	public static IMyListService getInstance() {
		if(service == null) service = new MyListServiceImpl();
		return service;
	}
	
	@Override
	public List<MyBuyVO> myBuyBidList(String mem_id) {
		return dao.myBuyBidList(mem_id);
	}
	@Override
	public List<MyBuyVO> myBuyOrderList(String mem_id) {
		return dao.myBuyOrderList(mem_id);
	}
	@Override
	public List<MyBuyVO> myBuyStayList(String mem_id) {
		return dao.myBuyStayList(mem_id);
	}
	@Override
	public List<MyBuyVO> mySellBidList(String mem_id) {
		return dao.mySellBidList(mem_id);
	}
	@Override
	public List<MyBuyVO> mySellStayList(String mem_id) {
		return dao.mySellStayList(mem_id);
	}
	@Override
	public List<MyBuyVO> mySellOrderList(String mem_id) {
		return dao.mySellOrderList(mem_id);
	}
	@Override
	public List<MyBuyVO> myConfirmList(String mem_id) {
		return dao.myConfirmList(mem_id);
	}
	@Override
	public List<MyBuyVO> myStoreList(String mem_id) {
		return dao.myStoreList(mem_id);
	}
	@Override
	public List<MyBuyVO> mySendBackList(String mem_id) {
		return dao.mySendBackList(mem_id);
	}

}
