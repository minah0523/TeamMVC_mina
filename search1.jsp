<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String ctxPath = request.getContextPath();
	//			/TeamMVC
%>

<jsp:include page="../header.jsp" />

<style>
	div#Menu_Items{
		visibility:hidden;
	}
	div#contents{
		width: 95%;
		text-decoration: gray;
	}
	div.titleArea{
		margin: 50px 0 50px;
		color: #526B8E;
	    width: 180px;
	    padding: 15px font-size: 17pt;
	    margin: 30px;
	    height: 30px;
	    border-bottom: solid 3px #e3e3e3;
	    letter-spacing: 4px;
	}
	div.searchBox{
		width: 50%;
		margin: 40px;
		padding: 40px;
		border: 1px solid #e5e5e5;
		color: #353535;
		font-size: 11pt;
	}
	fieldset{
	    width: 60%;
    	margin: 0 auto;
    	padding: 0 47px;
	}
	label{
		float: left;
  		clear: left;
    	padding: 5px 10px 0 0;
    	text-align: left;
		margin: 0 0 10px 0;
	}
	label#category{
		letter-spacing: 3px;
	}
	label#keyword{
		letter-spacing: 2px;
	}
	select#category{
		width: 70%;
		margin: 0 0 10px 0;
		float: right;		
	}
	input#keyword{
		width: 70%;
		margin: 0 0 10px 0;
		float: right;
	}
	button#search{
		background-color: gray;
		margin: 10px 0;
		color: white; 
	}
	
	ul.orderBy{
		font-size: 10pt;
		text-align: right;
		padding: 10px;
	}
	ul.orderBy>li{
		padding: 0 10px 0 0 ;
		display: inline;
	}
	
	ul{
		padding-inline-start: 0px;
    	list-style-type: none;
	}
	ul.productList>li#box{
	    display: block;
	}
	div.col-md-3{
	    margin: 0 0 50px;
	}
	div.item{
		margin: 8px 0 0;
    	color: #353535;
    	line-height: 20px;
	}
	img{
		width: 280px;
		height: 350px;
	    position: relative;
	    margin: 0 0 15px;
	    text-align: center;
	    overflow: hidden;
	}	
	button#showMore{
		background-color: light-gray;
		color: gray; 
		margin: 0 auto;
	}
	

</style>

<script type="text/javascript">

   $(document).ready(function(){
	   
	   	var pdcategory_fk = null;
	   	var keyword = null;
	   	
	    $("#category").click(function(){
	    	//$("#셀렉트ID option:selected").val();
			pdcategory_fk = $("#category option:selected").val();
	    });
	    
	    
		$("button#search").click(function(){
			keyword = $('#keyword').val();
			alert("선택된 카테고리 value : "+ pdcategory_fk);
			alert("선택된 키워드 value: "+ keyword);
	    	
	    });
		
		//function searchProductList();
			
		
   }); // end of $(document).ready()------------------------
	

	
/* 	function searchProductList() {
		$.ajax({
			url:"/search/SearchPage2.neige",
			// GET or POST
			type:"GET",
			//서버로 데이터를 전송할 때 이 옵션을 사용한다.
			// $('form').serialize()를 쓸경우 선택된 데이터들을 텍스트타입으로 바꿔줌.
			data:{"pdcategory_fk": pdcategory_fk
				, "keyword": keyword},
			//서버측에서 전송한 데이터를 어떤 형식의 데이터로 해석할 것인가를 지정한다. ( xml, json, script, html )
			dataType:'json',
			//성공했을 때 호출할 콜백을 지정한다.
			success:function(json){
				html = "<div>";
				<span>selectedNum: ${selectedNum}</span>
				$("div#resultDisplay").html(html);
			},
			error:function(){}
		}); 
	} */
   
</script>


<%-- 검색 디스플레이 --%>
<div id="contents">
	<div class="titleArea">SEARCH ITEMS</div>
	<div class="searchBox">
	<fieldset>
		<div class="item">
			<div class="category">
				<div class="form-group">
					<label for="category">카테고리</label>
					<select id="category" name="category">
						<option value="0">전체</option>
						<option value="1">코트</option>
						<option value="2">자켓</option>
						<option value="3">점퍼</option>
						<option value="4">무스탕</option>
						<option value="5">가디건</option>
					</select>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="keyword">
				<div class="form-group">
					<label for="keyword">검색 키워드</label>
					<input id="keyword" name="keyword" type="text">	
				</div>
			</div>
		</div>
		<div>
			<button type="button" class="btn btn-block" id="search">검색</button>
		</div>
	</fieldset>
	</div>
	
<!-- 검색된 정보 및 상품리스트 -->
<div id="cateProductList">

	<!-- 검색 결과 개수 -->
	<div class="searchResult">
		<p class="record">총 <strong>8</strong>개의 상품이 검색되었습니다.</p>
	</div>
	
	<!-- 정렬 순서 -->
	<div class="orderBy">
		<ul class="orderBy">
			<li><a>신상품순</a></li>
			<li><a>인기상품순</a></li>
			<li><a>낮은가격순</a></li>
		</ul>
	</div>
	
	<%-- 상품리스트 보여주는 부분 
		이부분이 div만 남기고 나머지 로직은 ajax 함수로 만들어야 함.(MINA)
	--%>
	<div id="resultDisplay">
	   <ul class="productList"> 
	     <c:forEach var="searchvo" items="${searchList}" varStatus="status" >
	      <li id="box">
	         <div class = "col-md-3">
	            <div class = "productImg">
	            	<span>${searchvo.pdimage1}</span>
	                <img src ="<%= ctxPath %>/images/${searchvo.pdimage1}" /> 
	            </div>
	            <div class = "discription">
	               <p class = "name">${searchvo.pdname}</p> 
	               <ul>
	               	  <li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">정상가: ${searchvo.price}</span></li>
	                  <li rel="판매가"><span style="font-size:12px">판매가: ${searchvo.saleprice}</span></li>
	               </ul>
	            </div>
	         </div>
	      </li>
	     </c:forEach>
	   </ul>
	</div>
	
	<button class="btn" id="showMore">더보기</button>
</div>
</div>

<jsp:include page="../footer.jsp" />