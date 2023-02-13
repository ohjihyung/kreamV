package kr.co.kreamv.confirm.service;

import kr.co.kreamv.confirm.dao.ConfirmDaoImpl;
import kr.co.kreamv.confirm.dao.IconfirmDao;
import kr.co.kreamv.vo.ConfirmVO;

public class ConfirmServiceImpl implements IconfirmService {
	private IconfirmDao dao;
	private static IconfirmService service;
	private ConfirmServiceImpl() {
		dao = ConfirmDaoImpl.getInstance();
	}
	public static IconfirmService getInstance() {
		if(service==null) service = new ConfirmServiceImpl();
		return service;
	}
	
	@Override
	public int insertConfirm(ConfirmVO confirmVo) {
		return dao.insertConfirm(confirmVo);
	}

}
