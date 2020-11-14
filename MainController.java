package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends AbstractController {

	@Override
	public String toString() {
		return "### : 클래스 MainController의 인스턴스 메소드 toString() 호출";
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//System.out.println("### 확인용 MainController의 메소드 execute호출됨");
		
		super.setRedirect(true); // 데이터 전송억제
		super.setViewPage("index.up");
		// 데이터를 전송할 필요가 없으니 바로 페이지 url을 작성하면된다.
	}

}




