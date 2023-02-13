package kr.co.kreamv.join.dao;

import kr.co.kreamv.vo.SampleMemberVO;

public interface IJoinDao {
	
	// 회원가입
	public int insertMember(SampleMemberVO vo);
		
	// 중복검사
	public int idCheck(String id);
	
}
