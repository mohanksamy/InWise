<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.util.*"%>
<%@ page import="com.prod.inwise.dto.TaxDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>
<%@ page import="com.prod.inwise.fe.utilities.RequestConstants"%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Version 1.0 - Tax Master</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	List<TaxDTO> taxList = (List<TaxDTO>) request.getAttribute(AttributeConstants.TAX_LIST);
%>
</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	

	<nobr>
		<div class ="boxheader"><span>Tax List</span></div>
	</nobr>

	<table width="100%" border="0">
		<tr>
			<td>
				<table id="fixed_header_table" cellspacing="0" width = "100%" class="datatable striped">
					<thead>
						<tr>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">CGST</th>
							<th class="column-name">SGST</th>
							<th class="column-name">Last Modified Date</th>
							
						</tr>
					</thead>
					<tbody>
						<% for(TaxDTO taxDto : taxList) {
							pageContext.setAttribute("tax", taxDto); %>
						<tr>
							<td><a class="td-link" href="editTax?id=<c:out value="${tax.id}" />">View/Edit</a></td>
							<td><c:out value="${tax.cgst}" /></td>
							<td><c:out value="${tax.sgst}" /></td>
					       	<fmt:formatDate  value = "${tax.modifiedTS}"  pattern = "yyyy-MM-dd HH:mm:ss"  var="tempModifiedDate"/> 
         					<td><c:out value="${tempModifiedDate}" /></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
				<a href ="createTax"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a>
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
	</table>
	</form>
	
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>