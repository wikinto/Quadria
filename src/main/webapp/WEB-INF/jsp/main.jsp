<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Strona Główna</title>
<link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>

<body>
	<form method="post" action="/login">
  <div class="row d-flex justify-content-center">
  	<div class="align-middle">
		<input type="text" name="uid" placeholder="ID Kasy Fiskalnej"></input>
		<input type="password" name="upass" placeholder="Hasło dostępu"></input>
		<input type="submit" class="btn btn-primary" value="Zaloguj się"></input>
		</div>
		</div>
	</form>
		<c:if test="${loginerror==true }">
			<p>Błędny login i/lub hasło</p>
		</c:if>
</body>

</html>