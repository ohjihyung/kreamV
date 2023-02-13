package kr.co.kreamv.proddetail.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.ProdDetailVO;

public class ProdDetailDaoImpl implements IProdDetailDao {

	private SqlMapClient smc;
	private static IProdDetailDao dao;
	private ProdDetailDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static IProdDetailDao getInstance(){
		if(dao==null) dao = new ProdDetailDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProdDetailVO> prodDetailList(String prodId) {
		List<ProdDetailVO> prodDetailList = null;
		
		try {
			prodDetailList = smc.queryForList("prodDetail.prodDetailList", prodId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodDetailList;
	}
	@Override
	public ProdDetailVO GetProdDetail(String detailId) {
		ProdDetailVO prodDetailVo = null;
		
		try {
			prodDetailVo = (ProdDetailVO)smc.queryForObject("prodDetail.GetProdDetail", detailId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodDetailVo;
	}
	@Override
	public String getProdId(String detailId) {
		String prodId = null;
		
		try {
			prodId = (String)smc.queryForObject("prodDetail.getProdId", detailId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodId;
	}

}
