package myshop.model;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAO implements InterProductDAO {

	private DataSource ds; // DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool) 이다.
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 기본 생성자
	public ProductDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/teammvc_oracle"); // 이름(web.xml에 res-ref-name에 해당하는 것)
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 사용한 자원을 반납하는 close() 매소드 생성하기
	private void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 메인페이지의 캐러셀에 보여지는 상품이미지파일명을 모두 조회(SELECT) 하는 메소드
	@Override
	public List<ImageVO> ImageCarouselSelectAll() throws SQLException {

		List<ImageVO> imageCarouselList = new ArrayList<ImageVO>();

		try {

			conn = ds.getConnection(); // DBCP에서 connection 받아오기

			String sql = " select imgno, imgfilename " + " from tbl_carousel_image " + " order by imgno asc ";

			pstmt = conn.prepareStatement(sql); // prepareStatment로 sql을 보낸다.

			rs = pstmt.executeQuery(); // select 되어진 결과를 resultSet에 받는다.

			while (rs.next()) {

				ImageVO imgvo = new ImageVO();
				imgvo.setImgno(rs.getInt(1)); // 받아온 rs 첫번째 컬럼을 imgvo의 imgno에 setter해준다.
				imgvo.setImgfilename(rs.getString(2));

				imageCarouselList.add(imgvo); // imageList에 imgvo를 보내준다.

			} // end of while(rs.next()) ---------------------------

		} finally {
			close();
		}

		return imageCarouselList;
	}

	// 메인페이지에 보여지는 상품 이미지 tbl_product 에서 조회해오는 메소드
	@Override
	// public List<ProductVO> ProductMainImageSelectAll(String sortType) throws
	// SQLException {
	public List<ProductVO> ProductMainImageSelectAll(Map<String, String> paraMap) throws SQLException {

		List<ProductVO> productMainImageList = new ArrayList<ProductVO>();

		try {

			conn = ds.getConnection();

			/*
			 * String sql =
			 * " select  pdno, pdname, pdcategory_fk, pdimage1, price, saleprice " +
			 * " from tbl_product " + " where pdgender = 2 ";
			 */

			String sql = " select  pdno, pdname, pdcategory_fk, pdimage1, price, saleprice ";

			/////////////////////////////////////

			/*
			 * ver1. if("sortHighPrice".equals(sortType)) { // 값이 있는데 그 값이 sortHighPrice라면
			 * (높은 가격) sql += " from tbl_product " + " where pdgender = 2 " +
			 * " ORDER BY saleprice desc "; } else if("sortLowPrice".equals(sortType)){ //
			 * 값이 있는데 그 값이 sortLowPrice라면 (낮은 가격) sql += " from tbl_product " +
			 * " where pdgender = 2 " + " ORDER BY saleprice asc "; } else
			 * if("sortNewProduct".equals(sortType)) { // 값이 있는데 그 값이 sortNewProduct라면 (신상품
			 * 조회) sql += " from tbl_product " +
			 * " where pdgender = 2 and pdinputdate >= (sysdate - 31)"; } else { sql +=
			 * " from tbl_product " + " where pdgender = 2 "; }
			 */

			// sql += " from tbl_product "
			// + " where pdgender = ? " ;

			// if(pdcategory_fk == 0) {
			// ;
			// }
			// else {
			// sql += " and pdcategory_fk = ? ";
			// }

			if ("1".equals(paraMap.get("gender"))) {
				System.out.println("test 남자 1 들어온 경우  " + paraMap.get("gender"));

				// 남자일 경우
				if ("sortHighPrice".equals(paraMap.get("sortType"))) {
					// 값이 있는데 그 값이 sortHighPrice라면 (높은 가격)

					System.out.println("test 남자 1 높은가격 들어온 경우  " + paraMap.get("gender"));

					sql +=

							sql += " from tbl_product " + " where pdgender = 1 " + " ORDER BY saleprice desc ";
				} else if ("sortLowPrice".equals(paraMap.get("sortType"))) {
					// 값이 있는데 그 값이 sortLowPrice라면 (낮은 가격)

					System.out.println("test 남자 1 낮은 가격들어온 경우  " + paraMap.get("gender"));

					sql += " from tbl_product " + " where pdgender = 1 " + " ORDER BY saleprice asc ";
				} else if ("sortNewProduct".equals(paraMap.get("sortType"))) {
					// 값이 있는데 그 값이 sortNewProduct라면 (신상품 조회)

					System.out.println("test 남자 1 신상품에 들어온 경우  " + paraMap.get("gender"));

					sql += " from tbl_product " + " where pdgender = 1 and pdinputdate >= (sysdate - 31)";
				} else {
					sql += " from tbl_product " + " where pdgender = 1 ";
				}
			} else {
				// 여자 일 경우
				if ("sortHighPrice".equals(paraMap.get("sortType"))) {
					// 값이 있는데 그 값이 sortHighPrice라면 (높은 가격)
					sql += " from tbl_product " + " where pdgender = 2 " + " ORDER BY saleprice desc ";
				} else if ("sortLowPrice".equals(paraMap.get("sortType"))) {
					// 값이 있는데 그 값이 sortLowPrice라면 (낮은 가격)
					sql += " from tbl_product " + " where pdgender = 2 " + " ORDER BY saleprice asc ";
				} else if ("sortNewProduct".equals(paraMap.get("sortType"))) {
					// 값이 있는데 그 값이 sortNewProduct라면 (신상품 조회)
					sql += " from tbl_product " + " where pdgender = 2 and pdinputdate >= (sysdate - 31)";
				} else {
					sql += " from tbl_product " + " where pdgender = 2 ";
				}

			}

			///////////////////////////////////////////

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ProductVO pdvo = new ProductVO();

				pdvo.setPdno(rs.getInt(1));
				pdvo.setPdname(rs.getString(2));
				pdvo.setPdcategory_fk(rs.getString(3));
				pdvo.setPdimage1(rs.getString(4));
				pdvo.setPrice(rs.getInt(5));
				pdvo.setSaleprice(rs.getInt(6));

				productMainImageList.add(pdvo);

			}

		} finally {
			close();
		}

		return productMainImageList;
	}

	// 메인페이지에서 보요지는 상품 색상 tbl_product_info에서 조회해오는 메소드(JIEUN)
	@Override
	public List<String> ProductMainColorSelectAll(String pdno) throws SQLException {

		List<String> ProductMainColorSelect = new ArrayList<>();

		try {

			conn = ds.getConnection();

			String sql = " select distinct pcolor " + " from tbl_product_info " + " where pdno_fk = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdno); // 위치홀더에 String으로 받아온 pdno를 추가해준다.

			rs = pstmt.executeQuery(); // 이걸 Query 보내서 ResultSet에 담는다.

			while (rs.next()) {
				ProductMainColorSelect.add(rs.getString(1)); // ProductMainColorSelect에 첫번째인 pcolor를 추가한다.
			}

		} finally {
			close();
		}

		return ProductMainColorSelect;
	}

	// 신상품 조회해오는 메소드
	/*
	 * @Override public List<ProductVO> NewProductSelectAll() throws SQLException {
	 * 
	 * // 조회시 나오는 페이지의 이미지에는 tbl_product의 pdimage2번( *_2) 리스트 불러오기
	 * 
	 * List<ProductVO> newProductList = new ArrayList<ProductVO>();
	 * 
	 * 
	 * 
	 * return newProductList; }
	 */

	// 낮은 가격 조회해오는 메소드
	/*
	 * @Override public List<ProductVO> LowerPriceProductSelectAll(String gender)
	 * throws SQLException {
	 * 
	 * List<ProductVO> lowPriceProductList = new ArrayList<ProductVO>();
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * String sql =
	 * " select pdno, pdname, pdcategory_fk, pdimage2,price, saleprice, pdgender " +
	 * " from tbl_product ";
	 * 
	 * if("1".equals(gender)) { sql += " where pdgender = ? " +
	 * " order by saleprice asc "; } else if("2".equals(gender)) { sql +=
	 * " where pdgender = ? " + " order by saleprice asc "; }
	 * 
	 * pstmt = conn.prepareStatement(sql);
	 * 
	 * if("1".equals(gender)) { pstmt.setString(1, gender); } else
	 * if("2".equals(gender)) { pstmt.setString(1, gender); }
	 * 
	 * } finally { close(); }
	 * 
	 * 
	 * return lowPriceProductList; }
	 */

	// 높은 가격 조회해오는 메소드
	/*
	 * @Override
	 * 
	 * public List<ProductVO> HigerPriceProductSelectAll() throws SQLException {
	 * 
	 * List<ProductVO> HigerPriceProductList = new ArrayList<ProductVO>();
	 * 
	 * return HigerPriceProductList; }
	 */

	// 카테고리

	// 카테고리 목록 보여주는 메소드(코트, 자켓, 점퍼, 무스탕, 가디건)
	@Override
	public List<CategoryVO> CategoryListSelectAll() throws SQLException {

		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();

		conn = ds.getConnection();

		String sql = " select cgno, cgcode, cgname " + " from tbl_category ";

		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery(); // select 되어진 결과를 resultSet에 받는다.

		while (rs.next()) {

			CategoryVO categvo = new CategoryVO();
			categvo.setCgno(rs.getInt(1));
			categvo.setCgcode(rs.getString(2));
			categvo.setCgname(rs.getString(3));

			categoryList.add(categvo); // imageList에 imgvo를 보내준다.

		} // end of while(rs.next()) ---------------------------

		return categoryList;
	}

	// 카테고리 목록 클릭시 카테고리 코드에 따라 조회하는 메소드
	@Override
	public List<ProductVO> categoryProducClickSelectAll(Map<String, String> paraMap) throws SQLException {

		List<ProductVO> categoryProducClickList = new ArrayList<ProductVO>();

		try {

			conn = ds.getConnection();

			String sql = " select pdno, pdname, pdcategory_fk, pdimage2, price, saleprice, pdgender ";

			/*
			 * 경우의 수 - 정렬이 null인 경우(카테고리 코드만 입력된 경우, 카테고리별로 보여주면 된다.)
			 * 
			 * - 정렬이 있는 경우 1. 성별이 null(메인페이지) 이면 tbl_product테이블에서 성별이 여자이고 클릭한 카테고리 코드별로
			 * 보여줘라
			 * 
			 * 이렇게 출력된 결과를 정렬하자
			 * 
			 * 
			 * 2.
			 */

			/*
			 * 잘 돌아가는 원본
			 * 
			 * if(paraMap.get("gender") == null) { // 메인 페이지 sql += " from tbl_product " +
			 * " where pdgender = 2 and pdcategory_fk = ? "; } else
			 * if("1".equals(paraMap.get("gender"))) { sql += " from tbl_product " +
			 * " where pdgender = ? and pdcategory_fk = ? "; } else { sql +=
			 * " from tbl_product " + " where pdgender = ? and pdcategory_fk = ? "; }
			 * 
			 * pstmt = conn.prepareStatement(sql);
			 * 
			 * if(paraMap.get("gender") == null) { // 메인 페이지 pstmt.setString(1,
			 * paraMap.get("pdcategory_fk")); } else if("1".equals(paraMap.get("gender"))) {
			 * pstmt.setString(1, paraMap.get("gender")); pstmt.setString(2,
			 * paraMap.get("pdcategory_fk")); } else { pstmt.setString(1,
			 * paraMap.get("gender")); pstmt.setString(2, paraMap.get("pdcategory_fk")); }
			 * 
			 */

			if (paraMap.get("sort") == null) {
				// 정렬타입이 없는 경우

				System.out.println("정렬이 null 인경우 /////");

				if (paraMap.get("gender") == null) {
					// 메인 페이지
					System.out.println("정렬이 null 이면서 성별이 null인 경우");
					sql += " from tbl_product " + " where pdgender = 2 and pdcategory_fk = ? ";
				} else if ("1".equals(paraMap.get("gender"))) {
					System.out.println("정렬이 null 이면서 성별이 남자 인 경우");

					sql += " from tbl_product " + " where pdgender = ? and pdcategory_fk = ? ";
				} else {
					// 여자

					System.out.println("정렬이 null 이면서 성별이 여자 인 경우");

					sql += " from tbl_product " + " where pdgender = ? and pdcategory_fk = ? ";
				}
			} else {
				// 정렬이 있는 경우

				System.out.println("정렬이 있는경우 ~~~~~");

				if (paraMap.get("gender") == null) {
					// 메인 페이지

					System.out.println("정렬이 있고 gender값이 null 인 경우 ");

					if ("sortHighPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortHighPrice 클릭 시 (높은 가격)

						System.out.println("정렬이 있고 gender값이 null이고 정렬타입이 sortHighPrice 인 경우 ");

						sql += " from tbl_product " + " where pdgender = 2 and pdcategory_fk = ? "
								+ " order by saleprice desc ";
					} else if ("sortLowPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortLowPrice 클릭 시 (낮은 가격)

						System.out.println("정렬이 있고 gender값이 null이고 정렬타입이 sortLowPrice 인 경우 ");

						sql += " from tbl_product " + " where pdgender = 2 and pdcategory_fk = ? "
								+ " order by saleprice asc ";
					} else if ("sortNewProduct".equals(paraMap.get("sort"))) {
						// 정렬 중 sortNewProduct 클릭 시 (신상품)
						System.out.println("정렬이 있고 gender값이 null이고 정렬타입이 sortNewProduct 인 경우 ");

						sql += " from tbl_product "
								+ " where pdgender = 2 and pdcategory_fk = ? and pdinputdate >= (sysdate - 31)";
					} else {
						// sql
					}
				} else if ("1".equals(paraMap.get("gender"))) {
					// 남자 페이지
					System.out.println("정렬이 있고 gender값이 남자인 경우 ");

					if ("sortHighPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortHighPrice 클릭 시 (높은 가격)

						System.out.println("정렬이 있고 gender값이 남자이고 정렬타입이 sortHighPrice 인 경우 ");

						sql += " from tbl_product " + " where pdgender = ? and pdcategory_fk = ? "
								+ " order by saleprice desc ";
					} else if ("sortLowPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortLowPrice 클릭 시 (낮은 가격)

						System.out.println("정렬이 있고 gender값이 남자이고 정렬타입이 sortLowPrice 인 경우 ");

						sql += " from tbl_product " + " where pdgender = ? and pdcategory_fk = ? "
								+ " order by saleprice asc ";
					} else if ("sortNewProduct".equals(paraMap.get("sort"))) {
						// 정렬 중 sortNewProduct 클릭 시 (신상품)

						System.out.println("정렬이 있고 gender값이 남자이고 정렬타입이 sortNewProduct 인 경우 ");

						sql += " from tbl_product "
								+ " where pdgender = ? and pdcategory_fk = ? and pdinputdate >= (sysdate - 31)";
					} else {
						;
					}
				} else {
					// 여자 메인페이지
					System.out.println("정렬이 있고 gender값이 여자인 경우 ");

					if ("sortHighPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortHighPrice 클릭 시 (높은 가격)

						System.out.println("정렬이 있고 gender값이 여자이고 정렬타입이 sortHighPrice 인 경우 ");

						sql += " from tbl_product " + " where pdgender = ? and pdcategory_fk = ? "
								+ " order by saleprice desc ";
					} else if ("sortLowPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortLowPrice 클릭 시 (낮은 가격)
						System.out.println("정렬이 있고 gender값이 여자이고 정렬타입이 sortLowPrice 인 경우 ");

						sql += " from tbl_product " + " where pdgender = ? and pdcategory_fk = ? "
								+ " order by saleprice asc ";
					} else if ("sortNewProduct".equals(paraMap.get("sort"))) {
						// 정렬 중 sortNewProduct 클릭 시 (신상품)
						System.out.println("정렬이 있고 gender값이 여자이고 정렬타입이 sortNewProduct 인 경우 ");

						sql += " from tbl_product "
								+ " where pdgender = ? and pdcategory_fk = ? and pdinputdate >= (sysdate - 31)";
					} else {
						;
					}
				} // 여자메인페이지 끝-----------------------------

			} // 정렬이 있는 경우 끝--------------------------------

			pstmt = conn.prepareStatement(sql);

			if (paraMap.get("sort") == null) {
				// 정렬타입이 없는 경우

				if (paraMap.get("gender") == null) {
					// 메인 페이지
					pstmt.setString(1, paraMap.get("pdcategory_fk"));

				} else if ("1".equals(paraMap.get("gender"))) {
					pstmt.setString(1, paraMap.get("gender"));
					pstmt.setString(2, paraMap.get("pdcategory_fk"));

				} else {
					// 여자
					pstmt.setString(1, paraMap.get("gender"));
					pstmt.setString(2, paraMap.get("pdcategory_fk"));
				}
			} else {
				// 정렬이 있는 경우
				if (paraMap.get("gender") == null) {
					// 메인 페이지
					if ("sortHighPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortHighPrice 클릭 시 (높은 가격)
						pstmt.setString(1, paraMap.get("pdcategory_fk"));

					} else if ("sortLowPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortLowPrice 클릭 시 (낮은 가격)
						pstmt.setString(1, paraMap.get("pdcategory_fk"));
					} else if ("sortNewProduct".equals(paraMap.get("sort"))) {
						// 정렬 중 sortNewProduct 클릭 시 (신상품)
						pstmt.setString(1, paraMap.get("pdcategory_fk"));
					} else {
						;
					}
				} else if ("1".equals(paraMap.get("gender"))) {
					// 남자 페이지
					if ("sortHighPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortHighPrice 클릭 시 (높은 가격)
						pstmt.setString(1, paraMap.get("gender"));
						pstmt.setString(2, paraMap.get("pdcategory_fk"));
					} else if ("sortLowPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortLowPrice 클릭 시 (낮은 가격)
						pstmt.setString(1, paraMap.get("gender"));
						pstmt.setString(2, paraMap.get("pdcategory_fk"));
					} else if ("sortNewProduct".equals(paraMap.get("sort"))) {
						// 정렬 중 sortNewProduct 클릭 시 (신상품)
						pstmt.setString(1, paraMap.get("gender"));
						pstmt.setString(2, paraMap.get("pdcategory_fk"));
					} else {
						;
					}
				} else {
					// 여자 메인페이지
					if ("sortHighPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortHighPrice 클릭 시 (높은 가격)
						pstmt.setString(1, paraMap.get("gender"));
						pstmt.setString(2, paraMap.get("pdcategory_fk"));

					} else if ("sortLowPrice".equals(paraMap.get("sort"))) {
						// 정렬 중 sortLowPrice 클릭 시 (낮은 가격)
						pstmt.setString(1, paraMap.get("gender"));
						pstmt.setString(2, paraMap.get("pdcategory_fk"));
					} else if ("sortNewProduct".equals(paraMap.get("sort"))) {
						// 정렬 중 sortNewProduct 클릭 시 (신상품)
						pstmt.setString(1, paraMap.get("gender"));
						pstmt.setString(2, paraMap.get("pdcategory_fk"));
					} else {
						;
					}
				} // 여자메인페이지 끝-----------------------------

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ProductVO pdvo = new ProductVO();
				pdvo.setPdno(rs.getInt(1));
				pdvo.setPdname(rs.getString(2));
				pdvo.setPdcategory_fk(rs.getString(3));
				pdvo.setPdimage2(rs.getString(4));
				pdvo.setPrice(rs.getInt(5));
				pdvo.setSaleprice(rs.getInt(6));
				pdvo.setPdgender(rs.getString(7));

				categoryProducClickList.add(pdvo);

			}

		} finally {
			close();
		}

		return categoryProducClickList;
	}

	/////////////////////////////////////////////////////////////////
	//search 페이지에 보여지는 상품이미지파일명을 모두 조회(select)하는 메소드 (MINA)
	   @Override
	   public List<ProductVO> searchProduct(Map<String, String> paraMap) throws SQLException {
	      
	      List<ProductVO> searchProductList = new ArrayList<>();

	      try {
	          conn = ds.getConnection();
	          
	          String sql = " select pdno, pdname, pdcategory_fk, pdimage1, pdimage2, price, saleprice, pdinputdate, pdgender "
	          		+ "from "+
					"( "+
					"    select rownum AS rno, pdno, pdname, pdcategory_fk, pdimage1, pdimage2, price, saleprice, pdinputdate, pdgender  "+
					"    from "+
					"    ( "+
					"        select pdno, pdname, pdcategory_fk, pdimage1, pdimage2, price, saleprice, pdinputdate, pdgender  ";
	          
	          
	          if( "1".equals(paraMap.get("pdgender")) || "2".equals(paraMap.get("pdgender"))) { // gender에 성별을 '여성(2)' '남성(1)' 입력했다면 
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product "
	                         + " where pdgender = ? ";
	                }
	                else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                        + " where pdcategory_fk = ? and pdgender = ? ";
	                }
	             }
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product "
	                       + " where pdname like '%'|| ? ||'%' and pdgender = ?  ";
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                      + " where pdcategory_fk = ? and pdname like '%'|| ? ||'%' and pdgender = ? ";   
	                }
	             }
	             
	          }// end of if( "1".equals(paraMap.get("pdgender")) || "2".equals(paraMap.get("pdgender")))-----------------------------
	         
	          else { // gender에 성별을 입력하지 않았거나 '전체'를 입력했다면,
	             
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product ";
	                }
	                else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                        + " where pdcategory_fk = ? ";
	                }
	             }
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product "
	                       + " where pdname like '%'|| ? ||'%' ";
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                      + " where pdcategory_fk = ? and pdname like '%'|| ? ||'%' ";   
	                }
	             }
	             
	          }// end of else -----------
	          
	          
	          // 신상품순을 클릭했다면
	          if( paraMap.get("sort") == null ) {
	             sql += " order by pdinputdate desc  ";
	          }
	          else if("sortNewProduct".equalsIgnoreCase(paraMap.get("sort"))) {
	             sql += " order by pdinputdate desc ";
	          }
	          // 낮은가격순을 클릭했다면
	          else if("sortLowPrice".equalsIgnoreCase(paraMap.get("sort"))) {
	             sql += " order by saleprice ";
	          }
	          // 높은가격순을 클릭했다면
	          else if("sortHighPrice".equalsIgnoreCase(paraMap.get("sort"))) {
	             sql += " order by saleprice desc ";
	          }
	          // 인기상품순을 클릭했다면 ------------- 현재 신상품순으로 정렬되고 있음 (수정필요)
	          else if("sortBestProduct".equalsIgnoreCase(paraMap.get("sort"))) {
	             sql += " order by pdinputdate desc  ";
	          }
	          else { // 아무것도 클릭하지 않았다면 신상품순으로 정렬
	             sql += " order by pdinputdate desc  ";
	          }
	          
	          
	          sql +=  "  	) V "+
						") T  "+
						"where rno between ? and ? ";
	          
	          pstmt = conn.prepareStatement(sql);
	          
	          
	          // *** neige의 경우 1페이지당 아이템 16개씩 보여주기로 한다 *** //
	          int currentShowPageNo = Integer.parseInt( paraMap.get("currentShowPageNo") );
		      int sizePerPage = 16;
	          
	          if( "1".equals(paraMap.get("pdgender")) || "2".equals(paraMap.get("pdgender"))) {  // gender에 성별을 '여성(2)' '남성(1)' 입력했다면 
	             
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   pstmt.setString(1, paraMap.get("pdgender"));
	                   pstmt.setInt(2, (currentShowPageNo * sizePerPage) - (sizePerPage - 1)); // 공식
	   				   pstmt.setInt(3, (currentShowPageNo * sizePerPage)); // 공식 
	                }
	                else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                   pstmt.setString(2, paraMap.get("pdgender"));
	                   pstmt.setInt(3, (currentShowPageNo * sizePerPage) - (sizePerPage - 1)); // 공식
	   				   pstmt.setInt(4, (currentShowPageNo * sizePerPage)); // 공식 
	                }
	             }    
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   pstmt.setString(1, paraMap.get("searchname"));
	                   pstmt.setString(2, paraMap.get("pdgender"));
	                   pstmt.setInt(3, (currentShowPageNo * sizePerPage) - (sizePerPage - 1)); // 공식
	   				   pstmt.setInt(4, (currentShowPageNo * sizePerPage)); // 공식 
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                   pstmt.setString(2, paraMap.get("searchname"));
	                   pstmt.setString(3, paraMap.get("pdgender"));
	                   pstmt.setInt(5, (currentShowPageNo * sizePerPage) - (sizePerPage - 1)); // 공식
	   				   pstmt.setInt(6, (currentShowPageNo * sizePerPage)); // 공식 
	                }
	             }
	                
	          }
	          else {  // gender에 성별을 입력하지 않았거나 '전체'를 입력했다면,
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                if ( !"0".equals(paraMap.get("pdcategory_fk")) ) {  //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                   pstmt.setInt(2, (currentShowPageNo * sizePerPage) - (sizePerPage - 1)); // 공식
	   				   pstmt.setInt(3, (currentShowPageNo * sizePerPage)); // 공식 
	                }
	             }    
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   pstmt.setString(1, paraMap.get("searchname"));
	                   pstmt.setInt(2, (currentShowPageNo * sizePerPage) - (sizePerPage - 1)); // 공식
	   				   pstmt.setInt(3, (currentShowPageNo * sizePerPage)); // 공식 
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                   pstmt.setString(2, paraMap.get("searchname"));
	                   pstmt.setInt(3, (currentShowPageNo * sizePerPage) - (sizePerPage - 1)); // 공식
	   				   pstmt.setInt(4, (currentShowPageNo * sizePerPage)); // 공식 
	                }
	             }
	          }
	          
	          
	          rs = pstmt.executeQuery();
	          
	          while(rs.next()) {
	             
	             ProductVO pvo = new ProductVO();
	      
	             pvo.setPdno( rs.getInt(1) ); 
	             pvo.setPdname( rs.getString(2) );
	             pvo.setPdcategory_fk(rs.getString(3));
	             pvo.setPdimage1(rs.getString(4));
	             pvo.setPdimage2(rs.getString(5));
	             pvo.setPrice(rs.getInt(6));
	             pvo.setSaleprice(rs.getInt(7));
	             pvo.setPdinputdate(rs.getString(8));
	             pvo.setPdgender(rs.getString(9));
	             
	             searchProductList.add(pvo);
	             
	          }// end of while-------------------------
	          
	      } finally {
	         close();
	      }
	      
	      return searchProductList;
	   }

	   
	   // search페이지에 보여지는 상품이미지에 대한 색상을 모두 조회(select)하는 메소드 (MINA)
	   @Override
	   public List<String> selectProductColor(String pdno) throws SQLException {

	      List<String> prodInfoList = new ArrayList<>();
	      
	      try {
	          conn = ds.getConnection();
	          
	          String sql = "select distinct pcolor "+
	                     "from tbl_product_info  "+
	                     "where pdno_fk = ? "; 
	           
	          pstmt = conn.prepareStatement(sql);
	          pstmt.setString(1, pdno);
	          
	          rs = pstmt.executeQuery();
	          
	          while(rs.next()) {
	             prodInfoList.add( rs.getString(1) );
	          }// end of while-------------------------
	          
	      } finally {
	         close();
	      }
	      
	      return prodInfoList;
	   }


	   // search페이지에 보여지는 상품이미지에 대한 사이즈를 모두 조회(select)하는 메소드 (MINA)
		@Override
	      public List<String> selectProductSize(String pdno) throws SQLException {

	         List<String> prodInfoList = new ArrayList<>();
	         
	         try {
	             conn = ds.getConnection();
	             
	             String sql = " select distinct psize "+
	                       " from tbl_product_info  "+
	                       " where pdno_fk = ? "+
	                       " order by psize desc "; 
	              
	             pstmt = conn.prepareStatement(sql);
	             pstmt.setString(1, pdno);
	             
	             rs = pstmt.executeQuery();
	             
	             while(rs.next()) {
	                prodInfoList.add( rs.getString(1) );
	             }// end of while-------------------------
	             
	         } finally {
	            close();
	         }
	         
	         return prodInfoList;
	      }

		// 페이징처리를 위해서 전체회원에 대한 총페이지 개수 알아오기(select) (Mina)
		@Override
		public int getTotalPage(Map<String, String> paraMap) throws SQLException {
			int totalPage = 0;
		          
			conn = ds.getConnection();
			          
	          // *** neige의 경우 1페이지당 아이템 16개씩 보여주기로 한다 *** //
	          String sql = " select ceil( count(*)/ 16 ) ";
	          
	          
	          if( "1".equals(paraMap.get("pdgender")) || "2".equals(paraMap.get("pdgender"))) { // gender에 성별을 '여성(2)' '남성(1)' 입력했다면 
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product "
	                         + " where pdgender = ? ";
	                }
	                else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                        + " where pdcategory_fk = ? and pdgender = ? ";
	                }
	             }
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product "
	                       + " where pdname like '%'|| ? ||'%' and pdgender = ?  ";
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                      + " where pdcategory_fk = ? and pdname like '%'|| ? ||'%' and pdgender = ? ";   
	                }
	             }
	             
	          }// end of if( "1".equals(paraMap.get("pdgender")) || "2".equals(paraMap.get("pdgender")))-----------------------------
	         
	          else { // gender에 성별을 입력하지 않았거나 '전체'를 입력했다면,
	             
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product ";
	                }
	                else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                        + " where pdcategory_fk = ? ";
	                }
	             }
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   sql += " from tbl_product "
	                       + " where pdname like '%'|| ? ||'%' ";
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   sql += " from tbl_product "
	                      + " where pdcategory_fk = ? and pdname like '%'|| ? ||'%' ";   
	                }
	             }
	             
	          }// end of else -----------
	          
	          
	          pstmt = conn.prepareStatement(sql);
	          
	          
	          if( "1".equals(paraMap.get("pdgender")) || "2".equals(paraMap.get("pdgender"))) {  // gender에 성별을 '여성(2)' '남성(1)' 입력했다면 
	             
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   pstmt.setString(1, paraMap.get("pdgender"));
	                }
	                else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                   pstmt.setString(2, paraMap.get("pdgender"));
	                }
	             }    
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   pstmt.setString(1, paraMap.get("searchname"));
	                   pstmt.setString(2, paraMap.get("pdgender"));
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                   pstmt.setString(2, paraMap.get("searchname"));
	                   pstmt.setString(3, paraMap.get("pdgender"));
	                }
	             }
	                
	          }
	          else {  // gender에 성별을 입력하지 않았거나 '전체'를 입력했다면,
	             if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
	                if ( !"0".equals(paraMap.get("pdcategory_fk")) ) {  //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                }
	             }    
	             else { //searchname(키워드)에 입력이 되었다면,
	                if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
	                   pstmt.setString(1, paraMap.get("searchname"));
	                }
	                else {   //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
	                   pstmt.setString(1, paraMap.get("pdcategory_fk"));
	                   pstmt.setString(2, paraMap.get("searchname"));
	                }
	             }
	          }
	          
	          
	          rs = pstmt.executeQuery();
	          
	          rs.next();       
	          
	          totalPage = rs.getInt(1);
             
			return totalPage;		


	}


}




























