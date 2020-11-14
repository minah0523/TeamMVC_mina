/*
 * package myshop.model;
 * 
 * import java.sql.*; import java.util.*;
 * 
 * import javax.naming.Context; import javax.naming.InitialContext; import
 * javax.naming.NamingException; import javax.sql.DataSource;
 * 
 * public class ProductDAO원본 implements InterProductDAO {
 * 
 * private DataSource ds; // DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection
 * Pool) 이다. private Connection conn; private PreparedStatement pstmt; private
 * ResultSet rs;
 * 
 * // 기본 생성자 public ProductDAO원본() { try { Context initContext = new
 * InitialContext(); Context envContext =
 * (Context)initContext.lookup("java:/comp/env"); ds =
 * (DataSource)envContext.lookup("jdbc/teammvc_oracle"); // 이름(web.xml에
 * res-ref-name에 해당하는 것) } catch(NamingException e) { e.printStackTrace(); } }
 * 
 * // 사용한 자원을 반납하는 close() 매소드 생성하기 private void close() { try { if(rs != null)
 * { rs.close(); rs=null; } if(pstmt != null) { pstmt.close(); pstmt=null; }
 * if(conn != null) { conn.close(); conn=null; } } catch(SQLException e) {
 * e.printStackTrace(); } }
 * 
 * 
 * // 메인페이지의 캐러셀에 보여지는 상품이미지파일명을 모두 조회(SELECT) 하는 메소드
 * 
 * @Override public List<ImageVO> ImageCarouselSelectAll() throws SQLException {
 * 
 * List<ImageVO> imageCarouselList = new ArrayList<ImageVO>();
 * 
 * try {
 * 
 * 
 * conn = ds.getConnection(); // DBCP에서 connection 받아오기
 * 
 * String sql = " select imgno, imgfilename "+ " from tbl_carousel_image "+
 * " order by imgno asc ";
 * 
 * pstmt = conn.prepareStatement(sql); // prepareStatment로 sql을 보낸다.
 * 
 * rs = pstmt.executeQuery(); // select 되어진 결과를 resultSet에 받는다.
 * 
 * while(rs.next()) {
 * 
 * ImageVO imgvo = new ImageVO(); imgvo.setImgno(rs.getInt(1)); // 받아온 rs 첫번째
 * 컬럼을 imgvo의 imgno에 setter해준다. imgvo.setImgfilename(rs.getString(2));
 * 
 * imageCarouselList.add(imgvo); // imageList에 imgvo를 보내준다.
 * 
 * } // end of while(rs.next()) ---------------------------
 * 
 * } finally { close(); }
 * 
 * return imageCarouselList; }
 * 
 * 
 * // 메인페이지에 보여지는 상품이미지파일명을 모두 조회(SELECT) 하는 메소드
 * 
 * @Override public List<ImageVO> ImageSelectAll() throws SQLException {
 * 
 * List<ImageVO> imageList = new ArrayList<ImageVO>();
 * 
 * try {
 * 
 * conn = ds.getConnection(); // DBCP에서 connection 받아오기
 * 
 * String sql = " select imgno, imgfilename "+ " from tbl_main_image "+
 * " order by imgno asc ";
 * 
 * pstmt = conn.prepareStatement(sql); // prepareStatment로 sql을 보낸다.
 * 
 * rs = pstmt.executeQuery(); // select 되어진 결과를 resultSet에 받는다.
 * 
 * while(rs.next()) {
 * 
 * ImageVO imgvo = new ImageVO(); imgvo.setImgno(rs.getInt(1)); // 받아온 rs 첫번째
 * 컬럼을 imgvo의 imgno에 setter해준다. imgvo.setImgfilename(rs.getString(2));
 * 
 * imageList.add(imgvo); // imageList에 imgvo를 보내준다.
 * 
 * } // end of while(rs.next()) ---------------------------
 * 
 * } finally { close(); // 실패하든 성공하든 무조건 자원 반납 }
 * 
 * return imageList; }
 * 
 * // 메인페이지에 보여지는 상품 이미지 tbl_product 에서 조회해오는 메소드
 * 
 * @Override public List<ProductVO> ProductMainImageSelectAll() throws
 * SQLException {
 * 
 * // 메인에서 보여지는 이미지 리스트는 tbl_product의 pdimage1번( *_1) 리스트 불러오기
 * 
 * List<ProductVO> productMainImageList = new ArrayList<ProductVO>();
 * 
 * try {
 * 
 * 
 * conn = ds.getConnection();
 * 
 * String sql =
 * " select  p.pdno, p.pdname, p.pdcategory_fk, p.pdimage1, p.saleprice, pi.pcolor, pi.psize "
 * + " from tbl_product p inner join tbl_product_info pi " +
 * " on p.pdno = pi.pdno_fk " + " where p.pdgender = 2 ";
 * 
 * pstmt = conn.prepareStatement(sql);
 * 
 * rs = pstmt.executeQuery();
 * 
 * while(rs.next()) {
 * 
 * ProductVO pdvo = new ProductVO();
 * 
 * pdvo.setPdno(rs.getInt(1)); pdvo.setPdname(rs.getString(2));
 * pdvo.setPdcategory_fk(rs.getString(3)); pdvo.setPdimage1(rs.getString(4));
 * pdvo.setSaleprice(rs.getInt(5));
 * 
 * ProductInfoVO pdinfovo = new ProductInfoVO();
 * 
 * pdinfovo.setPcolor(rs.getString(6)); pdinfovo.setPsize(rs.getString(7));
 * 
 * pdvo.setPinfo(pdinfovo);
 * 
 * productMainImageList.add(pdvo);
 * 
 * 
 * }
 * 
 * 
 * 
 * conn = ds.getConnection();
 * 
 * String sql =
 * " select  pdno, pdname, pdcategory_fk, pdimage1, price, saleprice " +
 * " from tbl_product " + " where pdgender = 2 ";
 * 
 * pstmt = conn.prepareStatement(sql);
 * 
 * rs = pstmt.executeQuery();
 * 
 * while(rs.next()) {
 * 
 * ProductVO pdvo = new ProductVO();
 * 
 * pdvo.setPdno(rs.getInt(1)); pdvo.setPdname(rs.getString(2));
 * pdvo.setPdcategory_fk(rs.getString(3)); pdvo.setPdimage1(rs.getString(4));
 * pdvo.setPrice(rs.getInt(5)); pdvo.setSaleprice(rs.getInt(6));
 * 
 * productMainImageList.add(pdvo);
 * 
 * }
 * 
 * } finally { close(); }
 * 
 * 
 * return productMainImageList; }
 * 
 * // 신상품 조회해오는 메소드
 * 
 * @Override public List<ProductVO> NewProductSelectAll() throws SQLException {
 * 
 * // 조회시 나오는 페이지의 이미지에는 tbl_product의 pdimage2번( *_2) 리스트 불러오기
 * 
 * List<ProductVO> newProductList = new ArrayList<ProductVO>();
 * 
 * return newProductList; }
 * 
 * // 낮은 가격 조회해오는 메소드
 * 
 * @Override public List<ProductVO> LowerPriceProductSelectAll() throws
 * SQLException {
 * 
 * List<ProductVO> lowPriceProductList = new ArrayList<ProductVO>();
 * 
 * return lowPriceProductList; }
 * 
 * // 높은 가격 조회해오는 메소드
 * 
 * @Override public List<ProductVO> HigerPriceProductSelectAll() throws
 * SQLException {
 * 
 * List<ProductVO> HigerPriceProductList = new ArrayList<ProductVO>();
 * 
 * return HigerPriceProductList; }
 * 
 * // 카테고리
 * 
 * // 카테고리 목록 보여주는 메소드(코트, 자켓, 점퍼, 무스탕, 가디건)
 * 
 * @Override public List<CategoryVO> CategoryListSelectAll() throws SQLException
 * {
 * 
 * List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
 * 
 * conn = ds.getConnection();
 * 
 * String sql = " select cgno, cgcode, cgname " + " from tbl_category ";
 * 
 * pstmt = conn.prepareStatement(sql);
 * 
 * rs = pstmt.executeQuery(); // select 되어진 결과를 resultSet에 받는다.
 * 
 * while(rs.next()) {
 * 
 * CategoryVO categvo = new CategoryVO(); categvo.setCgno(rs.getInt(1));
 * categvo.setCgcode(rs.getString(2)); categvo.setCgname(rs.getString(3));
 * 
 * categoryList.add(categvo); // imageList에 imgvo를 보내준다.
 * 
 * } // end of while(rs.next()) ---------------------------
 * 
 * 
 * return categoryList; }
 * 
 * // 카테고리 목록 클릭시 카테고리 코드에 따라 조회하는 메소드
 * 
 * @Override public List<ProductVO> categoryProducClickSelectAll(String
 * pdcategory_fk) throws SQLException {
 * 
 * List<ProductVO> categoryProducClickList = new ArrayList<ProductVO>();
 * 
 * try {
 * 
 * conn = ds.getConnection();
 * 
 * String sql =
 * " select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender "
 * + " from tbl_product " + " where pdgender = 2 and pdcategory_fk = ? ";
 * 
 * pstmt = conn.prepareStatement(sql); pstmt.setNString(1, pdcategory_fk);
 * 
 * rs = pstmt.executeQuery();
 * 
 * while(rs.next()) {
 * 
 * ProductVO pdvo = new ProductVO(); pdvo.setPdno(rs.getInt(1));
 * pdvo.setPdname(rs.getString(2)); pdvo.setPdcategory_fk(rs.getString(3));
 * pdvo.setPdimage2(rs.getString(4)); pdvo.setPrice(rs.getInt(5));
 * pdvo.setSaleprice(rs.getInt(6)); pdvo.setPdgender(rs.getString(7));
 * 
 * categoryProducClickList.add(pdvo);
 * 
 * }
 * 
 * } finally { close(); }
 * 
 * 
 * 
 * return categoryProducClickList; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * ///////////////////////////////////////////////////////////////// // 김민아
 * Search // //search 페이지에 보여지는 상품이미지파일명을 모두 조회(select)하는 메소드
 * (MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=MINA=
 * MINA=MINA)
 * 
 * @Override public List<ProductVO> searchProduct(Map<String, String> paraMap)
 * throws SQLException {
 * 
 * List<ProductVO> searchProductList = new ArrayList<>();
 * 
 * 
 * try { conn = ds.getConnection();
 * 
 * String sql =
 * " select pdno, pdname, pdcategory_fk, pdimage1, pdimage2, price, saleprice, pdinputdate, pdgender "
 * ;
 * 
 * if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
 * 
 * if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중
 * 0(전체)을 선택했다면 sql += " from tbl_product "; } else { //pdcategory_fk(카테고리) 중
 * 0(전체)외에 다른 카테고리를 선택했다면 sql += " from tbl_product " +
 * " where pdcategory_fk = ? "; } } else { //searchname(키워드)에 입력이 되었다면, if (
 * "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을
 * 선택했다면 sql += " from tbl_product " + " where pdname like '%'|| ? ||'%' "; }
 * else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면 sql +=
 * " from tbl_product " +
 * " where pdcategory_fk = ? and pdname like '%'|| ? ||'%' "; } }
 * 
 * sql += " order by saleprice ";
 * 
 * 
 * pstmt = conn.prepareStatement(sql);
 * 
 * if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
 * 
 * if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중
 * 0(전체)을 선택했다면 } else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
 * pstmt.setString(1, paraMap.get("pdcategory_fk")); } } else {
 * //searchname(키워드)에 입력이 되었다면, if ( "0".equals(paraMap.get("pdcategory_fk")) )
 * { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면 pstmt.setString(1,
 * paraMap.get("searchname")); } else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를
 * 선택했다면 pstmt.setString(1, paraMap.get("pdcategory_fk")); pstmt.setString(2,
 * paraMap.get("searchname")); } }
 * 
 * rs = pstmt.executeQuery();
 * 
 * while(rs.next()) {
 * 
 * ProductVO pvo = new ProductVO();
 * 
 * pvo.setPdno( rs.getInt(1) ); pvo.setPdname( rs.getString(2) );
 * pvo.setPdcategory_fk(rs.getString(3)); pvo.setPdimage1(rs.getString(4));
 * pvo.setPdimage2(rs.getString(5)); pvo.setPrice(rs.getInt(6));
 * pvo.setSaleprice(rs.getInt(7)); pvo.setPdinputdate(rs.getString(8));
 * pvo.setPdgender(rs.getString(9));
 * 
 * searchProductList.add(pvo);
 * 
 * }// end of while-------------------------
 * 
 * } finally { close(); }
 * 
 * return searchProductList; }
 * 
 * 
 * }
 */