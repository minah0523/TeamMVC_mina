package search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;
import myshop.model.InterProductDAO;
import myshop.model.ProductDAO;
import myshop.model.ProductVO;

public class SearchController1 extends AbstractController {
	
	@Override
	public String toString() {
		return "@@@ : 클래스 IndexController의 인스턴스 메소드 toString() 호출";
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// System.out.println("@@@ 확인용 IndexController의 메소드 execute호출됨");
		
		
		/* 캐러셀의 생성으로 이미지 파일을 DB상에 만들 경우 사용가능하다.
		InterProductDAO pdao = new ProductDAO(); DAO 객체 생성
		
		List<ImageVO> imgList = pdao.ImageSelectAll();
		
		request.setAttribute("imgList", imgList);
		*/
		
		InterProductDAO pdao = new ProductDAO(); // DAO 객체 생성
		
		List<ProductVO> searchList = pdao.searchItems();
		
		request.setAttribute("searchList", searchList);
		
		setRedirect(false);
		setViewPage("/WEB-INF/search/search1.jsp");
		
//		String pdcategory_fk = request.getParameter("pdcategory_fk");
//		String keyword = request.getParameter("keyword");
//		String gender = request.getParameter("gender");

//		Map<String, String> paraMap = new HashMap<>();
		
//		 String sql = "select pdno, pdname, pdcategory_fk, pdimage1, pdimage2, price, saleprice, pdinputdate, pdgender "+
//				 "from tbl_product "+
//				 "where pdcategory_fk in 1 and pdgender in (1,2) and pdname like '%%' "+
//				 "order by saleprice";
		

	}
	
}




