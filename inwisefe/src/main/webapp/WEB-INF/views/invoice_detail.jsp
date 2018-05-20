<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%-- <%@ page import="com.prod.inwise.dto.StoreDTO"%> --%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InWise Verion 1.0 - Invoice Detail</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	//StoreDTO dto = (StoreDTO) request.getAttribute("storeValue");
%>
<script type="text/javascript">

function initData() {
	
}
</script>
</head>

<body class="wnav">

<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	
	<nobr>
		<div class="boxheader">
			<span>Invoice Detail</span>
		</div>
	</nobr>
	<form action="" method="post" name="detail_form" accept-charset="UTF-8">
		<table cellspacing="2" width="100%" border="0" class="formtable">
 			<tr>
 				<td colspan="4" align="left" valign="top">
<!--  					<a href ="saveInvoice"><input type="button" class="button" name="Save" value="Save" onClick="#" /></a> -->
<!--   					<a href ="invoices"><input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></a> -->
  				</td>
  			</tr>
			<tr>
				<td colspan="4">&nbsp;
					<p>
						All fields in <b>bold</b> are mandatory.
					</p>
				</td>
			</tr>
			<tr>
				<td class="mandatory"><label>Bank Name:</label></td>
				<td><input type="text" id="bankName" name="bankName" maxlength="40" size="30" /></td>

				<td class="optional"><label>Invoice Date:</label></td>
				<td><input type="text" id="invoiceDate" name="invoiceDate" maxlength="40" size="30" /></td>
			</tr>
			<tr>
				<td class="optional"><label>Region:</label></td>
				<td><input class="optional" type="text" id="region" name="region" maxlength="50" size="30" /></td>
				
				<td class="optional"><label>Invoice #:</label></td>
				<td><input class="optional" type="text" id="invoiceNo" name="invoiceNo" maxlength="50" size="30" /> </td>
			</tr>
			<tr>
				<td class="optional"><label>Branch:</label></td>
				<td><input class="optional" type="text" id="branch" name="branch" maxlength="40" size="30" /> </td>
				
				<td class="optional"><label>Order Reference:</label></td>
				<td><input class="optional" type="text" id="orderReference" name="orderReference" maxlength="12" size="30" /></td>
			</tr>
			<tr>
				<td class="optional"><label>Address:</label></td>
				<td><input class="optional" type="text" id="address" name="address" maxlength="50" size="30" /></td>
				
				<td class="optional"><label>Price:</label></td>
				<td><input class="optional" type="text" id="price" name="price" maxlength="12" size="30" /></td>
			</tr>
			<tr>
				<td class="mandatory"><label>GST #:</label></td>
				<td><input class="optional" type="text" id="gstNo" name="gstNo" maxlength="12" size="30" /></td>
				
				<td class="optional"><label>Quantity:</label></td>
				<td><input class="optional" type="text" id="quantity" name="quantity" maxlength="12" size="30" /></td>
			</tr>
			<tr>
				<td class="optional"><label>Description:</label></td>
				<td>
					<select id="description" name="description"  >
    	        		<option value="">Select Items</option>
        	    		<option value="burglarAlarm">Burglar Alarm</option>
        	    		<option value="fireAlarm">Fire Alarm</option>
        	    		<option value="cctvSystem">CCTV System</option>
        	    		<option value="bioMetric">Bio Metric</option>
          			</select>
          		</td>
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
 					<a href ="saveInvoice"><input type="button" class="button" name="Save" value="Save" onClick="#" /></a>
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