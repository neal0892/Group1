<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style type="text/css">
body {
  font: normal medium/1.4 sans-serif;
}
table {
  border-collapse: collapse;
  width: 50%;
}
th, td {
  padding: 0.25rem;
  text-align: left;
  border: 1px solid #ccc;
}
tbody tr:nth-child(odd) {
  background: #eee;
}

body { 
	width: 100%;
	height:100%;
	font-family: 'Open Sans', sans-serif;
	background: #092756;
	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
}

.style1
{
color: 'white';
}
</style>
<link rel="stylesheet" href="css/normalize.css">

</head>

</style>
</head>

<body>
<h1><marquee behavior="alternate">Update Product</marquee></h1>
<table border=2 align="center">
<thead>
<tr>
<th>Product ID </th>
	<th>Product Name </th>
	<th>Manufacturer</th>
	<th>Product Price</th>
	<th>Product Description </th>
	<th>Product Image URI</th>
	<th>Sub Category Id</th>
	<th>Update</th>

</tr>
		</thead>
		<tbody>	
		<c:forEach items="${prodList}" var="product">
				<tr>
					<td><c:out value="${product.getProductId()}" /></td>
			    	 <td><c:out value="${product.getProductName()}" /></td>
			    	 <td><c:out value="${product.getManufacturer()}" /></td>
			    	  <td><c:out value="${product.getProductPrice()}" /></td>	
			    	 <td><c:out value="${product.getProductDescription()}" /></td>	
			    	 <td><c:out value="${product.getProductImageURI()}" /></td>
			    	 <td><c:out value="${product.getSubCategoryId()}" /></td>	
			    	 	
			    <td><a href="./updateDetails2?prodid=${product.getProductId()}&subid=${product.getSubCategoryId()}"> Update </a></td>
			    	 </tr>
		</c:forEach>		
		</tbody>
		</table>
			   
</body>
</html>
