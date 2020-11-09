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
	
	#Catagorys > ul {
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
	
</style>

<jsp:include page="header.jsp" />

<%-- 
<div class="container">
 <div style="width: 70%; margin: 0 auto;">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
    
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="status.index"></li>
    
     
     <c:forEach items="${imgList}" varStatus="status">
     	<c:if test="${status.index == 0}">
     		<li data-target="#myCarousel" data-slide-to="${status.index}" class="active"></li>
     	</c:if>
     	<c:if test="${status.index > 0}">
     		<li data-target="#myCarousel" data-slide-to="${status.index}"></li>
     	</c:if>
     </c:forEach>
     
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <c:forEach var="imgvo" items="${imgList}" varStatus="status">
     	<c:if test="${status.index == 0}">
     		<div class="item active">
        		<img src="<%= ctxPath%>/images/${imgvo.imgfilename}" style="width:100%;">
      		</div>
     	</c:if>
     	<c:if test="${status.index > 0}">
     		<div class="item">
        		<img src="<%= ctxPath%>/images/${imgvo.imgfilename}" style="width:100%;">
      		</div>
     	</c:if>
     </c:forEach>
      
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
</div>
--%> 


<div id = "My_Title">
	OUTER
</div>



<div id = "Catagorys">
	<ul>
		<li>
			<a style = "color:white;" href = "">전체</a>
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


<jsp:include page="footer.jsp" />