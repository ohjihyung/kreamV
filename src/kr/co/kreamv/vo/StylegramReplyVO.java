package kr.co.kreamv.vo;

public class StylegramReplyVO {
	private int greply_num;
	private String mem_id;
	private String greply_cont;
	private int gram_num;
	
	public String getMem_photo() {
		return mem_photo;
	}
	public void setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
	}
	//회원정보
	private String mem_photo;
	
	public int getGreply_num() {
		return greply_num;
	}
	public void setGreply_num(int greply_num) {
		this.greply_num = greply_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getGreply_cont() {
		return greply_cont;
	}
	public void setGreply_cont(String greply_cont) {
		this.greply_cont = greply_cont;
	}
	public int getGram_num() {
		return gram_num;
	}
	public void setGram_num(int gram_num) {
		this.gram_num = gram_num;
	}
	
}
