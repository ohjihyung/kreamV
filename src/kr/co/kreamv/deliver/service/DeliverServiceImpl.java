package kr.co.kreamv.deliver.service;

import java.sql.SQLException;

import kr.co.kreamv.deliver.dao.DeliverDaoImpl;
import kr.co.kreamv.deliver.dao.IDeliverDao;

public class DeliverServiceImpl implements IDeliverService {
	private IDeliverDao dao;
	private static IDeliverService service;
	private DeliverServiceImpl() {
		dao = DeliverDaoImpl.getInstance();
	}
	public static IDeliverService getInstance() {
		if(service==null) service = new DeliverServiceImpl();
		return service;
	}
	
	@Override
	public int insertDeliver(String confirm_id) {
		return dao.insertDeliver(confirm_id);
	}



}
