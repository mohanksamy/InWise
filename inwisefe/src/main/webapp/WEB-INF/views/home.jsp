<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<head>
	<title>Inwise - Home</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />
</head>

<body class="wnav">
	<%@ include file="header.jsf" %>
	<%@ include file="left_side_navbar.jsf"%>

	<h1>Health Controller is up!</h1>

	<P> Now time is ${serverTime}. </P>
</body>

</html>