package kr.co.kreamv.wish.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.WishVO;
import kr.co.kreamv.wish.dao.IWishDao;
import kr.co.kreamv.wish.dao.WishDaoImpl;

public class WishServiceImpl implements IWishService {

	private static IWishService service;
	private IWishDao dao;
	
	private WishServiceImpl() {
		dao = WishDaoImpl.getInstance();
	}
	public static IWishService getInstance(){
		if(service==null) service = new WishServiceImpl();
		return service;
	}

	@Override
	public int wishProd(WishVO WishVO) {
		return dao.wishProd(WishVO);
	}


	@Override
	public int insertWish(WishVO wishVo) {
		return dao.insertWish(wishVo);
	}
	@Override
	public int checkWish(WishVO wishVo) {
		return dao.checkWish(wishVo);
	}
	@Override
	public int wishCancelProd(WishVO wishVo) {
		return dao.wishCancelProd(wishVo);
	}
	@Override
	public int countWish(String prod_id) {
		return dao.countWish(prod_id);
	}
	@Override
	public List<ProdVO> wishList(String mem_id) {
		return dao.wishList(mem_id);
	}
	
	
}
