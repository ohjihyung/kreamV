package kr.co.kreamv.proddetail.dao;

import java.util.List;

import kr.co.kreamv.vo.ProdDetailVO;

public interface IProdDetailDao {
	
	/**
	 * 원하는 모델번호의 상세 내용을 가져오는 메서드
	 * @param prodId 원하는 모델번호(상품번호)
	 * @return ProdDetailVO리스트를 반환
	 */
	public List<ProdDetailVO> prodDetailList(String prodId);
	
	public ProdDetailVO GetProdDetail(String detailId);
	
	public String getProdId(String detailId);
}
