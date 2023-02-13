package kr.co.kreamv.prod.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.prod.dao.IprodDao;
import kr.co.kreamv.prod.dao.ProdDaoImpl;
import kr.co.kreamv.vo.ProdVO;

public class ProdServiceImpl implements IprodService {

	private static IprodService service = null;
	private IprodDao dao = null;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IprodService getInstance() {
		if(service == null) {
			service = new ProdServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<ProdVO> allProdList() {
		// TODO Auto-generated method stub
		return dao.allProdList();
	}

	@Override
	public List<ProdVO> brandProdList(String brand_nm) {
		// TODO Auto-generated method stub
		return dao.brandProdList(brand_nm);
	}

	@Override
	public List<ProdVO> popularProdList() {
		// TODO Auto-generated method stub
		return dao.popularProdList();
	}

	@Override
	public List<ProdVO> mkpriceDownProdList() {
		// TODO Auto-generated method stub
		return dao.mkpriceDownProdList();
	}

	@Override
	public int insertProd(ProdVO vo) {
		// TODO Auto-generated method stub
		return dao.insertProd(vo);
	}

	@Override

	public ProdVO getProd(String prodId) {
		return dao.getProd(prodId);

	}
	
	@Override
	public List<ProdVO> getProdList() {
		return dao.getProdList();
	}

	@Override
	public List<ProdVO> newProdList() {
		return dao.newProdList();
	}

	@Override
	public List<ProdVO> menRecommendList() {
		return dao.menRecommendList();
	}

	@Override
	public List<ProdVO> womenRecommendList() {
		// TODO Auto-generated method stub
		return dao.womenRecommendList();
	}

	@Override
	public int prodUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.prodUpdate(map);
	}

	@Override
	public int prodDelete(String prodId) {
		// TODO Auto-generated method stub
		return dao.prodDelete(prodId);
	}

	@Override
	public List<ProdVO> lowPriceList() {
		// TODO Auto-generated method stub
		return dao.lowPriceList();
	}

	@Override
	public List<ProdVO> searchProdList(String search) {
		// TODO Auto-generated method stub
		return dao.searchProdList(search);
	}

	@Override
	public List<ProdVO> highPriceList() {
		// TODO Auto-generated method stub
		return dao.highPriceList();
	}

	@Override
	public int updateMKPrice(Map<String, Object> map) {
		return dao.updateMKPrice(map);
	}
	
	


}
