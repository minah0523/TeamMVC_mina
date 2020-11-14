<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String ctxPath = request.getContextPath();
	//			/TeamMVC
%>
<style>
	#My_Title{
		color:#526B8E; /*#002266*/
		width: 70px;
		padding: 15px
		font-size: 15pt;
		margin: 30px;
		height: 30px;
		border-bottom: solid 3px #e3e3e3;
		letter-spacing: 4px;
	}
	
	#Catagorys {
		/*color: #939393;*/
	}
	
	ul, li, #Catagorys > ul {
		list-style-type: none;		
	}
	
	#Catagorys > ul >li {
		display: inline-block;
		margin-left: 15px;
		width: 100px;
		height: 30px;
		background-color: #C1AA92;
		padding-top: 5px;	
	}
	
	#Catagorys > ul >li > a {
		text-align: center;
	}
	
	div.productImg > img {
	   width: 100%;
	   height: 50%;
       position: relative;
       margin: 0 0 15px;
       text-align: center;
       overflow: hidden;
	} 
	
   div.col-md-3{
       margin-bottom: 50px ;
   }	
	
</style>

<jsp:include page="../header.jsp" />

<br><br>

<!-- == Carousel 예제 == -->
<div class="container" align="center"> 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="<%= ctxPath %>/images/1/1_1.PNG" style="width:100%; height:85%">
      </div>

      <div class="item">
        <img src="<%= ctxPath %>/images/4/4_1.PNG" style="width:100%; height:85%">
      </div>
      
      <div class="item">
        <img src="<%= ctxPath %>/images/8/8_1.PNG" style="width:100%; height:85%">
      </div>
      
      <div class="item">
        <img src="<%= ctxPath %>/images/12/12_1.PNG" style="width:100%; height:85%">
      </div>
      
      <div class="item">
        <img src="<%= ctxPath %>/images/16/16_1.PNG" style="width:100%; height:85%">
      </div>                  


    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>



<div id = "My_Title">
	OUTER
</div>


<%-- 카테고리 --%>
<div id = "Catagorys">
	<ul>
		<li>
			<a style = "color:white;" href = "<%= ctxPath %>/TeamHomePage.up">전체</a>
		</li>
		<li>
			<a style = "color:white;" href = "">코트</a>
		</li>
		<li>
			<a style = "color:white;" href = "">자켓</a>
		</li>
		<li>
			<a style = "color:white;" href = "">점퍼</a>
		</li>
		<li>
			<a style = "color:white;" href = "">무스탕</a>
		</li>
		<li>
			<a style = "color:white;" href = "">가디건</a>
		</li>
	</ul>
</div>

<br><br>

<%-- 아이템 리스트 --%>
<div id = "ItemLists">
	<ul id = "itemList1">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/1/1_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList2">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/2/2_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList3">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/3/3_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList4">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/4/4_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList5">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/5/5_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList6">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/6/6_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList7">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/7/7_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList8">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/8/8_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList9">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/9/9_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList10">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/10/10_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList11">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/11/11_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList12">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/12/12_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList13">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/13/13_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList14">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/14/14_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
						
	<ul id = "itemList15">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/15/15_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList16">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/16/16_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList17">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/17/17_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList18">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/18/18_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList19">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/19/19_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	<ul id = "itemList20">
		<li>
			<div class = "col-md-3">
				<div class = "productImg">
					<img src = "<%= ctxPath %>/images/20/20_2.PNG" />
				</div>
				<div class = "discription">
					<p class = "pName"><a>log handmade coat</a> 
					<ul>
						<li rel="판매가"><span style="font-size:12px">200,000원</span></li>
						<li><span>그레이, 베이지, 블랙</span></li>
					</ul>
				</div>
			</div>
		</li>
	</ul>
							
	
									
</div>



<jsp:include page="../footer.jsp" />