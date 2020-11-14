<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String ctxPath = request.getContextPath(); %>    

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/css/style.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
  <div class="slide">
    
      <div style="display: inline-block; float: left;"><img style= "width: 635px; height: 725px;" src = "<%= ctxPath %>/images2/Main_Man.jpg" /></div>
      <div style="display: inline-block; float: right;"><img style= "width: 635px; height: 725px;" src = "<%= ctxPath %>/images2/Main_Women.jpg" /></div>

  </div>
</body>
</html>