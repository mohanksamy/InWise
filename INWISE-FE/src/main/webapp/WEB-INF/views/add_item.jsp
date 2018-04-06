<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit Item</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {

});

function saveItem() {
	alert("save ITem");
}
</script>
</head>
<body>
<div id="pageheader">
		<div id="logo">
  			<!-- <img src="logo.png" width="144" height="59" /> -->
  		</div>
	</div>
	<nobr>
		<div class="boxheader">
			<span>Add New Item</span>
		</div>
	</nobr>
	<form action="" method="post" name="detail_form" accept-charset="UTF-8">
		<table cellspacing="2" width="50%" border="0" class="formtable">
			<tr>
				<td colspan="4">&nbsp;
					<p>
						All fields in <b>bold</b> are mandatory.
					</p> <nfn:sectionTitle name="Name and Address" /> <br>
				</td>
			</tr>

			<tr>
				<td class="mandatory"><label>Item Name:</label></td>
				<td><input type="text" id="itemName" name="itemName" maxlength="40" size="30" /></td>

				<td class="optional"><label>Price:</label></td>
				<td><input type="text" id="price" name="price" maxlength="40" size="30" /></td>
			</tr>
			<tr>
				<td class="optional"><label>Category:</label></td>
				<td><input class="optional" type="text" id="category" name="category" maxlength="50" size="30" /></td>
				
				<td class="optional"><label>Sub Category:</label></td>
				<td><input class="optional" type="text" id="subCategory" name="subCategory" maxlength="50" size="30" /> </td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td colspan="4" align="left" height="30" valign="bottom">
					<input type="button" class="button" name="Save" value="Save" onClick="saveItem()" />
 					<input type="button" class="button" name="Cancel" value="Cancel" onClick="" />
 				</td>
			</tr>
		</table>
	</form>
</body>
</html>