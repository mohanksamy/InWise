<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Verion 1.0 - Category Detail</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

</head>

<body class="wnav">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>
	
	<nobr>
		<div class="boxheader">
			<span>Category Details</span>
		</div>
	</nobr>
	<form action="saveItem" method="post" name="detail_form" accept-charset="UTF-8">
		<table cellspacing="2" width="100%" border="0" class="formtable">
			<tr>
<!--  				<td colspan="4" align="left" valign="top"> -->
<!--  					<a href ="saveItem"><input type="button" class="button" name="Save" value="Save" onClick="#" /></a> -->
<!--   					<a href ="items"><input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></a> -->
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
				<td class="mandatory"><label>Category Name:</label></td>
				<td><input type="text" id="name" name="name" maxlength="40" size="25" /></td>

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
  					<input type="button" class="button" name="Save" value="Save" onClick="#" />
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