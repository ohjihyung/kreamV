package kr.co.kreamv.sampleMember.dao;


import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.co.kreamv.config.SqlMapClientFactory;
import kr.co.kreamv.vo.SampleMemberVO;

public class SampleMemberDaoImpl implements IsampleMemberDao {
	
	private SqlMapClient smc = null;
	private static IsampleMemberDao dao;
	
	private SampleMemberDaoImpl() {
		smc  = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IsampleMemberDao getInstance() {
		if(dao == null) dao = new SampleMemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public int configMember(SampleMemberVO vo) {
		
		int res = 0;
		try {
			res = (int)smc.queryForObject("login.config",vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res ;
	}

	@Override
	public Object idFind(Map<String, String> nameHp) {
		Object mail = null;
		
		try {
			mail = smc.queryForObject("login.idFind", nameHp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mail;
	}

	@Override
	public String sendMailId(String mail) {
		String id = null;
		
		try {
			id = (String)smc.queryForObject("login.sendMailId", mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public Object passFind(Map<String, String> passHp) {
		Object mail = null;
		
		try {
			mail = smc.queryForObject("login.passFind", passHp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mail;
	}

	@Override
	public String sendMailPass(String mail) {
		String pass = null;
		
		try {
			pass = (String)smc.queryForObject("login.sendMailPass", mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pass;
	}

	@Override
	public SampleMemberVO getprofile(String mem_id) {
		// TODO Auto-generated method stub
		SampleMemberVO vo = null;
		
		try {
			vo = (SampleMemberVO)smc.queryForObject("login.getprofile",mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int deleteProfileImage(Map<String, String> map) {
		int res = 0;
		
		 try {
			res = (int)smc.update("mypageUpdate.deleteImg", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}


	@Override
	public int updateImg(SampleMemberVO vo) {
		int result = 0;
		System.out.println("다오");
		System.out.println(vo.getMem_id());
		System.out.println(vo.getMem_photo());
		try {
			result = smc.update("mypageUpdate.updateImg", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}
