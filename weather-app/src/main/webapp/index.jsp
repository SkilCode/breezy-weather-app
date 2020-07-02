<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href=css/bootstrap.css>
<script type="text/javascript">

</script>

	<style>
	body, html {   
	    width: 100%;
	    height: 100%;
	    margin: 1;
	    padding: 1;
	    display:table;
	    background-image: url("${image}");
	}
	 input[type=text] {
 	 background-color: ${fieldColor};
 	 color: ${color};
}
	body {
	    display:table-cell;
	    vertical-align:middle;
	   	
	}
	form {
	    display:table;/* shrinks to fit content */
	    margin:auto;
	}

	</style>
<head>
<meta charset="UTF-8">
<!-- page will automatically refresh after every 5 minutes -->
<meta http-equiv="refresh" content="300">
<title>Search</title>
</head>
<body>
<br>
<form action="/weather" class="text-center border rounded border-${accent} p-5" >
<font style = "font-size : 80px;color: ${color};">Weather</font>	
<input type="text" class="form-control mb-4" name="city" placeholder="City" id="city" required><br><br>
<input type="submit" class="btn btn-outline-${accent} btn-block my-4" value= "Search">

</form>
<form action="/theme" class="text-center" >
<input type = "submit" class="btn btn-outline-${accent} btn-block my-4" value="Change Theme">
</form>

</body>
</html>