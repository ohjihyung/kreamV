package kr.co.kreamv.vo;

public class OrdersVO {
	private String order_id;
	private String mem_id;
	private String buy_bid_id;
	private String sell_bid_id;
	private String confirm_id;
	private int order_price;
	private String order_date;
	private int order_state;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBuy_bid_id() {
		return buy_bid_id;
	}
	public void setBuy_bid_id(String buy_bid_id) {
		this.buy_bid_id = buy_bid_id;
	}
	public String getSell_bid_id() {
		return sell_bid_id;
	}
	public void setSell_bid_id(String sell_bid_id) {
		this.sell_bid_id = sell_bid_id;
	}
	public String getConfirm_id() {
		return confirm_id;
	}
	public void setConfirm_id(String confirm_id) {
		this.confirm_id = confirm_id;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	
	
}
