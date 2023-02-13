package kr.co.kreamv.proddetail.service;

import java.util.List;

import kr.co.kreamv.vo.ProdDetailVO;

public interface IProdDetailService {
	public List<ProdDetailVO> prodDetailList(String prodId);
	
	public ProdDetailVO GetProdDetail(String detailId);
	
	public String getProdId(String detailId);

}
