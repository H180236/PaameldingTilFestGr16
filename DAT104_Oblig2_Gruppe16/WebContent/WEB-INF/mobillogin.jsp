<%@ page
	import="static no.hvl.dat104.hjelpeklasser.UrlMappings.LOGIN_URL"%>
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>Logg inn</title>
</head>
<body>
<p>${ingenDeltaker}</p>
	<div class="login-page">
		<div class="form">

			<h2>Logg inn</h2>
			<p>Det er kun registrerte deltagere som får se deltagerlisten.
				Logg inn ved å gi mobil-nummeret ditt.</p>

			<form action="<%=LOGIN_URL%>" method="post">
				<fieldset>
					<legend>Login</legend>
					
					
					<p>
						Mobilnummer: <input type="password" name="telefonnummer" />
						<c:out value="${sessionScope.ingenDeltaker}"/>

						<br>
						

					</p>

					<input type="submit" value="Logg inn" />


					<p>
						<a href="paamelding"> Ikke påmeldt?</a>
					</p>
					<p>
						<a href="kasserer">Logge inn som kasserer?</a>
					</p>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>