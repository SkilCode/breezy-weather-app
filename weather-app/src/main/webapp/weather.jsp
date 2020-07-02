<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
var temp = ${temperature};
if(temp == " ")
	alert("city not found please enter a correct name");
	
</script>

<style>
body, html {   
    width: 100%;
    height: 100%;
    display:table;
    background-image: url("background/${icon}.jpg"); 
    font-family: Impact, Charcoal, sans-serif;
}

table{
	background-color: ${tableColor};	
}

 td,table {
  
     border-collapse: collapse;
     margin: 0px;
    padding: 5px;
    
   font-size: 13px;
}
 th{ 
padding:10px;
 }
 caption{
 text-align: left;
 background-color: ${captionColor};
 font-size: 80px;
 }
 .centerimg{
 display: block;
  margin-left: auto;
  margin-right: auto;
  
 }
 .center {
  margin-left: auto;
  margin-right: auto;

}
</style>
 
<head>
<meta charset="UTF-8">
<!-- page will automatically refresh after every 5 minutes -->
<meta http-equiv="refresh" content="300">

<title>Weather App</title>
</head>
<body>
${msg}
<img class="centerimg" src="${iconUrl}">
<font color="${color}">

<table class = "center" style="font-align:left">

<caption>${temperature}</caption>

<tr>
 <td>Temp min-max</td>
 <td>${min} - ${max}</td>
 </tr>
<tr>
 <td>Feels Like</td>
 <td>${feels}</td>
 </tr>
<tr>
<td>Humidity</td>
 <td>${humidity} </td>
 </tr>
 <tr> 
 <td> Wind Speed</td>
 <td>${wind_speed} </td>
 </tr>
 <tr>
 <td>Wind Angle</td>
 <td>${wind_angle} </td>
 </tr>
<tr>
 <td>Location</td>
 <td>${location} </td>
 </tr>
</table>
</font>
</body>
</html>