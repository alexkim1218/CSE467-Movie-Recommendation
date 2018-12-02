<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="./js/jquery-1.10.2.min.js"></script>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<title>Movie Recommend</title>
	<style type="text/css">
	body{background-color: #333;}
	.bg-div{position:cover;background-image: url(./image/river.jpg);width:1420px;height:810px;margin:center center;background-size:cover;}
	.logo{background-image: url(./image/logo.png0
	);height:53px;width: 107px; float: left;margin: -4px 18px 0 0;opacity:0.5}
	.search-form{float: left; background-color: #fff;padding:5px;}
	.search-text{height:25px;line-height: 25px;float: left;width: 350px;border: 0;outline: none;}
	.search-button{background-image: url(./image/search-button2.png);width:29px;height:29px;float: left;border: 0}
	.search-box{position:absolute;top:340px;left: 439px;}
	
	.suggest{width:388px;background-color:#fff;border:1px solid #999;}
	.suggest ul{list-style:none;margin: 0;padding:0;}
	.suggest ul li{padding:3px;font-size:14px;line-height:25px;cursor:pointer;}
	.suggest ul li:hover{text-decoration:underline;background-color:#e5e5e5}
	</style>
</head>

<body>

 <div class="bg-div">
 	<div class="search-box">
 	<div class="logo"></div>
 	
	 	<form class="search-form" action="<%=basePath%>Movie.action" method = "post">
	 		<input type="text" class="search-text" name="search_text" id="search_input" value = "${search_text}"/>
	 		<input type="submit" class="search-button" value=""/>
	 	</form>
 	</div>
 </div>
<script>

 $('#search_input'),bind('keyup',function(){
	 var searchText=$('#search_input').val();
	 $.get('http://api.bing.com/qsonhs.aspx?q=')
	 $('#search-suggest').css({
		 top:$('#search-form').offset().top+$('#search-form').height()+10,
		 left:$('#search-form').offset().left
	 }).show();	 
 })
 </script>

</body>
</html>
