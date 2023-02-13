package kr.co.kreamv.mypage.service;

import java.util.Map;

import kr.co.kreamv.mypage.dao.ImypageDao;
import kr.co.kreamv.mypage.dao.myPageDaoImpl;


public class mypageServiceImpl implements ImypageService{
	
	private static ImypageService service = null;
	private ImypageDao dao = null;

	private mypageServiceImpl() {
		dao = myPageDaoImpl.getInstance();
	}
	
	public static ImypageService getInstance() {
		if(service == null) service = new mypageServiceImpl();
		
		return service;
	}

	@Override
	public int updateName(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.updateName(map);
	}

	@Override
	public int updatePass(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.updatePass(map);
	}

	@Override
	public int updateHp(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.updateHp(map);
	}

	@Override
	public int updateSize(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.updateSize(map);
	}

	


}
