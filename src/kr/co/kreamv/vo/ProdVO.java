package kr.co.kreamv.vo;

public class ProdVO {
		private String prod_id;      //상품번호(모델번호)
		private String pcategory_id; // 상품카테고리번호
		private String prod_brand;   // 브랜드명
		private String prod_enm;	 // 영어상품명
		private String prod_knm;	// 한글상품명
		private int prod_wish_cnt;	// 찜갯수
		private int prod_mkprice;  // 최근 시세
		private String prod_date;   // 상품 출시일 
		private int prod_rprice;    // 발매가
		private String prod_rdate;   //관리자 등록일
		private int prod_gen;		// 성별 (상품의 성별, 남자꺼냐.. 여자꺼냐)
		private String prod_photo1;   // 상품사진
		private String prod_photo2;   // 상품사진

		private String prod_origin1;	  // 상품1원본
		private String prod_origin2;
		public String getProd_id() {
			return prod_id;
		}
		public void setProd_id(String prod_id) {
			this.prod_id = prod_id;
		}
		public String getPcategory_id() {
			return pcategory_id;
		}
		public void setPcategory_id(String pcategory_id) {
			this.pcategory_id = pcategory_id;
		}
		public String getProd_brand() {
			return prod_brand;
		}
		public void setProd_brand(String prod_brand) {
			this.prod_brand = prod_brand;
		}
		public String getProd_enm() {
			return prod_enm;
		}
		public void setProd_enm(String prod_enm) {
			this.prod_enm = prod_enm;
		}
		public String getProd_knm() {
			return prod_knm;
		}
		public void setProd_knm(String prod_knm) {
			this.prod_knm = prod_knm;
		}
		public int getProd_wish_cnt() {
			return prod_wish_cnt;
		}
		public void setProd_wish_cnt(int prod_wish_cnt) {
			this.prod_wish_cnt = prod_wish_cnt;
		}
		public int getProd_mkprice() {
			return prod_mkprice;
		}
		public void setProd_mkprice(int prod_mkprice) {
			this.prod_mkprice = prod_mkprice;
		}
		public String getProd_date() {
			return prod_date;
		}
		public void setProd_date(String prod_date) {
			this.prod_date = prod_date;
		}
		public int getProd_rprice() {
			return prod_rprice;
		}
		public void setProd_rprice(int prod_rprice) {
			this.prod_rprice = prod_rprice;
		}
		public String getProd_rdate() {
			return prod_rdate;
		}
		public void setProd_rdate(String prod_rdate) {
			this.prod_rdate = prod_rdate;
		}
		public int getProd_gen() {
			return prod_gen;
		}
		public void setProd_gen(int prod_gen) {
			this.prod_gen = prod_gen;
		}
		public String getProd_photo1() {
			return prod_photo1;
		}
		public void setProd_photo1(String prod_photo1) {
			this.prod_photo1 = prod_photo1;
		}
		public String getProd_photo2() {
			return prod_photo2;
		}
		public void setProd_photo2(String prod_photo2) {
			this.prod_photo2 = prod_photo2;
		}
		public String getProd_origin1() {
			return prod_origin1;
		}
		public void setProd_origin1(String prod_origin1) {
			this.prod_origin1 = prod_origin1;
		}
		public String getProd_origin2() {
			return prod_origin2;
		}
		public void setProd_origin2(String prod_origin2) {
			this.prod_origin2 = prod_origin2;
		}	  // 상품2원본
}	
