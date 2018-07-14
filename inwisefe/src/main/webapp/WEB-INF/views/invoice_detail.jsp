<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.util.*"%>
<%@ page import="java.math.BigInteger"%>
<%@ page import="com.prod.inwise.dto.InvoiceDTO"%>
<%@ page import="com.prod.inwise.dto.ItemDTO"%>
<%@ page import="com.prod.inwise.dto.LineItemDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Version 1.0 - Invoice Detail</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	List<LineItemDTO> lineItemDtos = (List<LineItemDTO>) request.getAttribute(AttributeConstants.LINE_ITEM_LIST);
	List<ItemDTO> itemDtos = (List<ItemDTO>) request.getAttribute(AttributeConstants.ITEM_LIST);
	
	LineItemDTO lineItemDto = new LineItemDTO();
	InvoiceDTO invoiceDto = new InvoiceDTO();
	
	if(lineItemDtos != null) {
		lineItemDto = lineItemDtos.get(0);
		invoiceDto = lineItemDto.getInvoice();	
	}
	pageContext.setAttribute("dto", lineItemDto);
	String mode = (String) request.getAttribute(AttributeConstants.MODE);
%>
<script type="text/javascript">

function initialize() {
  	defaultSelect(document.detail_form.itemName.value = "<c:out value ="${dto.getItem().getName()}" />");
  	document.detail_form.quantity.value = "<c:out value ="${dto.getQuantity()}" />";
  	
  	document.detail_form.phone.value = "<c:out value ="${dto.getInvoice().getPhone()}" />";
 	document.detail_form.street1.value = "<c:out value ="${dto.getInvoice().getBuyer().getAddress().getStreet1()}" />";
  	document.detail_form.street2.value = "<c:out value ="${dto.getInvoice().getBuyer().getAddress().getStreet2()}" />";
  	document.detail_form.city.value = "<c:out value ="${dto.getInvoice().getBuyer().getAddress().getCity()}" />";
  	document.detail_form.region.value = "<c:out value ="${dto.getInvoice().getBuyer().getAddress().getRegion()}" />";
  	document.detail_form.state.value = "<c:out value ="${dto.getInvoice().getBuyer().getAddress().getState()}" />";
  	document.detail_form.country.value = "<c:out value ="${dto.getInvoice().getBuyer().getAddress().getCountry()}" />";
  	document.detail_form.postalCode.value = "<c:out value ="${dto.getInvoice().getBuyer().getAddress().getPostalCode()}" />";

  	
}

function saveInvoice() {
	if (isEmpty(document.detail_form.itemName)) {
		alert("Please select the item name");
    	document.detail_form.itemName.select();
    	document.detail_form.itemName.focus();
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

<body class="wnav">

<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	
	<form action="saveInvoice" method="post" name="detail_form" accept-charset="UTF-8">
		<input type="hidden" name="<%= AttributeConstants.MODE %>" value="<%= mode %>" /> 	 	
	
		<nobr>
			<div class="boxheader">	
				<span>Invoice Detail</span>
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
				<td class="subtitle" colspan="4">
					<div class="boxheader"><label>Buyer Information</label></div>
				</td>
    		</tr>
    		<tr>
				<td class="mandatory"><label>Bank Name:</label></td>
				<td><input type="text" id="name" name="name" maxlength="40" size="25" /></td>
				
				<td class="mandatory"><label>Branch:</label></td>
				<td><input type="text" id="name" name="name" maxlength="40" size="25" /></td>
			</tr>
			<tr>
				<td class="mandatory"><label>Street1:</label></td>
				<td><input type="text" id="street1" name="street1" maxlength="30" size="25" /></td>

				<td class="mandatory"><label>Street2:</label></td>
				<td><input type="text" id="street1" name="street1" maxlength="30" size="25" /></td>
			</tr>
			<tr>
				<td class="mandatory"><label>City:</label></td>
				<td><input type="text" id="city" name="city" maxlength="20" size="25" /></td>
			
				<td class="optional"><label>Region:</label></td>
				<td><input type="text" id="region" name="region" maxlength="20" size="25" /> </td>
			</tr>
			<tr>
				<td class="mandatory"><label>State:</label></td>
				<td><input type="text" id="state" name="state" maxlength="20" size="25" /> </td>
			
				<td class="mandatory"><label>Country:</label></td>
				<td><input type="text" id="country" name="country" maxlength="20" size="25" /></td>
			</tr>
			<tr>
				<td class="mandatory"><label>PostalCode:</label></td>
				<td><input type="text" id="postalCode" name="postalCode" maxlength="20" size="25" /> </td>
			
				<td class="mandatory"><label>Phone #:</label></td>
				<td><input type="text" id="phone" name="phone" maxlength="15" size="25" /> </td>
			</tr>
			<tr>
				<td class="subtitle" colspan="4">
					<div class="boxheader"><label>Invoice information</label></div>
				</td>
    		</tr>
			<tr>
				<td class="optional"><label>Item name:</label></td>
          		<td>
					<select id="itemName" name="itemName">
					<%
					for(ItemDTO itemDto : itemDtos) { %>
						<option value="<%=itemDto.getId()%>"><%=itemDto.getName()%></option>
					<%} %>
          			</select>
          		</td>
          		
          		<td class="optional"><label>Quantity:</label></td>
				<td><input class="optional" type="text" id="quantity" name="quantity" maxlength="12" size="25" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
				<% if(AttributeConstants.INSERT.equals(mode)) { %>
 					<input type="button" class="button" name="Save" value="Save" onClick="javascript:saveInvoice();"/>
 				<% } %>
  					<a href ="invoices"><input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></a>
 				</td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>