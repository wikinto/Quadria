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
		<input type="text" name="barcode" placeholder="Barcode"></input>
		<input type="submit" value="Beep!">
	</form>
	</body>
</html>