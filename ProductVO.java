package myshop.model;

public class ProductVO {
   
   private int pdno;            // 제품 번호
   private String pdname;         // 제품명
   private String pdcategory_fk;   // 카테고리코드
   private String pdimage1;      // 제품이미지1
   private String pdimage2;      // 제품이미지2
   private int pdqty;            // 제품 재고량
   private int price;            // 제품 정가
   private int saleprice;         // 제품 할인가
   private String pdcontent;      // 제품 설명
   private int point;            // 포인트 점수   
   private String pdinputdate;      // 제품 등록일자
   private String texture;         // 제품 소재
   private String pdgender;      // 성별
   
   public ProductVO(){ }         // 기본 생성자

   public ProductVO(int pdno, String pdname, String pdcategory_fk, String pdimage1, String pdimage2, int pdqty,
         int price, int saleprice, String pdcontent, int point, String pdinputdate, String texture,
         String pdgender) {
	      super();
	      this.pdno = pdno;
	      this.pdname = pdname;
	      this.pdcategory_fk = pdcategory_fk;
	      this.pdimage1 = pdimage1;
	      this.pdimage2 = pdimage2;
	      this.pdqty = pdqty;
	      this.price = price;
	      this.saleprice = saleprice;
	      this.pdcontent = pdcontent;
	      this.point = point;
	      this.pdinputdate = pdinputdate;
	      this.texture = texture;
	      this.pdgender = pdgender;
   }

   public int getPdno() {
      return pdno;
   }

   public void setPdno(int pdno) {
      this.pdno = pdno;
   }

   public String getPdname() {
      return pdname;
   }

   public void setPdname(String pdname) {
      this.pdname = pdname;
   }

   public String getPdcategory_fk() {
      return pdcategory_fk;
   }

   public void setPdcategory_fk(String pdcategory_fk) {
      this.pdcategory_fk = pdcategory_fk;
   }

   public String getPdimage1() {
      return pdimage1;
   }

   public void setPdimage1(String pdimage1) {
      this.pdimage1 = pdimage1;
   }

   public String getPdimage2() {
      return pdimage2;
   }

   public void setPdimage2(String pdimage2) {
      this.pdimage2 = pdimage2;
   }

   public int getPdqty() {
      return pdqty;
   }

   public void setPdqty(int pdqty) {
      this.pdqty = pdqty;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getSaleprice() {
      return saleprice;
   }

   public void setSaleprice(int saleprice) {
      this.saleprice = saleprice;
   }

   public String getPdcontent() {
      return pdcontent;
   }

   public void setPdcontent(String pdcontent) {
      this.pdcontent = pdcontent;
   }

   public int getPoint() {
      return point;
   }

   public void setPoint(int point) {
      this.point = point;
   }

   public String getPdinputdate() {
      return pdinputdate;
   }

   public void setPdinputdate(String pdinputdate) {
      this.pdinputdate = pdinputdate;
   }

   public String getTexture() {
      return texture;
   }

   public void setTexture(String texture) {
      this.texture = texture;
   }

   public String getPdgender() {
      return pdgender;
   }

   public void setPdgender(String pdgender) {
      this.pdgender = pdgender;
   };      

}