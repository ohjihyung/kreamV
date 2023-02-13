package kr.co.kreamv.prod.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.vo.ProdVO;

public interface IprodService {
	
		//�쟾泥� �긽�뭹 議고쉶 
		public List<ProdVO> allProdList();
	
		//釉뚮옖�뱶蹂꾨줈 �긽�뭹 議고쉶
		public List<ProdVO> brandProdList(String brand_nm);
	
		// �씤湲곗긽�뭹�쑝濡� 議고쉶 (李� 媛��닔 留롮�嫄� ~~)
		public List<ProdVO> popularProdList();
	
		// 理쒓렐 �떆�꽭 �궙�븘吏� �긽�뭹 議고쉶 
		public List<ProdVO> mkpriceDownProdList();

		// �궓�옄 異붿쿇 �긽�뭹 由ъ뒪�듃 議고쉶
		public List<ProdVO> menRecommendList();

		// �뿬�옄 異붿쿇 �긽�뭹 由ъ뒪�듃 議고쉶
		public List<ProdVO> womenRecommendList();
		
		// �궙�� 媛�寃� �닚 �긽�뭹 由ъ뒪�듃 議고쉶
		public List<ProdVO> lowPriceList();
		
		// �넂�� 媛�寃� �닚 由ъ뒪�듃 議고쉶
		public List<ProdVO> highPriceList();
		
		//愿�由ъ옄媛� �긽�뭹 �벑濡�
		public int insertProd(ProdVO vo);
		
		// 寃��깋�뼱�씠由꾩쓣 媛��졇���꽌  愿��젴�긽�뭹�쓣 戮묒븘�삤�뒗 硫붿꽌�뱶 
		
	
		// �긽�뭹 �젙蹂� 媛��졇�삤湲�
		public ProdVO getProd(String prodId);
		
		//諛쒕ℓ�맂 �긽�뭹 由ъ뒪�듃 議고쉶
		public List<ProdVO> getProdList();
		
		//�깉濡� �벑濡앸맂 �긽�뭹 由ъ뒪�듃 議고쉶
		public List<ProdVO> newProdList();

		public List<ProdVO> searchProdList(String search);
		
		//愿�由ъ옄媛� �긽�뭹 �닔�젙
		public int prodUpdate(Map<String, String> map);
		
		// 愿�由ъ옄媛� �긽�뭹 �궘�젣
		public int prodDelete(String prodId);

		/**
		 * prod�뿉 理쒓렐 嫄곕옒媛�瑜� 蹂�寃쏀븯�뒗 硫붿꽌�뱶
		 * @param map prod_id, 理쒓렐嫄곕옒媛�
		 * @return 蹂�寃� 媛쒖닔
		 */
		public int updateMKPrice(Map<String, Object> map);
}
