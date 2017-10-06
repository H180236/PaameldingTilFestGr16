<%@ page
	import="static no.hvl.dat104.hjelpeklasser.UrlMappings.LOGIN_URL"%>
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>Logg inn</title>
</head>
<body>
	<ul>
		<li><a href="login">Logg inn</a></li>
		<li><a href="paamelding">Meld deg på</a></li>
		<li><a href="kasserer">Kasserer</a></li>
	</ul>
	<div class="login-page">
		<div class="form">

			<h2>Logg inn</h2>
			<p>Det er kun registrerte deltagere som får se deltagerlisten.
				Logg inn ved å gi mobil-nummeret ditt.</p>

			<form action="<%=LOGIN_URL%>" method="post">
				<fieldset>
					<legend>Login</legend>

					<p>
						Mobilnummer: <input type="password" name="mobil" /> <br>
					</p>
					<p style="color: red">${ingenDeltaker}</p>

					<input type="submit" value="Logg inn" />

				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>