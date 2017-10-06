<%@ page
	import="static no.hvl.dat104.hjelpeklasser.UrlMappings.PAAMELDING_URL"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<h2>Påmelding</h2>
			<form action="paamelding" method="post">
				<fieldset>
					<legend>Personlige data</legend>
					<p>
						Fornavn: <font color="red"><input type="text" name="fornavn" value="${feilmelding.fornavn}" /> 
						${feilmelding.fornavnFeilmld}</font>
						
					</p>
					<p>
						Etternavn: <font color="red"><input type="text" name="etternavn" value="${feilmelding.etternavn}" />
						${feilmelding.etternavnFeilmld}</font>
					</p>
					<p>
						Mobil (8 siffer): <font color="red"><input type="text" name="mobil" value="${feilmelding.telefonnr}" />
						${feilmelding.telefonnrFeilmld}</font>
					</p>
					<p>
						Kjønn: <input type="radio"  id="kjonn" name="kjonn" value="M"
							checked="checked" />
							mann <input type="radio"  id="kjonn" name="kjonn"
							value="F" />kvinne
					</p>
					<p>
						<input type="submit" value="Meld meg på" />
					</p>
				</fieldset>
			</form>
			<a href="login">Allerede påmeldt? Trykk her for å logge inn</a>
</div>
</div>
</body>
</html>