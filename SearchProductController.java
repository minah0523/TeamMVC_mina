package search.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;
import myshop.model.*;

public class SearchProductController extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pdcategory_fk = request.getParameter("pdcategory_fk");
		String searchname = request.getParameter("searchname");
		
		Map<String,String> paraMap = new HashMap<>();
		paraMap.put("pdcategory_fk", pdcategory_fk);
		paraMap.put("searchname", searchname);
		
		InterProductDAO pdao = new ProductDAO();
		
		List<ProductVO> searchProductList = pdao.searchProduct(paraMap);
		
		request.setAttribute("searchProductList", searchProductList); 
		
		request.setAttribute("pdcategory_fk", pdcategory_fk);
		request.setAttribute("searchname", searchname);
		
	//	super.setRedirect(false);
		super.setViewPage("/WEB-INF/search/search2.jsp");
	}

}
