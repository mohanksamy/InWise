<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="java.math.BigInteger"%>
<%@ page import="com.prod.inwise.dto.TraderDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Verion 1.0 - Traders Detail</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	TraderDTO trader = (TraderDTO) request.getAttribute(AttributeConstants.TRADER);
	BigInteger id = null;
	
	if(trader != null) {
	 	id = trader.getId();
	}

	String mode = (String) request.getAttribute(AttributeConstants.MODE);
	pageContext.setAttribute("dto", trader);
%>
<script type="text/javascript">

function initialize() {
	
  	document.detail_form.name.value = "<c:out value ="${dto.getName()}" />";
  	document.detail_form.code.value = "<c:out value ="${dto.getCode()}" />";
  	document.detail_form.uin.value = "<c:out value ="${dto.getUin()}" />";
  	document.detail_form.phone.value = "<c:out value ="${dto.getPhone()}" />";
 	document.detail_form.street1.value = "<c:out value ="${dto.getAddress().getStreet1()}" />";
  	document.detail_form.street2.value = "<c:out value ="${dto.getAddress().getStreet2()}" />";
  	document.detail_form.city.value = "<c:out value ="${dto.getAddress().getCity()}" />";
  	document.detail_form.region.value = "<c:out value ="${dto.getAddress().getRegion()}" />";
  	document.detail_form.state.value = "<c:out value ="${dto.getAddress().getState()}" />";
  	document.detail_form.country.value = "<c:out value ="${dto.getAddress().getCountry()}" />";
  	document.detail_form.postalCode.value = "<c:out value ="${dto.getAddress().getPostalCode()}" />";
  	
}

function saveTrader() {
	document.detail_form.submit();
    return true;
}
</script>
</head>

<body class="wnav" onload="javascript:initMenu();javascript:initialize();">

<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>
<input type="hidden" name="<%= AttributeConstants.TRADER_ID %>" value ="<%= id %>" />
<input type="hidden" name="<%= AttributeConstants.MODE %>" value="<%= mode %>" /> 	 	
	<nobr>
		<div class="boxheader">
			<span>Trader Detail</span>
		</div>
	</nobr>
	<%@ include file="response_messages.jsf"%>
	<form action="saveTrader" method="post" name="detail_form" accept-charset="UTF-8">
		<table cellspacing="2" width="100%" border="0" class="formtable">
 			<tr>
<!--  				<td colspan="4" align="left" height="30" valign="top"> -->
<!--   					<a href ="saveStore"><input type="button" class="button" name="Save" value="Save" /></a> -->
<!--   					<a href ="stores"><input type="button" class="button" name="Cancel" value="Cancel" /></a> -->
<!--   				</td> -->
  			</tr>
			<tr>
				<td colspan="4">&nbsp;
					<p>
						All fields in <b>bold</b> are mandatory.
					</p>
				</td>
			</tr>
			<tr>
				<td class="mandatory"><label>Trader Name:</label></td>
				<td><input type="text" id="name" name="name" maxlength="40" size="25" /></td>

				<td class="optional"><label>Code:</label></td>
				<td><input type="text" id="code" name="code" maxlength="40" size="25" /></td>
			</tr>
			<tr>
				<td class="optional"><label>UIN:</label></td>
				<td><input class="optional" type="text" id="uin" name="uin" maxlength="10" size="25" /></td>
				
				<td class="optional"><label>Phone #:</label></td>
				<td><input class="optional" type="text" id="phone" name="phone" maxlength="15" size="25" /> </td>
			</tr>
			<tr>
				<td class="optional"><label>Street1:</label></td>
				<td><input class="optional" type="text" id="street1" name="street1" maxlength="30" size="25" /></td>
				
				<td class="optional"><label>Street2:</label></td>
				<td><input class="optional" type="text" id="street2" name="street2" maxlength="30" size="25" /> </td>
			</tr>
			<tr>
				<td class="optional"><label>City:</label></td>
				<td><input class="optional" type="text" id="city" name="city" maxlength="20" size="25" /></td>
				
				<td class="optional"><label>Region:</label></td>
				<td><input class="optional" type="text" id="region" name="region" maxlength="20" size="25" /> </td>
			</tr>
			<tr>
				<td class="optional"><label>State:</label></td>
				<td><input class="optional" type="text" id="state" name="state" maxlength="20" size="25" /> </td>
			
				<td class="optional"><label>Country:</label></td>
				<td><input class="optional" type="text" id="country" name="country" maxlength="20" size="25" /></td>
			</tr>
			<tr>
				<td class="optional"><label>PostalCode:</label></td>
				<td><input class="optional" type="text" id="postalCode" name="postalCode" maxlength="20" size="25" /> </td>
				
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
 					<input type="button" class="button" name="Save" value="Save" onClick="javascript:saveTrader();"/>
  					<a href ="traders"><input type="button" class="button" name="Cancel" value="Cancel" /></a>
 				</td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>