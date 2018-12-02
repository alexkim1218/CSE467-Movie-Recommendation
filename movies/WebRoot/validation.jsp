<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import = "com.movie.bean.Movie"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Result</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
	<table>
		<tbody>
			<tr>
				<th>index</th>
				<th>movie title</th>
				<th>plot</th>
			</tr>
			<c:forEach items="${movieList}" var="movie" varStatus="status">
    									<tr>
    										<td>${movie.index}</td>
    										<td>${movie.movie_title}</td>
    										<td>${movie.plot}</td>
    									</tr>
    		</c:forEach>
		</tbody>
	</table>
  </body>
</html>
