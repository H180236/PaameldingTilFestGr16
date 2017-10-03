<%@ page
	import="static no.hvl.dat104.hjelpeklasser.UrlMappings.LOGIN_URL"%>
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ page session="false"%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>Logg inn</title>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="register-form">
				<h2>Logg inn</h2>
				<p>Det er kun registrerte deltagere som får se deltagerlisten.
					Logg inn ved å gi mobil-nummeret ditt.</p>
			</form>
			<form action="<%=LOGIN_URL%>" method="post">
				<fieldset>
					<legend>Login</legend>
					<p>
						Mobilnummer: <input type="password" name="telefonnummer" /> <input
							type="submit" value="Logg inn" />
					</p>
					<p><font color="red">
					<%
						if (null != request.getAttribute("errorMessage")) {
							out.println(request.getAttribute("errorMessage"));
						}
					%>
					</font></p>
					<p>
						<a href="paamelding"> Ikke påmeldt?</a>
					</p>
					<p>
						<a href="kasserer">Logge inn som kasserer?</a>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>