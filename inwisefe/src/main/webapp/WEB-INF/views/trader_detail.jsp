<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="com.prod.inwise.dto.TraderDTO"%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Verion 1.0 - Trader Detail</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	TraderDTO trader = (TraderDTO) request.getAttribute("traders");
	pageContext.setAttribute("dto", trader);
%>
<script type="text/javascript">
function initialize() {
  	document.detail_form.name.value = "<c:out value ="${dto.getName()}" />";
  	document.detail_form.address.value = "<c:out value ="${dto.getAddress()}" />";
  	document.detail_form.uin.value = "<c:out value ="${dto.getUin()}" />";
  	document.detail_form.phone.value = "<c:out value ="${dto.getPhone()}" />";
}
</script>
</head>

<body class="wnav" onload="javascript:initialize();">

<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	
	<nobr>
		<div class="boxheader">
			<span>Trader Detail</span>
		</div>
	</nobr>
	<form action="" method="post" name="detail_form" accept-charset="UTF-8">
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
				<td><input type="text" id="name" name="name" maxlength="40" size="30" /></td>

				<td class="optional"><label>Address:</label></td>
				<td><input type="text" id="address" name="address" maxlength="40" size="30" /></td>
			</tr>
			<tr>
				<td class="optional"><label>UIN:</label></td>
				<td><input class="optional" type="text" id="uin" name="uin" maxlength="50" size="30" /></td>
				
				<td class="optional"><label>Phone #:</label></td>
				<td><input class="optional" type="text" id="phone" name="phone" maxlength="50" size="30" /> </td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
 					<a href ="saveStore"><input type="button" class="button" name="Save" value="Save" /></a>
  					<a href ="stores"><input type="button" class="button" name="Cancel" value="Cancel" /></a>
 				</td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>