<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<%@ page import="java.util.*"%>
<%@ page import="com.prod.inwise.dto.ItemDTO"%>
<%@ page import="com.prod.inwise.fe.utilities.AttributeConstants"%>
<%@ page import="com.prod.inwise.fe.utilities.RequestConstants"%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Version 1.0 - Item Master</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

<%
	List<ItemDTO> itemDtos = (List<ItemDTO>) request.getAttribute(AttributeConstants.ITEM_LIST);
//	pageContext.setAttribute("dtos", stores);
%>
</head>

<body class="wnav">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	

	<nobr>
		<div class ="boxheader"><span>Item List</span></div>
	</nobr>

	<table width="100%" border="0">
		<tr>
			<td colspan="9" valign="top">
<!-- 				<input type="button" class="button" name="Add" value="Add" onClick="#" />  -->
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
	<%if(itemDtos.size()>0) {%>
		<tr>
			<td>
				<table id="fixed_header_table" cellspacing="0" width = "100%" class="datatable striped">
					<thead>
						<tr>
							<th class="column-name">&nbsp;</th>
							<!-- <th class="column-name">&nbsp;</th> -->
							<th align="center" class="column-name">Item Name</th>
							<th align="center" class="column-name">Item Code</th>
							<th align="center" class="column-name">Part No</th>
							<th align="center" class="column-name">Price</th>
							<th align="center" class="column-name">Last Modified Date</th>
							
						</tr>
					</thead>
					<tbody>
					<% for(ItemDTO itemDto : itemDtos) { 
				 		pageContext.setAttribute("itemDto", itemDto);
				 	%>
						<tr>
							<td align="left"><a class="td-link" href="editItem?id=<c:out value="${itemDto.id}" />">View/Edit</a></td>
							<td align="left"><c:out value="${itemDto.name}" /></td>
							<td align="left"><c:out value="${itemDto.code}" /></td>
							<td align="left"><c:out value="${itemDto.partNo}" /></td>
							<td align="right"><c:out value="${itemDto.price}" /></td>
							<td align="left"><c:out value="${itemDto.modifiedTS}" /></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</td>
		</tr>
		<% } %>
		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
				<a href ="addItem"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a>
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
	</table>
	</form>
	
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>