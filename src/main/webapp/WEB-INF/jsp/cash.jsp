<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.webService.service.shopSection.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Kasa nr ${uid}</title>
</head>
<body>
<p>${barcode}</p>
	<form method="post" action="/getProduct">
		<input type="text" name="barcode" id="barcode" placeholder="Barcode"></input>
		<input type="submit" value="Beep!">
		<div id="toPrint">
		<c:forEach var="i" items="${rach}">
			${i}		
		</c:forEach>
		</div>
		<c:if test="${bcerror!=null }">
		<p>${bcerror }</p>
		</c:if>
		<p>${total}</p>
	</form>
	<a href="/paragon">Wydruk</a>
	<div id="script">
	<script>document.getElementById("barcode").focus();document.getElementById("script").innerHTML=""</script>
	</div>
	</body>
</html>