<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
	<div class="login-page">
		<div class="form">

			<h2>Kasserer login</h2>
			<form action="kasserer" method="post">
				<fieldset>
					<legend>Kasserer login</legend>
					<p>
						Passord: <input type="password" name="telefonnummer" /> <font
							color="red"> <%
 	if (null != request.getAttribute("errorMessage")) {
 		out.println(request.getAttribute("errorMessage"));
 	}
 %>
						</font>

					</p>

					<input type="submit" value="Logg inn" />

					<p>
						<a href="login">Tilbake til login som deltaker</a>
					</p>
				</fieldset>
			</form>

		</div>
	</div>
</body>
</html>