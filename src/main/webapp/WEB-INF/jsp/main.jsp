<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Strona Główna</title>
<link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>

<body>
	<form method="post" action="/login">
		<input type="text" name="uid" placeholder="ID Kasy Fiskalnej"></input>
		<input type="password" name="upass" placeholder="Hasło dostępu"></input>
		<input type="submit" value="Zaloguj się">
	</form>
		<p>${loginerror}</p>
</body>

</html>