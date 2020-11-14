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
      
      String pdgender = request.getParameter("pdgender");
      String pdcategory_fk = request.getParameter("pdcategory_fk");
      String searchname = request.getParameter("searchname");
      String sort = request.getParameter("sort");
      
      //성별, 품목, 검색키워드를 넣는다
      Map<String,String> paraMap = new HashMap<>();
      paraMap.put("pdgender", pdgender); 
      paraMap.put("pdcategory_fk", pdcategory_fk); 
      paraMap.put("searchname", searchname);
      paraMap.put("sort", sort);
      
      InterProductDAO pdao = new ProductDAO();
      
      List<ProductVO> searchProductList = pdao.searchProduct(paraMap);
      
      
      //제품별 컬러리스트를 String으로 변환하는 것
      for(ProductVO pvo : searchProductList) {
         
         List<String> colorList = pdao.selectProductColor(String.valueOf(pvo.getPdno())); 
         
         String colores = "";
         for(int i=0; i<colorList.size(); i++) {
            String comma = (i < colorList.size()-1)?",":"";
            colores += colorList.get(i)+comma;
         }
         
         pvo.setColores(colores);
      }
      
      //제품별 사이즈리스트를 String으로 변환하는 것
      for(ProductVO pvo : searchProductList) {
         
         List<String> sizeList = pdao.selectProductSize(String.valueOf(pvo.getPdno())); 
         
         String sizes = "";
         for(int i=0; i<sizeList.size(); i++) {
            String comma = (i < sizeList.size()-1)?",":"";
            sizes += sizeList.get(i)+comma;
         }
         
         pvo.setSizes(sizes);
      }
      
      request.setAttribute("pdgender", pdgender);
      
      request.setAttribute("searchProductList", searchProductList); 
      request.setAttribute("searchCount", searchProductList.size());
      
      request.setAttribute("pdcategory_fk", pdcategory_fk);
      request.setAttribute("searchname", searchname);
      
      request.setAttribute("sort", sort);
      
   //   super.setRedirect(false);
      super.setViewPage("/WEB-INF/search/search.jsp");
   }

}