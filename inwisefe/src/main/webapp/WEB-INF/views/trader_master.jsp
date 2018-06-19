<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.util.*"%>
<%@ page import="com.prod.inwise.dto.TraderDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Verion 1.0 - Trader Master</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	List<TraderDTO> stores = (List<TraderDTO>) request.getAttribute(AttributeConstants.TRADER_LIST);
	pageContext.setAttribute("dtos", stores);
%>
</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">
<%@ include file="header.jsf" %>

.<%@ include file="left_side_navbar.jsf"%>	
	<nobr>
		<div class="boxheader">
			<span>Traders</span>
		</div>
	</nobr>

	<table width="100%" border="0">
		<tr>
			<td colspan="9" valign="top">
<!-- 				<a href="addStore"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a>  -->
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
		<tr>
			<td>
				<table id="fixed_header_table" cellspacing="0"
					class="datatable striped">
					<thead>
						<tr>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">Trader Name</th>
							<th class="column-name">Code</th>
							<th class="column-name">UIN</th>
							<th class="column-name">Phone #</th>
							<th class="column-name">City</th>
							<th class="column-name">State</th>
							<th class="column-name">PostalCode</th>
						</tr>
					</thead>
					<tbody>
				 	<c:forEach var="trader" items="traders">
						<tr>
							<td><a class="td-link" href="editTrader">view/Edit</a></td>
							<td><c:out value="${trader.name}" /></td>
							<td><c:out value="${trader.code}" /></td>
							<td><c:out value="${trader.uin}" /></td>
							<td><c:out value="${trader.phone}" /></td>
							<td><c:out value="${trader.city}" /></td>
							<td><c:out value="${trader.state}" /></td>
							<td><c:out value="${trader.postalCode}" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
				<a href="addTrader"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a> 
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
	</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>