<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">
<%@ page import="java.util.*"%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Verion 1.0 - Tax Master</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

</head>

<body class="wnav">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	

	<nobr>
		<div class ="boxheader"><span>Tax List</span></div>
	</nobr>

	<table width="100%" border="0">
		<tr>
			<td colspan="9" valign="top">
<!-- 				<input type="button" class="button" name="Add" value="Add" onClick="#" />  -->
<!-- 				<input type="button" class="button" name="Cancel" value="Cancel" onClick="#" /></td> -->
		</tr>
		<tr>
			<td>
				<table id="fixed_header_table" cellspacing="0" width = "100%" class="datatable striped">
					<thead>
						<tr>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">Item Name</th>
							<th class="column-name">Price</th>
							<th class="column-name">Last Modified Date</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>CCTV System</td>
							<td>1000</td>
							<td>05-07-2018</td>
						</tr>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Fire Alarm</td>
							<td>1050</td>
							<td>05-07-2018</td>
						</tr>
												<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Fire Alarm</td>
							<td>1050</td>
							<td>05-07-2018</td>
						</tr>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Fire Alarm</td>
							<td>1050</td>
							<td>05-07-2018</td>
						</tr>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Fire Alarm</td>
							<td>1050</td>
							<td>05-07-2018</td>
						</tr>
						
					</tbody>
				</table>
			</td>
		</tr>

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