package kr.co.kreamv.examinationManager.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.SelectConfirmVO;

public class ExaminationManagerDaoImpl implements IExaminationManagerDao{

	private static IExaminationManagerDao instance;
	
	private SqlMapClient smc;
	
	private ExaminationManagerDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IExaminationManagerDao getInstance() {
		if(instance == null) {
			instance = new ExaminationManagerDaoImpl();
		}
		
		return instance;
	}
	
	
	@Override
	public List<SelectConfirmVO> prodList() {
		List<SelectConfirmVO> prodList = null;
		try {
			prodList = (List<SelectConfirmVO>)smc.queryForList("ExaminationManager.prodList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prodList;
		
	}

	@Override
	public int prodStore(Map<String, Integer> map) {
		int result = 0;
		try {
			result = (int)smc.update("ExaminationManager.insertStore", map); // 보간함에 해당상품 추가
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return result;
	}

	@Override
	public int prodSendBack(Map<String, Integer> map) {
		int result = 0;
		try {
			result = (int)smc.update("ExaminationManager.insertSendBack", map); // 반송에 해당 상품 추가
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int confirmUpdate(Map<String, Integer> map) {
		int result = 0;
			try {
				result = (int)smc.update("ExaminationManager.confirmUpdate", map);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

	

	

}
