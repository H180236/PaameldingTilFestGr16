<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List, no.hvl.dat104.modell.Deltaker"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table border="1">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
		</tr>
		<c:forEach items="${deltakere}" var="deltaker">


			<tr>
			<c:set var = "brukernavn" scope = "session" value = "${brukernavn}"/>
			<c:set var = "betalt" value = "${deltaker.betalingsstatus}"/>
				<c:choose>
					<c:when test="${deltaker.kjonn.equals('M')}">
						<td align="center">&#9794;</td>
					</c:when>
					<c:otherwise>
						<td align="center">&#9792;</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
				
					<c:when test="${deltaker.telefonnummer.equals(brukernavn) && !betalt }">
						<td style="background-color:red">${deltaker.fornavn} ${deltaker.etternavn}</td>
					</c:when>
					<c:when test="${deltaker.telefonnummer.equals(brukernavn) && betalt }">
						<td style="background-color:green">${deltaker.fornavn} ${deltaker.etternavn}</td>
					</c:when>
					
					<c:otherwise>
						<td>${deltaker.fornavn} ${deltaker.etternavn}</td>
					</c:otherwise>
				</c:choose>
				
			</tr>




		</c:forEach>
	</table>
	<p>
		<a href="LoggUtServlet">Ferdig</a>
	</p>
</body>
</html>