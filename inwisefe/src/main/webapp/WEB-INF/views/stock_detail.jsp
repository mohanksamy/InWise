<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.util.*"%>
<%@ page import="java.math.BigInteger"%>
<%@ page import="com.prod.inwise.dto.StockDTO"%>
<%@ page import="com.prod.inwise.dto.ItemDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Version 1.0 - Stock Detail</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	StockDTO stock = (StockDTO) request.getAttribute(AttributeConstants.STOCK);
	List<ItemDTO> itemDtos = (List<ItemDTO>) request.getAttribute(AttributeConstants.ITEM_LIST);
	BigInteger id = null;
	
	
	if(stock != null) {
	 	id = stock.getId();
	}

	String mode = (String) request.getAttribute(AttributeConstants.MODE);
	pageContext.setAttribute("dto", stock);
%>
<script type="text/javascript">

function initialize() {
	
	<% if(AttributeConstants.INSERT.equals(mode)) { %>
		 defaultSelect(document.detail_form.itemName.value = "<c:out value ="${dto.getItem().getName()}" />");
	<% } else { %>
			document.detail_form.itemName.value = "<c:out value ="${dto.getItem().getName()}" />";	
	<% } %>
	
  	document.detail_form.quantity.value = "<c:out value ="${dto.getQuantity()}" />";
}

function saveStock() {
	
	if (isEmpty(document.detail_form.itemName)) {
		alert("Please select the item name");
    	document.detail_form.quantity.select();
    	document.detail_form.quantity.focus();
    	return false;
	}
	
	if (isEmpty(document.detail_form.quantity)) {
		alert("Please enter the quantity");
    	document.detail_form.quantity.select();
    	document.detail_form.quantity.focus();
    	return false;
	}	
	document.detail_form.submit();
    return true;
}
</script>

</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">

	<%@ include file="header.jsf" %>
	<%@ include file="left_side_navbar.jsf"%>

	<form action="saveStock" method="post" name="detail_form" accept-charset="UTF-8">

		<input type="hidden" name="<%= AttributeConstants.STOCK_ID %>" value ="<%= id %>" />
		<input type="hidden" name="<%= AttributeConstants.MODE %>" value="<%= mode %>" /> 	 	

		<nobr>
			<div class="boxheader">
				<span>Stock Details</span>
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
				
				<%if(AttributeConstants.INSERT.equals(mode)) { %>
				<td>
					<select id="itemName" name="itemName">
					<%
					for(ItemDTO itemDto : itemDtos) { %>
						<option value="<%=itemDto.getId()%>"><%=itemDto.getName()%></option>
					<%} %>
          			</select>
          		</td>
          		<% } else { %>
          			<td><input type="text" id="itemName" name="itemName" maxlength="40" size="25" readonly="readonly"/></td>
          		<% } %>

				<td class="optional"><label>Quantity:</label></td>
				<td><input type="text" id="quantity" name="quantity" maxlength="40" size="25" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
  					<input type="button" class="button" name="Save" value="Save" onClick="javascript:saveStock();"/>
  					<a href ="stocks"><input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></a>
 				</td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>