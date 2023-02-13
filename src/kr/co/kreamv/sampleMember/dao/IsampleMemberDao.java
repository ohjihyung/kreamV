package kr.co.kreamv.sampleMember.dao;

import java.util.Map;

import kr.co.kreamv.vo.SampleMemberVO;

public interface IsampleMemberDao {

	
	//회원 아이디 비번 확인 
		/**
		 *  login.jsp에서 입력한 id와 pass를  SampleMember객체에 넣어서  
		 *  입력한 아이디와 비밀번호가 일치하는지 확인
		 * @param vo   입력한 id 와 pass가 저장된 객체
		 * @return  1: 아이디 비번 일 치     0 : 아이디 비번 다름 
		 */
		public int configMember(SampleMemberVO vo);
		
		// 회원 아이디 찾기(리턴값 이매일정보)
		public Object idFind(Map<String, String> nameHp);
		
		// 찾은 이매일에 전송할 아이디 가져오기(리턴값 아이디정보)
		public String sendMailId(String mail);
		
		// 비밀번호 찾기(리턴값 이매일정보)
		public Object passFind(Map<String, String> passHp);
		
		// 찾은 이매일에 전송할 아이디 가져오기(리턴값 아이디정보)
		public String sendMailPass(String mail);
		
		// 회원 아이디를 받아서 그 회원의 전체 정보 출력 
		public SampleMemberVO getprofile(String memId);

		//회원 사진을 초기화 하는 메서드 
		public int deleteProfileImage(Map<String, String> map);

		// 새로운 프로필 사진을 받아서 업데이트하는 메소드
		public int updateImg(SampleMemberVO vo);
		
}
