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
<form action="LoginServlet" method="post"> 
  <fieldset>
    <legend>Login</legend>   
    <p>Mobilnummer: <input type = "password" name = "telefonnummer" /> </p>
    <p><input type="submit" value="Logg inn" /></p>
    <p> <a href = "PaameldingsServlet"> Ikke p�meldt?</a> </p>
  </fieldset>
</form>

</body>
</html>