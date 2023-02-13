package kr.co.kreamv.prod.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.ProdVO;

public class ProdDaoImpl implements IprodDao{

	private SqlMapClient smc = null;
	private static IprodDao dao;
	private  ProdDaoImpl() {
		smc  = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IprodDao getInstance() {
		if(dao == null) dao = new ProdDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<ProdVO> allProdList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.allProdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public List<ProdVO> brandProdList(String brand_nm) {
		List<ProdVO> brandProdList = null;
		try {
			brandProdList = smc.queryForList("prod.brandProdList", brand_nm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return brandProdList;
	}

	@Override
	public List<ProdVO> popularProdList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.popularProdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public List<ProdVO> mkpriceDownProdList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertProd(ProdVO vo) {
		
		int result = 0;
		try {
			result =  smc.update("prod.insertProd", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}



	@Override
	public ProdVO getProd(String prodId) {

		ProdVO prodVo = null;
		
		try {
			prodVo = (ProdVO)smc.queryForObject("prod.getProd", prodId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodVo;
	}

	@Override
	public List<ProdVO> getProdList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.getProdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public List<ProdVO> newProdList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.newProdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public List<ProdVO> menRecommendList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.menRecommendList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodList;
	}

	@Override
	public List<ProdVO> womenRecommendList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.womenRecommendList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public int prodUpdate(Map<String, String> map) {
		int result = 0;
		try {
			result = smc.update("prod.prodUpdate", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int prodDelete(String prodId) {
		int result = 0;
		
		try {
			result = smc.update("prod.prodDelete", prodId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<ProdVO> lowPriceList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.lowPriceList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public List<ProdVO> searchProdList(String search) {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.searchProdList",search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}
	
	

	@Override
	public List<ProdVO> highPriceList() {
		List<ProdVO> prodList = null;
		try {
			prodList = smc.queryForList("prod.highPriceList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}


	@Override
	public int updateMKPrice(Map<String, Object> map) {
		int count=0;
		
		try {
			count = smc.update("prod.updateMKPrice", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}



}
