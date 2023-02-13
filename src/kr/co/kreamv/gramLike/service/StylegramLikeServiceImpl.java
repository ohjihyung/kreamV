package kr.co.kreamv.gramLike.service;

import java.util.List;

import kr.co.kreamv.gramLike.dao.IStylegramLikeDao;
import kr.co.kreamv.gramLike.dao.StylegramLikeDaoImpl;
import kr.co.kreamv.vo.LikegramVO;

public class StylegramLikeServiceImpl implements IStylegramLikeService {

	private static IStylegramLikeService service;
	private IStylegramLikeDao dao;

	private StylegramLikeServiceImpl() {
		dao = StylegramLikeDaoImpl.getInstance();
	}
	
	public static IStylegramLikeService getInstance(){
		if(service==null) service = new StylegramLikeServiceImpl();
		return service;
	}
	
	//좋아요 insert
	@Override
	public int likeGram(LikegramVO vo) {
		return dao.likeGram(vo);
	}

	
	//좋아요list
	@Override
	public List<LikegramVO> likeGramList(String memId) {
		return dao.likeGramList(memId);
	}

	@Override
	public int getLikeCount(int gramNum) {
		// TODO Auto-generated method stub
		return dao.getLikeCount(gramNum);
	}

	@Override
	public int minuLike(LikegramVO vo) {
		// TODO Auto-generated method stub
		return dao.minuLike(vo);
	}



}
