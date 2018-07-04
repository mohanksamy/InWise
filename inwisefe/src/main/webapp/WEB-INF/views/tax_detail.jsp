<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.math.BigInteger"%>
<%@ page import="com.prod.inwise.dto.TaxDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Verion 1.0 - Tax Detail</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	TaxDTO tax = (TaxDTO) request.getAttribute(AttributeConstants.TAX);
	BigInteger id = null;
	
	if(tax != null) {
	 	id = tax.getId();
	}

	String mode = (String) request.getAttribute(AttributeConstants.MODE);
	pageContext.setAttribute("dto", tax);
%>
<script type="text/javascript">

function initialize() {
	
  	document.detail_form.cgst.value = "<c:out value ="${dto.getCgst()}" />";
  	document.detail_form.sgst.value = "<c:out value ="${dto.getSgst()}" />";
}

function saveTax() {
	document.detail_form.submit();
    return true;
}
</script>

</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">

	<%@ include file="header.jsf" %>
	<%@ include file="left_side_navbar.jsf"%>

	<form action="saveTax" method="post" name="detail_form" accept-charset="UTF-8">

		<input type="hidden" name="<%= AttributeConstants.TAX_ID %>" value ="<%= id %>" />
		<input type="hidden" name="<%= AttributeConstants.MODE %>" value="<%= mode %>" /> 	 	

		<nobr>
			<div class="boxheader">
				<span>Tax Details</span>
			</div>
		</nobr>
		<%@ include file="response_messages.jsf"%>
		<table cellspacing="2" width="100%" border="0" class="formtable">
			<tr>
				<td colspan="4">&nbsp;
					<p>
						All fields in <b>bold</b> are mandatory.
					</p> 
				</td>
			</tr>
			<tr>
				<td class="mandatory"><label>CGST:</label></td>
				<td><input type="text" id="cgst" name="cgst" maxlength="40" size="25" /></td>

				<td class="optional"><label>SGST:</label></td>
				<td><input type="text" id="sgst" name="sgst" maxlength="40" size="25" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
  					<input type="button" class="button" name="Save" value="Save" onClick="javascript:saveTax();"/>
  					<a href ="taxes"><input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></a>
 				</td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>