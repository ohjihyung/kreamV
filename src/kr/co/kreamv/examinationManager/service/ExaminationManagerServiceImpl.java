package kr.co.kreamv.examinationManager.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.examinationManager.dao.ExaminationManagerDaoImpl;
import kr.co.kreamv.examinationManager.dao.IExaminationManagerDao;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.SelectConfirmVO;

public class ExaminationManagerServiceImpl implements IExaminationManagerService{
	
	private static IExaminationManagerService instance;
	
	private IExaminationManagerDao dao; 
	
	private ExaminationManagerServiceImpl() {
		dao = ExaminationManagerDaoImpl.getInstance();
	}
	
	public static IExaminationManagerService getinstance() {
		if(instance == null) {
			instance = new ExaminationManagerServiceImpl();
		}
		return instance;
	}
	
	@Override
	public List<SelectConfirmVO> prodList() {
		// TODO Auto-generated method stub
		return dao.prodList();
	}

	@Override
	public int prodStore(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.prodStore(map);
	}

	@Override
	public int prodSendBack(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.prodSendBack(map);
	}

	@Override
	public int confirmUpdate(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.confirmUpdate(map);
	}

	



}
