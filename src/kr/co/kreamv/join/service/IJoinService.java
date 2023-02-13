package kr.co.kreamv.join.service;

import kr.co.kreamv.vo.SampleMemberVO;

public interface IJoinService {

	// 회원가입
	public int insertMember(SampleMemberVO vo);
	
	// 중복검사
	public int idCheck(String id);
}
