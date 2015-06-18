<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jscriptTest</title>
<script type="text/javascript" src="./resources/js/delete.js"></script>
<script type="text/javascript">
	function myFun() {
		var a = 1;
		var b = 2;
		var c = 10 - 4 + 3;
		var p = new String('hi');
		//var q = document.getElementById("googlelink");
		/* for(info in q){
			document.write(info + "-" + q[info] + " <br/> ");
		} */
		if (p instanceof String) {
			document.write("yes ");
		} else {
			document.write("No ");
		}
		//document.write(p instanceof Number+ "<br/>");
		document.write("Hello My Value is : " + c + '<br/>');

		try {
			var x = 1 / 0;
		} catch (err) {
			document.write("Divide By Zero Exception <br/>");
		} finally {
			document.write("Divide By Zero Exception Finally Block");
		}
	}
</script>
</head>
<body>
	<h1>Hello Java Script Test</h1>
	<br />
	<a href="www.google.co.in" id="googlelink">google</a>
	<div id="data_div" style="background-color: fuchsia; width: 70px; height: 90px;">hello we are here</div>
	<button onclick="closureArrayDemo()" value="mybutton">mybutton</button>
</body>
</html>