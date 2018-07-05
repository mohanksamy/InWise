<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InWise Verion 1.0 - Invoice Master</title>

<%@ include file="header_include.jsf" %>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

</head>

<body class="wnav">
<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	
	<nobr>
		<div class="boxheader">
			<span>Invoice List</span>
		</div>
	</nobr>

	<table width="100%" border="0">
		<tr>
			<td>
				<table id="fixed_header_table" cellspacing="0"
					class="datatable striped">
					<thead>
						<tr>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">&nbsp;</th>
							<th class="column-name">Bank Name</th>
							<th class="column-name">Branch Name</th>
							<th class="column-name">Address</th>
							<th class="column-name">Phone #</th>
							<th class="column-name">Email</th>
							<th class="column-name">Order Date</th>
							<th class="column-name">Finished Date</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td><a class="td-link" href="#">view</a></td>
							<td><a class="td-link" href="#">edit</a></td>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>07-07-2018</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
				<a href="createInvoice"><input type="button" class="button" name="Add" value="Add" onClick="#" /></a>
			</td> 
		</tr>
	</table>
	</form>
	</div>
	<%@ include file="footer.jsf" %>
	</div>
</body>
</html>