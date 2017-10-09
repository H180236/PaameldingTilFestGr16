<%@ page
	import="static no.hvl.dat104.hjelpeklasser.UrlMappings.PAAMELDING_URL"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>P�melding</title>
</head>
<body>
	<ul>
		<li><a href="login">Logg inn</a></li>
		<li><a href="paamelding">Meld deg p�</a></li>
		<li><a href="kasserer">Kasserer</a></li>
	</ul>
	<div class="login-page">
		<div class="form">
			<h2>P�melding</h2>
			<form action="paamelding" method="post">
				<fieldset>
					<legend>Personlige data</legend>
					<p>
						Fornavn: <input type="text" name="fornavn"
							value="${feilmelding.fornavn}" />
					</p>
					<p style="color: red">${feilmelding.fornavnFeilmld}</p>
					<p>
						Etternavn: <input type="text" name="etternavn"
							value="${feilmelding.etternavn}" />
					<p style="color: red">${feilmelding.etternavnFeilmld}</p>




					<p>
						Mobil (8 siffer): <input type="text" name="mobil"
							value="${feilmelding.telefonnr}" />
					<p style="color: red">${feilmelding.telefonnrFeilmld}</p>
					<p>
						Kj�nn: <input type="radio" id="kjonn" name="kjonn" value="M"
							checked="checked" /> mann <input type="radio" id="kjonn"
							name="kjonn" value="F" />kvinne
					</p>
					<p>
						<input type="submit" value="Meld meg p�" />
					</p>
				</fieldset>
			</form>

		</div>
	</div>
</body>
</html>