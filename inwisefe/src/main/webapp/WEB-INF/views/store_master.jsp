<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<%@ page import="com.prod.inwise.dto.StoreDTO"%>
<%@ page import="java.util.*"%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InWise Verion 1.0 - Store Master</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	List<StoreDTO> dtos = (List<StoreDTO>) request.getAttribute("stores");
// 	pageContext.setAttribute("dtos", stores);
%>
</head>

<body class="wnav">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	
	<nobr>
		<div class="boxheader">
			<span>Stores</span>
		</div>
	</nobr>

	<table width="100%" border="0">
		<tr>
			<td colspan="9" valign="top">
<!-- 				<a href="addStore"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a>  -->
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
		<tr>
			<td>
				<table id="fixed_header_table" cellspacing="0"
					class="datatable striped">
					<thead>
						<tr>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">Store Name</th>
							<th class="column-name">Address</th>
							<th class="column-name">UIN</th>
							<th class="column-name">Phone #</th>
						</tr>
					</thead>
					<tbody>
					<%
					for(StoreDTO dto : dtos) {
						 %>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td><%= dto.getName() %></td>
							<td><%= dto.getAddress() %></td>
							<td><%= dto.getUin() %></td>
							<td><%= dto.getPhone() %></td>
						</tr>
				<% } %>	
					</tbody>
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
				<a href="addStore"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a> 
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
	</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>