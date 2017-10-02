<%@ page import="static no.hvl.dat104.hjelpeklasser.UrlMappings.LOGIN_URL" %>
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p>Det er kun registrerte deltagere som f�r se deltagerlisten.
Logg inn ved � gi mobil-nummeret ditt.</p>
<form action="<%= LOGIN_URL %>" method="post"> 
  <fieldset>
    <legend>Login</legend>   
    <p>Mobilnummer: <input type = "password" name = "telefonnummer" /> </p>
<p><font color="red"><%= request.getAttribute("errorMessage") %></font></p>
    <p><input type="submit" value="Logg inn" /></p>
    <p> <a href = "paamelding"> Ikke p�meldt?</a> </p>
    <p> <a href = "kasserer">Logge inn som kasserer?</a> 
  </fieldset>
</form>

</body>
</html>