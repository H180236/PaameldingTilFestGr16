<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List, no.hvl.dat104.modell.Deltaker"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Betalingsoversikt</title>
</head>
<body>
	<h2>Betalingsoversikt</h2>
	<form action = "betaling" method = "post">
		<table border="1">
		<c:forEach items="${deltakere}" var="deltaker">
			
			<tr>
				<td>${deltaker.fornavn} ${deltaker.etternavn}</td>
				<c:set value= "${deltaker.telefonnummer}" var="tlfnr"/>
				<td>
				<c:out value="${fn:substring(tlfnr, 0, 3)} ${fn:substring(tlfnr, 3, 5)} ${fn:substring(tlfnr, 5, 8)}"/>
				</td>
				<c:choose>
				
				<c:when test="${deltaker.betalingsstatus}">
				<td align="center">Betaling mottatt</td>
				</c:when>
				<c:otherwise>
						<td><input type="hidden" name="telefonnummer" value="${deltaker.telefonnummer}">
        <input type="submit" value="Registrer betaling">
					</c:otherwise>
				
				</c:choose>
				
			</tr>
			
			</c:forEach>
			
		
		</table>
	</form>
	<p>
		<a href="logout">Ferdig</a>
	</p>
</body>
</html>