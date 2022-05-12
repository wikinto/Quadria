<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.webService.service.shopSection.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>${currentproductname} - Sklep</title>
</head>
<body>
	<img id="gallery" src="${currentproductname}"></img>
	<h1 id="title">${currentproductname}</h1>
	<p style="float:left" id="description">${currentproductdesc}</p>
	<p style="float:left" id="price">${currentproductprice}</p>
	<div id="content">
	
	</div>
</body>
</html>