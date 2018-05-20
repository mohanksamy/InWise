<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InWise Verion 1.0 - Reports</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />

</head>

<body class="wnav">

<%@ include file="header.jsf" %>
<%@ include file="left_side_navbar.jsf"%>	
	<nobr>
		<div class="boxheader">
			<span>Reports</span>
		</div>
	</nobr>

	<table width="100%" border="0">
		<tr>
			<table cellpadding="2" cellspacing="1" width="100%" border="3" class="formtable tdcols4">
				<tr>
					<td class="generic" nowrap="nowrap"><label>Bank Name:</label>
					</td>
					<td><input class="optional" type="text" id="bankName"
						name="bankName" maxlength="12" size="30" value="Indian Bank" /></td>
					<td class="generic" nowrap="nowrap"><label>Branch Name</label>
					</td>
					<td><input class="optional" type="text" id="branchName"
						name="branchName" maxlength="12" size="30" /></td>
				</tr>
				<tr>
					<td class="optional" nowrap="nowrap"><label>From:</label><br>
						<span class="footnote">(YYYY-MM-DD)</span></td>
					<td><nobr>
							<input class="optional" type="text" id="fromDate" name="fromDate"
								maxlength="12" size="30" />
						</nobr></td>
					<td class="optional" nowrap="nowrap"><label>To:</label><br>
						<span class="footnote">(YYYY-MM-DD)</span></td>
					<td><nobr>
							<input class="optional" type="text" id="toDate" name="toDate"
								maxlength="12" size="30" />
						</nobr></td>
				</tr>
				<tr>
					<td colspan="4"><br> <input type="button" class="button"
						name="Search" value="Search" onClick="#" /> <input type="button"
						class="button" name="Clear" value="Clear" onClick="#" /> <br>&nbsp;<br>
					</td>
				</tr>
				<tr align="right">
					<td class="generic" align='right'>&nbsp;</td>
					<td class="generic" align='right'>&nbsp;</td>
					<td class="generic" align='right'>&nbsp;</td>
					<td align="right" class="generic"><input type="button"
						class="button" name="Generate PDF" value="Generate PDF"
						onClick="#" /></td>
				</tr>
			</table>
		</tr>
		<tr>
			<td>
				<table id="fixed_header_table" cellspacing="0" class="datatable striped">
					<thead>
						<tr>
							<th class="column-name">Bank Name</th>
							<th class="column-name">Branch Name</th>
							<th class="column-name">Address</th>
							<th class="column-name">Phone #</th>
							<th class="column-name">Email</th>
							<th class="column-name">Order Date</th>
							<th class="column-name">No. of CCTV</th>
							<th class="column-name">Finished Date</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>50</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>50</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>50</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>50</td>
							<td>07-07-2018</td>
						</tr>
						<tr>
							<td>Indian Bank</td>
							<td>Sterling Road</td>
							<td>Streling Road, Chennai</td>
							<td>1234567890</td>
							<td>indianbank@gov.in</td>
							<td>05-07-2018</td>
							<td>50</td>
							<td>07-07-2018</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="4" align="left" height="30" valign="bottom">
<!-- 			<input type="button" class="button" name="Add" value="Add" onClick="#" /> -->
		</tr>
	</table>
	</form>
</body>
</html>