<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.util.*"%>
<%@ page import="com.prod.inwise.dto.InvoiceDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>
<%@ page import="com.prod.inwise.fe.utilities.RequestConstants"%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Version 1.0 - Invoice Master</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />


<%
	List<InvoiceDTO> invoiceList = (List<InvoiceDTO>) request.getAttribute(AttributeConstants.INVOICE_LIST);
%>

</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	
	<nobr>
		<div class="boxheader">
			<span>Invoice List</span>
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
							<th class="column-name">Invoice #</th>
							<th class="column-name">Bank Name</th>
							<th class="column-name">Branch Name</th>
							<th class="column-name">Total Price</th>
							<th class="column-name">Total Tax</th>
							<th class="column-name">Invoice Date</th>
						</tr>
					</thead>
					<tbody>
					
					<% for(InvoiceDTO invoiceDto : invoiceList) { 
				 		pageContext.setAttribute("invoiceDto", invoiceDto);
				 	%>
						<tr>
							<td><a class="td-link" href="#"> Print</a></td>
							<td><c:out value="${invoiceDto.id}" /></td>
							<td><c:out value="${invoiceDto.getBuyer().getName()}" /></td>
							<td><c:out value="${invoiceDto.getBuyer().getReference1()}" /></td>
							<td><c:out value="${invoiceDto.getTotalPrice()}" /></td>
							<td><c:out value="${invoiceDto.getTotalTax()}" /></td>
							<fmt:formatDate  value = "${invoiceDto.modifiedTS}"  pattern = "yyyy-MM-dd HH:mm:ss"  var="tempModifiedDate"/> 
							<td align="left"><c:out value="${tempModifiedDate}"/></td>
						</tr>
					<% } %>
					</tbody>
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
				<a href="createInvoice"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a>
			</td> 
		</tr>
	</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>