package kr.co.kreamv.mypage.service;

import java.util.Map;

public interface ImypageService {
	public int updateName(Map<String, String> map);

	public int updatePass(Map<String, String> map);
	
	public int updateHp(Map<String, String> map);
	
	public int updateSize(Map<String, String> map);
}
