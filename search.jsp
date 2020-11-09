<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String ctxPath = request.getContextPath();
	//			/TeamMVC
%>
<style>
	div#Menu_Items{
		visibility:hidden;
	}
	div#contents{
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
	div.listBox{
		margin: 10px
		padding: 10%
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
		width: 100%;
	    position: relative;
	    margin: 0 0 15px;
	    text-align: center;
	    overflow: hidden;
	}	
	button#showMore{
		background-color: light-gray;
		color: gray; 
		margin: 10px auto;
		
	}
	

</style>

<jsp:include page="../header.jsp" />

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
					<input id="keyword" name="keyword" placeholder size="15" value="코트" type="text">	
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
	
	<!-- 상품리스트 보여주는 부분 -->
	<div class="listBox">
		<ul class="productList">
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://s3.ap-northeast-2.amazonaws.com/products-represent-img/a346f3fbb35615913e9d09c267fe52e2?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트1</a></p>
						<ul>
						<!-- <li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li> -->
						<li rel="판매가"><span style="font-size:12px">230,000원</span></li>
						<span class="label label-primary">New</span></h6>
						</ul>
						
					</div>
				</div>
			</li>
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://static.lookpin.co.kr/20191023192005-3ec0/5152b0b224aed771ba15fa8b47746e11.jpg?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트2</a></p>
						<ul>
						<li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li>
						<li rel="판매가"><span style="font-size:12px">190,000원</span></li>
						</ul>
						
					</div>
				</div>
			</li>
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://s3.ap-northeast-2.amazonaws.com/products-represent-img/a346f3fbb35615913e9d09c267fe52e2?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트3</a></p>
						<ul>
						<li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li>
						<li rel="판매가"><span style="font-size:12px">190,000원</span></li>
						</ul>
						
					</div>
				</div>
			</li>
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://static.lookpin.co.kr/20200326154327-566a/bd68046cb72632faf3b7706c6105c9c2.jpg?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트4</a></p>
						<ul>
						<li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li>
						<li rel="판매가"><span style="font-size:12px">190,000원</span></li>
						</ul>
						
					</div>
				</div>
			</li>
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://s3.ap-northeast-2.amazonaws.com/products-represent-img/a346f3fbb35615913e9d09c267fe52e2?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트5</a></p>
						<ul>
						<li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li>
						<li rel="판매가"><span style="font-size:12px">190,000원</span></li>
						</ul>
						
					</div>
				</div>
			</li>
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://static.lookpin.co.kr/20191023192005-3ec0/5152b0b224aed771ba15fa8b47746e11.jpg?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트6</a></p>
						<ul>
						<li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li>
						<li rel="판매가"><span style="font-size:12px">190,000원</span></li>
						</ul>
						
					</div>
				</div>
			</li>
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://s3.ap-northeast-2.amazonaws.com/products-represent-img/a346f3fbb35615913e9d09c267fe52e2?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트7</a></p>
						<ul>
						<li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li>
						<li rel="판매가"><span style="font-size:12px">190,000원</span></li>
						</ul>
						
					</div>
				</div>
			</li>
			<li id="box">
				<div class="col-md-3">
					<div class="productImg">
						<img src="https://static.lookpin.co.kr/20200326154327-566a/bd68046cb72632faf3b7706c6105c9c2.jpg?resize=360" />
					</div>
					<div class="discription">
						<p class="name"><a>코트8</a></p>
						<ul>
						<li rel="정상가"><span style="font-size:11px; text-decoration:line-through;">238,000원</span></li>
						<li rel="판매가"><span style="font-size:12px">190,000원</span></li>
						</ul>
					</div>
				</div>
			</li>
		</ul>
		<button class="btn" id="showMore">더보기</button>
	</div>
	</div>
</div>

<jsp:include page="../footer.jsp" />