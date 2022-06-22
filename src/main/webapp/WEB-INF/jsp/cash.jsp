<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.webService.service.shopSection.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Kasa nr ${uid}</title>
</head>
<body>
<p>${barcode}</p>
	<form method="post" action="/getProduct">
	  <div class="row d-flex justify-content-center">
  	<div class="align-middle">
		<input type="text" name="barcode" id="barcode" placeholder="Barcode"></input>
		<input type="submit" class="btn btn-primary" value="Beep!">
		<div id="toPrint">
		<c:forEach var="i" items="${rach}">
			${i}		
		</c:forEach>
		</div>
		<c:if test="${bcerror!=null }">
		<p>${bcerror }</p>
		</c:if>
		<p>${total}</p>
		
		<a href="/paragon">Wydruk</a>
		</div>
		</div>
	</form>
	<div id="script">
	<script>document.getElementById("barcode").focus();document.getElementById("script").innerHTML=""</script>
	</div>
	</body>
</html>