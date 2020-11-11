package search.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;
import myshop.model.*;


// search 페이지에 보여지는 상품이미지파일명을 모두 조회(select)하는 컨트롤러 (MINA)
public class SearchProductController extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pdcategory_fk = request.getParameter("pdcategory_fk");
		String searchname = request.getParameter("searchname");
		
		//
		Map<String,String> paraMap = new HashMap<>();
		paraMap.put("pdcategory_fk", pdcategory_fk); 
		paraMap.put("searchname", searchname);
		
		InterProductDAO pdao = new ProductDAO();
		
		List<ProductVO> searchProductList = pdao.searchProduct(paraMap);
		
		for(ProductVO pvo : searchProductList) {
			
			List<String> colorList = pdao.selectProductColor(String.valueOf(pvo.getPdno())); 
			
			String colores = "";
			for(int i=0; i<colorList.size(); i++) {
				String comma = (i < colorList.size()-1)?",":"";
				colores += colorList.get(i)+comma;
			}
			
			pvo.setColores(colores);
		}
		
		
		for(ProductVO pvo : searchProductList) {
			
			List<String> sizeList = pdao.selectProductSize(String.valueOf(pvo.getPdno())); 
			
			String sizes = "";
			for(int i=0; i<sizeList.size(); i++) {
				String comma = (i < sizeList.size()-1)?",":"";
				sizes += sizeList.get(i)+comma;
			}
			
			pvo.setSizes(sizes);
		}
		
		
		for(ProductVO pvo : searchProductList) {
			System.out.println(pvo.getPdname()+" => "+pvo.getColores());	
		}
		
		for(ProductVO pvo : searchProductList) {
			System.out.println(pvo.getPdname()+" => "+pvo.getSizes());	
		}
		
		
		request.setAttribute("searchProductList", searchProductList); 
		request.setAttribute("searchCount", searchProductList.size());
		
		request.setAttribute("pdcategory_fk", pdcategory_fk);
		request.setAttribute("searchname", searchname);
		
	//	super.setRedirect(false);
		super.setViewPage("/WEB-INF/search/search.jsp");
	}

}
