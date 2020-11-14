package myshop.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface InterProductDAO {
	
	// 메인페이지의 캐러셀에 보여지는 상품이미지파일명을 모두 조회(SELECT) 하는 메소드 (JIEUN)
	List<ImageVO> ImageCarouselSelectAll() throws SQLException;
	
	// 메인페이지에 보여지는 상품 이미지 tbl_product 에서 조회해오는 메소드  (JIEUN)
	// List<ProductVO> ProductMainImageSelectAll(String sortType) throws SQLException;
	List<ProductVO> ProductMainImageSelectAll(Map<String, String> paraMap) throws SQLException;
	
	// 메인페이지에서 보요지는 상품 색상 tbl_product_info에서 조회해오는 메소드(JIEUN)
	List<String> ProductMainColorSelectAll(String pdno) throws SQLException;
	
	// 신상품 조회해오는 메소드  (JIEUN)
	// List<ProductVO> NewProductSelectAll() throws SQLException;
	
	// 낮은 가격 조회해오는 메소드  (JIEUN)
	// List<ProductVO> LowerPriceProductSelectAll(String gender) throws SQLException;
	
	// 높은 가격 조회해오는 메소드  (JIEUN)
	// List<ProductVO> HigerPriceProductSelectAll() throws SQLException;
	
	// 카테고리 목록 보여주는 메소드(코트, 자켓, 점퍼, 무스탕, 가디건)  (JIEUN)
	List<CategoryVO> CategoryListSelectAll() throws SQLException;

	// 카테고리 목록 클릭시 카테고리 코드에 따라 조회하는 메소드  (JIEUN)
	List<ProductVO> categoryProducClickSelectAll(Map<String, String> paraMap) throws SQLException;
	
	// search페이지에 보여지는 상품이미지파일명을 모두 조회(select)하는 메소드 (MINA)
	List<ProductVO> searchProduct(Map<String, String> paraMap) throws SQLException;

	List<String> selectProductColor(String pdno) throws SQLException;

	List<String> selectProductSize(String pdno) throws SQLException;	
	
}
