<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ctxPath = request.getContextPath();
    //    /TeamMVC
%>
<!DOCTYPE html>
<html>
<head>

<title>:::HOMEPAGE:::</title>
 
<style type="text/css">
	
	html, #body {
		width: 100%;
		height: 100%;
		padding : 0;
		margin : 0;
		overflow-x: hidden; 
		/* 가로 바 안보이게 지정 */
	}

	div#headerImg{
		/* background-color: black; */
		background-color: #F8ECDE;
	}
	
	#Sist_Logo {
		margin-left: 150px;
		width: 100px;
		height: 40px;
		cursor: pointer;
	}
	
	#Sist_Logo > a{
		margin-left: 50px;
		/*color: white;*/
		color: black;
		font-size: 16pt;
		font-weight: bold;
	}	
	
	#Gender_Category > a{
		margin-left: 50px;
		color: black;
		font-weight: bold;
		font-size: 16pt;
	}
	
	#Sist_Logo > a:hover, #Gender_Category > a:hover {
		color: #E9462B;
		font-weight: bold;
		border-bottom: 3px solid white;
		border-bottom-color: #E9462B;
		padding-bottom: 9px;
	}
	
	#Cart {
		margin-left : 80px;
	}	
	
	#Main_Search_Input {
		border-color: gray;
		width: 250px;
		height: 30px;
		background-image: url("/TeamMVC/images/icon_search.png");
		background-size: 30px 30px;
		background-position: 200px;
		background-repeat: no-repeat;
		border-radius: 30px;
	}
	
	/* input 박스를 클릭 했을떄 나오는 테두리 색상 없애기 */
	#Main_Search_Button:focus, #Main_Search_Input:focus {
		outline: none;
	}

	
	#Login_MyInfo_Cart > a{
		color : black;
		font-size : 11pt;
	}
	
	#Login_MyInfo_Cart > a:hover{
		font-weight: bold;
		border-bottom: 3px solid white;
		border-bottom-color: #E9462B;
		padding-bottom: 15px;
	}
	
	#First_Menu {
		margin-left: 220px;
		width: 100px;
	}
	
	.MainMenu {
		height: 45px;
		margin-top: 15px;
	} 
	
	 #Menu_Items > a:visited{
		color: black;
	}
	
	#contents {
		width: 100%;
		height: 100%;
	}
	
	.delimiter {
		color:white;
	}
	
	#Login_MyInfo_Cart > a.delimiter:hover {
		border-bottom-color: black;
		color:white;
	}
	

</style>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/css/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/jquery-ui-1.11.4.custom/jquery-ui.css" />
<script type="text/javascript" src="<%= ctxPath%>/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		var vhtml = "";
		for(var i=0; i<15; i++) {
			vhtml += (i+1)+".내용물<br/>";
		}
		
		$("#sideconent").html(vhtml);
		
	});

</script>

</head>
<body id = "body">

<div id = "container">

	<div id="headerImg">
		<div class="row MainRow">
			<div class="col-md-3" id = "Sist_Logo"><a href="<%= ctxPath %>/index.up">NEIGE</a></div>
			<div class="col-md-3" id="Gender_Category"><a href="<%= ctxPath %>/gender/manMain.up">MEN</a><a href="<%= ctxPath %>/gender/womenMain.up">WOMEN</a></div>
			<div class="col-md-3"></div>
			<div class="col-md-3" id="Login_MyInfo_Cart"><a id = "Cart" href="<%= ctxPath %>/product/productCart.up" >장바구니 </a> <a class= "delimiter" >|</a>
								  						 <a href="<%= ctxPath %>/member/myPage.up">내정보 </a>  <a class= "delimiter">|</a>
								  						 <a href="<%= ctxPath %>/member/memgerRegister.up">회원가입 </a> <a class= "delimiter" >|</a>
								  						 <a href="<%= ctxPath %>/login/login.up">로그인</a>
            </div>
		</div>
	</div>
	
	<div id="headerMenuBar">
		<div id = "Menu_Items" class="row MainMenu">		
			<div id = "First_Menu" class="col-md-2">
				<a style= 'color: black;' href="<%= ctxPath %>/product/productBestList.up">상품랭킹</a>
			</div>			
			<div class="col-md-2">
				<a style= 'color: black;' href="<%= ctxPath %>/product/newProductList.up">신상품</a>
			</div>
			<div class="col-md-4">
				<input type="text" placeholder="&nbsp;&nbsp;Search " name="Main_Search_Input" id="Main_Search_Input" />
				<button type="button" id="Main_Search_Button"
						style =  "background-color: gray; border: none; color:#fff;
							      text-align: center; text-decoration: none; padding: 5px;
							      display: inline-block; font-size: 16px; cursor: pointer;
							      border-radius: 5px;"
						onclick = "goProductSearch();">검색</button>
			</div>
		</div>
	</div>
	
	<div id="contents" align="center">
	
	<%-- <c:if test="${sessionScope.loginuser != null}"> 로그인이 되어진 상태라면
				<div class="col-md-1">
					<a href="<%= ctxPath %>/member/memberList.jsp">메뉴</a> 
				</div>
			</c:if> --%>