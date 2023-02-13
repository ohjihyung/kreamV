package kr.co.kreamv.sampleMember.service;

import java.util.Map;

import kr.co.kreamv.sampleMember.dao.IsampleMemberDao;
import kr.co.kreamv.sampleMember.dao.SampleMemberDaoImpl;
import kr.co.kreamv.vo.SampleMemberVO;


public class SampleMemberServiceImpl implements IsampleMemberService {

	private static IsampleMemberService service = null;
	private IsampleMemberDao dao = null;
	
	private  SampleMemberServiceImpl() {
		dao = SampleMemberDaoImpl.getInstance();
	}
	
	public static IsampleMemberService getInstance() {
		if(service == null) {
			service = new SampleMemberServiceImpl();
		}
		return service;
	}
	
	
	@Override
	public int configMember(SampleMemberVO vo) {
		// TODO Auto-generated method stub
		return dao.configMember(vo);
	}
	
	@Override
	public Object idFind(Map<String, String> nameHp) {
		
		return dao.idFind(nameHp);
	}

	@Override
	public String sendMailId(String mail) {
		// TODO Auto-generated method stub
		return dao.sendMailId(mail);
	}

	@Override
	public Object passFind(Map<String, String> passHp) {
		// TODO Auto-generated method stub
		return dao.passFind(passHp);
	}

	@Override
	public String sendMailPass(String mail) {
		// TODO Auto-generated method stub
		return dao.sendMailPass(mail);
	}

	@Override
	public SampleMemberVO getprofile(String memId) {
		// TODO Auto-generated method stub
		return dao.getprofile(memId);
	}


	@Override
	public int deleteProfileImage(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.deleteProfileImage(map);
	}

	@Override
	public int updateImg(SampleMemberVO vo) {
		// TODO Auto-generated method stub
		return dao.updateImg(vo);
	}

}
