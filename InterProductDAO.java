package myshop.model;

import java.sql.SQLException;
import java.util.*;

public interface InterProductDAO {

	// 메인페이지에 보여지는 상품이미지파일명을 모두 조회(select)하는 메소드 
	
	// DTO(Data Transfer Object) == VO(Value Object)
	List<ImageVO> imageSelectAll() throws SQLException;

	// search페이지에 보여지는 상품이미지파일명을 모두 조회(select)하는 메소드 (MINA)
	List<ProductVO> searchProduct(Map<String, String> paraMap) throws SQLException; 
	
	// search페이지에 보여지는 상품이미지에 대한 색상을 모두 조회(select)하는 메소드 (MINA)
	List<String> selectProductColor(String pdno) throws SQLException;

	List<String> selectProductSize(String pdno) throws SQLException; 

	
}
