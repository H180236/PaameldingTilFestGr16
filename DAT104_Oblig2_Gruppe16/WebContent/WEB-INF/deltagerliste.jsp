<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List, no.hvl.dat104.modell.Deltaker"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>

	<body>
<div class="table-title">
<h3>Deltakerliste</h3>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">Kjønn</th>
<th class="text-left">Navn</th>
</tr>
</thead>
<tbody class="table-hover">
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
						<td style="background-color:#ff6633">${deltaker.fornavn} ${deltaker.etternavn}</td>
					</c:when>
					<c:when test="${deltaker.telefonnummer.equals(brukernavn) && betalt }">
						<td style="background-color:#cbffb3">${deltaker.fornavn} ${deltaker.etternavn}</td>
					</c:when>
					
					<c:otherwise>
						<td>${deltaker.fornavn} ${deltaker.etternavn}</td>
					</c:otherwise>
				</c:choose>
				
			</tr>




		</c:forEach>
</tbody>
</table>
	<a href="logout"><button class = "button">Logg ut</button></a>
</body>
</html>