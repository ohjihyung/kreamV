package kr.co.kreamv.mypage.dao;

import java.util.Map;

public interface ImypageDao {
	
	public int updatePass(Map<String, String> map);
	
	public int updateName(Map<String, String> map);
	
	public int updateHp(Map<String, String> map);
	
	public int updateSize(Map<String, String> map);
}
