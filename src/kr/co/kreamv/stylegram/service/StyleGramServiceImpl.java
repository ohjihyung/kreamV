package kr.co.kreamv.stylegram.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.stylegram.dao.IStylegramDao;
import kr.co.kreamv.stylegram.dao.StyleGrameDaoImpl;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.StyleProdVO;

public class StyleGramServiceImpl implements IStylegramService {

	private static IStylegramService service;
	private IStylegramDao dao; 
	
	private StyleGramServiceImpl() {
		dao = StyleGrameDaoImpl.getInstance();
	}
	
	public static IStylegramService getInstance(){
		if(service==null) service = new StyleGramServiceImpl();
		return service;
	}
	

	
	//최신 스타일그램 리스트
	@Override
	public List<StyleProdVO> stylegramNewList() {
		return dao.stylegramNewList();
	}

	//인기 스타일그램 리스트
	@Override
	public List<StyleProdVO> stylegramHitList() {
		return dao.stylegramHitList();
	}


	//배송정보에서 구입한 상품 목록
	@Override
	public List<ProdVO> stylegramProd(String id) {
		return dao.stylegramProd(id);
	}
	
	//스타일그램 작성
	@Override
	public int stylegramInsert(Map<String, String> map) {
		return dao.stylegramInsert(map);
	}
	
	@Override
	public int updateBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	//선택한 스타일그램 상세보기
	@Override
	public List<StyleProdVO> stylegramDetail(int gramNum) {
		return dao.stylegramDetail(gramNum);
	}

	@Override
	public List<StyleProdVO> stylegramLikeList(String mem_id) {
		return dao.stylegramLikeList(mem_id);
	}

	@Override
	public int checkLikeGram(Map<String, Object> map) {
		return dao.checkLikeGram(map);
	}

	

	



}
