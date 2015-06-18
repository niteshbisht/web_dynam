<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DataEntryForm</title>
<link href="./resources/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="top-banner">
		<img id="logo" src="./resources/images/logo.png" />
	</div>
	<div class="details">
		<form action="./submit" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="Name" /></td>
				</tr>

				<tr>
					<td>Location</td>
					<td><input type="text" name="Location" /></td>
				</tr>

				<tr>
					<td>Address</td>
					<td><input type="text" name="Address" /></td>
				</tr>

				<tr>
					<td>Pin</td>
					<td><input type="text" name="Pin" /></td>
				</tr>

				<tr>
					<td>Services</td>
					<td><textarea name="Services" COLS=40 ROWS=6></textarea></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" title="submit" value="submit" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
