package search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import common.controller.AbstractController;
import myshop.model.InterProductDAO;
import myshop.model.ProductDAO;
import myshop.model.ProductVO;

public class SearchController2 extends AbstractController {

	@Override
	public String toString() {
		return "@@@ : 클래스 IndexController의 인스턴스 메소드 toString() 호출";
	}

	@Override // MINA
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


		// view 단의 Ajax - data에서 가져온 데이터
		String pdcategory_fk = request.getParameter("pdcategory_fk");
		String keyword = request.getParameter("keyword");

		if (pdcategory_fk == null || pdcategory_fk.trim().isEmpty() || pdcategory_fk == "0") {
			pdcategory_fk = "0";
		}

		if (keyword == null || keyword.trim().isEmpty()) {
			keyword = "";
		}

		InterProductDAO pdao = new ProductDAO();

		HashMap<String, String> paraMap = new HashMap<String, String>();

		paraMap.put("pdcategory_fk", pdcategory_fk);
		paraMap.put("keyword", keyword);

		List<ProductVO> productList = pdao.searchItems(paraMap);

		JSONArray jsonArr = new JSONArray(); // [{}, {}, {}] - 자바스크립트에서 사용하는 객체 표현방식
		
		// DB에서 읽어온 productList이 null 이 아니라면 (nullpointException이 안떨어지려면)
		if (productList != null) {
			for (ProductVO pvo : productList) {
				
				JSONObject jsobj = new JSONObject();
				// JSONObject는 JSON 형태 {키:값}의 데이터로 만들어주는 것
				jsobj.put("pdno", pvo.getPdno());
				jsobj.put("pdname", pvo.getPdname());
				jsobj.put("pdcategory_fk", pvo.getPdcategory_fk());
				jsobj.put("pdimage1", pvo.getPdimage1());
				jsobj.put("pdimage2", pvo.getPdimage2());
				jsobj.put("price", pvo.getPrice());
				jsobj.put("saleprice", pvo.getSaleprice());
				jsobj.put("pdgender", pvo.getPdgender());
				
				jsonArr.put(jsobj);
			
			}//end of for---------------------------------------------
		
		}// end of if--------------------------
		
		String result = jsonArr.toString();

		request.setAttribute("productList", productList); //jsp에 보내준다
		  
		super.setRedirect(false); 
		  
		setViewPage("/WEB-INF/search/search2.jsp");
		  

	}

}
