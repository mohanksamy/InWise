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
	<nobr>
		<div class="boxheader">
			<span>Edit Invoice</span>
		</div>
	</nobr>

	<form action="" method="post" name="detail_form" accept-charset="UTF-8">
		<table cellspacing="2" width="50%" border="0" class="formtable">
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
					<input type="button" class="button" name="Save" value="Save" onClick="#" />
 					<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" />
 				</td>
			</tr>
			<tr>
				<td class="mandatory"><label>Customer:</label></td>
				<td>
					<select id="customer" name="customer"  >
    	        		<option value="Indian Bank">Indian Bank</option>
        	    		<option value="SBI">SBI</option>
          			</select>
          		</td>
				

				<td class="optional"><label>Invoice No:</label></td>
				<td><input type="text" id="invoiceNo" name="invoiceNo" maxlength="40" size="30" /></td>
			</tr>
			
			<tr>
				<td class="mandatory"><label>Region:</label></td>
				<td>
					<select id="region" name="region"  >
    	        		<option value="east">East</option>
    	        		<option value="west">West</option>
    	        		<option value="north">North</option>
    	        		<option value="south">South</option>
          			</select>
          		</td>

				<td class="optional"><label>Invoice Date:</label></td>
				<td><input type="text" id="invoiceDate" name="invoiceDate" maxlength="40" size="30" /></td>
			</tr>
			<tr>
				<td class="optional"><label>Address 1:</label></td>
				<td><input class="optional" type="text" id="address1" name="address1" maxlength="50" size="30" /></td>
				
				<td class="optional"><label>Address 2:</label></td>
				<td><input class="optional" type="text" id="address2" name="address2" maxlength="50" size="30" /> </td>
			</tr>
			<tr>
				<td class="optional"><label>Address 2:</label></td>
				<td><input class="optional" type="text" id="address2" name="address2" maxlength="50" size="30" /> </td>
			</tr>
			<tr>
				<td class="optional"><label>Address 3:</label></td>
				<td><input class="optional" type="text" id="address3" name="address3" maxlength="50" size="30" /></td>
			</tr>
			
			<tr>
				<td class="optional"><label>Supply of:</label></td>
				<td><input type="radio" name="goods" value="goods" checked> Goods
  					<input type="radio" name="services" value="services"> Services
  					<input type="radio" name="others" value="others"> Others
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
</body>
</html>