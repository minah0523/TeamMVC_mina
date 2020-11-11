package myshop.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class ProductDAO implements InterProductDAO {

	private DataSource ds;   // DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool) 이다.
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자
	public ProductDAO() {
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/teammvc_oracle");
		} catch(NamingException e) {
			e.printStackTrace();
		}	
	}
	
	// 사용한 자원을 반납하는 close() 메소드 생성하기 
	private void close() {
		try {
			if(rs != null)    {rs.close();    rs=null;}
			if(pstmt != null) {pstmt.close(); pstmt=null;}
			if(conn != null)  {conn.close();  conn=null;}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<ImageVO> imageSelectAll() throws SQLException {
		
		List<ImageVO> imgList = new ArrayList<>();
		
		try {
			 conn = ds.getConnection();
			 
			 String sql = "select imgno, imgfilename "+
					      "from tbl_main_image "+
					      "order by imgno asc";
			 
			 pstmt = conn.prepareStatement(sql);
			 
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 
				 ImageVO imgvo = new ImageVO();
				 imgvo.setImgno(rs.getInt(1));
				 imgvo.setImgfilename(rs.getString(2));
				 
				 imgList.add(imgvo);
			 }// end of while-------------------------
			 
		} finally {
			close();
		}
		
		return imgList;
	}
	
	//search 페이지에 보여지는 상품이미지파일명을 모두 조회(select)하는 메소드 (MINA)
	@Override
	public List<ProductVO> searchProduct(Map<String, String> paraMap) throws SQLException {
		
		List<ProductVO> searchProductList = new ArrayList<>();

		
		try {
			 conn = ds.getConnection();
			 
			 String sql = " select pdno, pdname, pdcategory_fk, pdimage1, pdimage2, price, saleprice, pdinputdate, pdgender ";
			 
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
				 else {	//pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
					 sql += " from tbl_product "
						 + " where pdcategory_fk = ? and pdname like '%'|| ? ||'%' ";	
				 }
			 }
				
			 sql += " order by saleprice ";
			 
			 
			 pstmt = conn.prepareStatement(sql);
			 
			 if(paraMap.get("searchname") == null ) { //searchname(키워드)에 아무것도 입력하지 않았다면,
				 
				 if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
				 }
				 else { //pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
					 pstmt.setString(1, paraMap.get("pdcategory_fk"));
				 }
			 }	 
			 else { //searchname(키워드)에 입력이 되었다면,
				 if ( "0".equals(paraMap.get("pdcategory_fk")) ) { //pdcategory_fk(카테고리) 중 0(전체)을 선택했다면
					 pstmt.setString(1, paraMap.get("searchname"));
				 }
				 else {	//pdcategory_fk(카테고리) 중 0(전체)외에 다른 카테고리를 선택했다면
					 pstmt.setString(1, paraMap.get("pdcategory_fk"));
					 pstmt.setString(2, paraMap.get("searchname"));
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

}



