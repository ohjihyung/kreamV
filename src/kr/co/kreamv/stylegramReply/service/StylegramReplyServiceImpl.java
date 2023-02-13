package kr.co.kreamv.stylegramReply.service;

import java.util.List;
import java.util.Map;

import kr.co.kreamv.stylegramReply.dao.IStylegramReplyDao;
import kr.co.kreamv.stylegramReply.dao.StylegramReplyDaoImpl;
import kr.co.kreamv.vo.StylegramReplyVO;

public class StylegramReplyServiceImpl implements IStylegramReplyService {

	
	private static IStylegramReplyService service;
	private IStylegramReplyDao dao; 
	
	private StylegramReplyServiceImpl() {
		dao = StylegramReplyDaoImpl.getInstance();
	}
	
	public static IStylegramReplyService getInstance(){
		if(service==null) service = new StylegramReplyServiceImpl();
		return service;
	}
	
	//해당게시물의 댓글리스트 출력
	@Override
	public List<StylegramReplyVO> gramReplyList(int gramNum) {
		return dao.gramReplyList(gramNum);
	}
	
	//댓글insert
	@Override
	public int insertBoardReply(Map<String, Object> map) {
		return dao.insertBoardReply(map);
	}

	@Override
	public int updateBoardReply() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardReply() {
		// TODO Auto-generated method stub
		return 0;
	}

}
