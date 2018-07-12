<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.util.*"%>
<%@ page import="com.prod.inwise.dto.TraderDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>
<%@ page import="com.prod.inwise.fe.utilities.RequestConstants"%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Version 1.0 - Trader Master</title>

<%@ include file="header_include.jsf" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/default.css" />"  />

<%
	List<TraderDTO> traderList = (List<TraderDTO>) request.getAttribute(AttributeConstants.TRADER_LIST);
//	pageContext.setAttribute("dtos", stores);
%>
<script>
function editTrader(traderName) {
	alert("traderName :: " + traderName);
	document.master_form.<%= AttributeConstants.REQUEST_ID %>.value = "<%= RequestConstants.EDIT_TRADER %>";
	document.master_form.<%= AttributeConstants.NAME %>.value = traderName;
	document.master_form.submit();
}

</script>
</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>

<form action="" method="post" name="master_form" accept-charset="UTF-8">
	<nobr>
		<div class="boxheader">
			<span>Traders</span>
		</div>
	</nobr>
	<table width="100%" border="0">
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
				 	<% for(TraderDTO traderDto : traderList) { 
				 		pageContext.setAttribute("trader", traderDto);
				 	%>
						<tr>
							<td><a class="td-link" href="editTrader?name=<c:out value="${trader.name}" />">View/Edit</a></td>
							<td><c:out value="${trader.name}" /></td>
							<td><c:out value="${trader.code}" /></td>
							<td><c:out value="${trader.uin}" /></td>
							<td><c:out value="${trader.phone}" /></td>
							<td><c:out value="${trader.getAddress().getCity()}" /></td>
							<td><c:out value="${trader.getAddress().getState()}" /></td>
							<td><c:out value="${trader.getAddress().getPostalCode()}" /></td>
						</tr>
					<% } %>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
				<a href="createTrader"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a>
			</td> 
		</tr>
	</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>