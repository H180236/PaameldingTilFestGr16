<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ page import="java.util.List, no.hvl.dat104.modell.Deltaker" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�meldingsbekreftelse</title>
</head>
<body>
<h2>P�meldingsbekreftelse</h2>
<p>P�meldingen er mottatt for</p>
<p>&nbsp;&nbsp;&nbsp;${Deltaker.fornavn}<br/>
&nbsp;&nbsp;&nbsp;${Deltaker.etternavn}<br/>
&nbsp;&nbsp;&nbsp;${Deltaker.telefonnummer}<br/>
<c:if test = "${Deltaker.kjonn.equals('M')}">
       &nbsp;&nbsp;&nbsp;Mann<br/>
      </c:if>
<c:if test = "${Deltaker.kjonn.equals('F')}">
       &nbsp;&nbsp;&nbsp;Kvinne<br/>
      </c:if>      

</p>
<p><b>NB! Husk � betale til kassereren f�r festen!</b></p>
<a href="deltakere">G� til deltagerlisten</a>
</body>
</html>