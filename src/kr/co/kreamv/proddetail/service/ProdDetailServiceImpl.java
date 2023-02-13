package kr.co.kreamv.proddetail.service;

import java.util.List;

import kr.co.kreamv.proddetail.dao.IProdDetailDao;
import kr.co.kreamv.proddetail.dao.ProdDetailDaoImpl;
import kr.co.kreamv.vo.ProdDetailVO;

public class ProdDetailServiceImpl implements IProdDetailService {
	private IProdDetailDao dao;
	private static IProdDetailService service;
	private ProdDetailServiceImpl() {
		dao = ProdDetailDaoImpl.getInstance();
	}
	public static IProdDetailService getInstance() {
		if(service==null) service = new ProdDetailServiceImpl();
		return service;
	}
	
	@Override
	public List<ProdDetailVO> prodDetailList(String prodId) {
		return dao.prodDetailList(prodId);
	}
	@Override
	public ProdDetailVO GetProdDetail(String detailId) {
		return dao.GetProdDetail(detailId);
	}
	@Override
	public String getProdId(String detailId) {
		return dao.getProdId(detailId);
	}

}
