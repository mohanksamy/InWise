<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Invoice</title>
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%-- 	<%@ include file="customer_navbar.jsf" %> --%>
	<div id ="pageheader">
	</div>
	<div id ="contentarea">
	<nobr>
		<div class="boxheader">
			<span>Edit Invoice</span>
		</div>
	</nobr>
	<form action="" method="post" name="detail_form" accept-charset="UTF-8">
		<table cellspacing="2" width="50%" border="0" class="formtable">
<!-- 			<tr> -->
<!-- 				<td colspan="4" align="left" height="30" valign="bottom"> -->
<!-- 					<input type="button" class="button" name="Save" value="Save" onClick="#" /> -->
<!--  					<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /> -->
<!--  				</td> -->
<!-- 			</tr> -->
			<tr>
				<td colspan="4">&nbsp;
					<p>
						All fields in <b>bold</b> are mandatory.
					</p> <nfn:sectionTitle name="Name and Address" /> <br>
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
			</tr>

			<tr>
				<td class="mandatory"><label>GST #:</label></td>
				<td><input class="optional" type="text" id="gstNo" name="gstNo" maxlength="12" size="30" /></td>
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
					<label>State:</label>
					<input class="optional" type="text" id="stateTax" name="stateTax" maxlength="12" size="10" />
					&nbsp;
					<label>Central:</label>
					<input class="optional" type="text" id="centralTax" name="centralTax" maxlength="12" size="10" />
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
					<input type="button" class="button" name="Save" value="Save" onClick="#" />
 					<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" />
 				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>