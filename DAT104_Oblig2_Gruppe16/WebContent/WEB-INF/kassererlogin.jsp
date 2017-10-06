<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
<ul>
  <li><a href="login">Logg inn</a></li>
  <li><a href="paamelding">Meld deg på</a></li>
  <li><a href="kasserer">Kasserer</a></li>
</ul>
	<div class="login-page">
		<div class="form">

			<h2>Kasserer login</h2>
			<form action="kasserer" method="post">
				<fieldset>
					<legend>Kasserer login</legend>
					<p>
						Passord: <input type="password" name="telefonnummer" />

					</p>
					<p style = "color:red"> ${feilMelding}</p>

					<input type="submit" value="Logg inn" />

				</fieldset>
			</form>

		</div>
	</div>
</body>
</html>