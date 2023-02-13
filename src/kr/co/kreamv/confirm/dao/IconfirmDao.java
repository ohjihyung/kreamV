package kr.co.kreamv.confirm.dao;

import kr.co.kreamv.vo.ConfirmVO;

public interface IconfirmDao {
	/**
	 * 검수신청을 완료하여 검수테이블에 새 데이터가 추가되는 메서드
	 * @param confirmVo 생성될 데이터
	 * @return 성공 : 1, 실패 : 0
	 */
	public int insertConfirm(ConfirmVO confirmVo);
}
