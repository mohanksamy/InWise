<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.math.BigInteger"%>
<%@ page import="com.prod.inwise.dto.ItemDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Version 1.0 - Item Detail</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	ItemDTO itemDto = (ItemDTO) request.getAttribute(AttributeConstants.ITEM_DTO);
	BigInteger id = null;
	
	if(itemDto != null) {
	 	id = itemDto.getId();
	}

	String mode = (String) request.getAttribute(AttributeConstants.MODE);
	pageContext.setAttribute("dto", itemDto);
%>

<script type="text/javascript">

function initialize() {
	
  	document.detail_form.name.value = "<c:out value ="${dto.getName()}" />";
  	document.detail_form.code.value = "<c:out value ="${dto.getCode()}" />";
  	document.detail_form.partNo.value = "<c:out value ="${dto.getPartNo()}" />";
  	document.detail_form.price.value = "<c:out value ="${dto.getPrice()}" />";
}

function saveItem() {
	document.detail_form.submit();
    return true;
}

</script>
</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">

	<%@ include file="header.jsf" %>
	<%@ include file="left_side_navbar.jsf"%>

	<form action="saveItem" method="post" name="detail_form" accept-charset="UTF-8">
	
		<input type="hidden" name="<%= AttributeConstants.ITEM_ID %>" value ="<%= id %>" />
		<input type="hidden" name="<%= AttributeConstants.MODE %>" value="<%= mode %>" />
			
		<nobr>
			<div class="boxheader">
				<span>Item Details</span>
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
				<td class="mandatory"><label>Item Name:</label></td>
				<td><input type="text" id="name" name="name" maxlength="40" size="25" /></td>

				<td class="optional"><label>Part NO:</label></td>
				<td><input type="text" id="partNo" name="partNo" maxlength="40" size="25" /></td>
			</tr>
			<tr>
				<td class="optional"><label>Item Code:</label></td>
				<td><input type="text" id="code" name="code" maxlength="40" size="25" /></td>

				<td class="optional"><label>Price:</label></td>
				<td><input type="text" id="price" name="price" maxlength="40" size="25" /></td>
			</tr>
			
			<tr>
				<td class="optional"><label>Tax:</label></td>
				<td>
					<label>CGST:</label>
					<input class="optional" type="text" id="centralTax" name="centralTax" maxlength="12" size="10" />
					&nbsp;
					<label>SGST:</label>
					<input class="optional" type="text" id="stateTax" name="stateTax" maxlength="12" size="10" />
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
  					<input type="button" class="button" name="Save" value="Save" onClick="javascript:saveItem();"/>
  					<a href ="items"><input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></a>
 				</td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>