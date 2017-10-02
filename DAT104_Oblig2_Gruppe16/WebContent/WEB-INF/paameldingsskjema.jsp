<%@ page import="static no.hvl.dat104.hjelpeklasser.UrlMappings.PAAMELDING_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<form action="paamelding" method="post">
  <fieldset>
    <legend>Personlige data</legend>
    <p>Fornavn: <input type="text" name="fornavn" /></p>
    <p>Etternavn: <input type="text" name="etternavn"" /></p>
    <p>Mobil (8 siffer): <input type="text" name="mobil"/></p>
    <p>Kjønn: <input type="radio" name="kjonn" value="M" checked="checked" />mann
        <input type="radio" name="kjonn" value="F" />kvinne</p>
    <p><input type="submit" value="Meld meg på" /></p>
  </fieldset>
</form>
<a href="login">Allerede påmeldt? Trykk her for å logge inn</a>
</body>
</html>