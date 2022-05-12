<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Strona Główna</title>
</head>
<body>
	<form method="post" action="/login">
		<input type="text" name="uid" placeholder="ID Kasy Fiskalnej"></input>
		<input type="password" name="upass" placeholder="Haslo dostepu"></input>
		<input type="submit" value="Zaloguj się">
	</form>
	<c:if test="${war}">
		<p>${loginerror}</p>
	</c:if>
</body>
</html>