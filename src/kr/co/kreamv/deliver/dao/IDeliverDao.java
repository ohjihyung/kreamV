package kr.co.kreamv.deliver.dao;

public interface IDeliverDao {
	/**
	 * 검수 번호를 이용하여 새 배송 정보를 입력하는 메서드
	 * @param confirm_id 검수 번호
	 * @return 작업 성공 : 1
	 */
	public int insertDeliver(String confirm_id);
}
