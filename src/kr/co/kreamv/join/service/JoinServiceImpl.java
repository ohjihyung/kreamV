package kr.co.kreamv.join.service;

import kr.co.kreamv.join.dao.IJoinDao;
import kr.co.kreamv.join.dao.JoinDaoImpl;
import kr.co.kreamv.vo.SampleMemberVO;

public class JoinServiceImpl implements IJoinService{
	private IJoinDao dao;
	private static IJoinService instance;
	
	private JoinServiceImpl() {
		dao = JoinDaoImpl.getInstance();
	}
	
	public static IJoinService getInstance() {
		if(instance == null) {
			instance =  new JoinServiceImpl();
		}
		return instance;
	}

	@Override
	public int insertMember(SampleMemberVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(vo);
	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return dao.idCheck(id);
	}
	
}
