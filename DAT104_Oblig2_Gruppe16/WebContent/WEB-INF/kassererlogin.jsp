<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
	<h2>Kasserer login</h2>
	<form action="kasserer" method="post">
		<fieldset>
			<legend>Kasserer login</legend>
			<p>
				Passord: <input type="password" name="telefonnummer" />
			<font color="red">
					<%
						if (null != request.getAttribute("errorMessage")) {
							out.println(request.getAttribute("errorMessage"));
						}
					%>
					</font>
					
			</p>
			<p>
				<input type="submit" value="Logg inn" />
			</p>
		</fieldset>
	</form>
	<p>
		<a href="login">Tilbake til login som deltaker</a>
	</p>
</body>
</html>