package kr.co.kreamv.examinationManager.dao;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.SelectConfirmVO;

public interface IExaminationManagerDao {
	
	// 검수중 상품 가져오기
	public List<SelectConfirmVO> prodList();
	
	// 검수완료 상품 보관하기
	public int prodStore(Map<String, Integer> map);
	
	// 검수불량 상품 반송하기
	public int prodSendBack(Map<String, Integer> map);
	
	// 보관  또는 반송후 검수상태 수정
	public int confirmUpdate(Map<String, Integer> map);
}
