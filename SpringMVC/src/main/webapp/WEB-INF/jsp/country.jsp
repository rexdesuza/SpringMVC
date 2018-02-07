<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
</head>
<body>
	<s:url var="addURL" value="/country/add"></s:url>
	<a  href="${addURL}">Add Country</a>
	<table width="100%" border="1">
		<tr>
			<th>CID</th>
			<th>NAME</th>
			<th>CODE</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${list}" var="c">
			<tr>
				<td>${c.countryId }</td>
				<td>${c.name }</td>
				<td>${c.countryCode }</td>

				<td><s:url value="/country/update/${c.countryId }"
						var="updateURL" /><a href="${updateURL}">Update</a></td>
				<td><s:url value="/country/delete/${c.countryId }"
						var="deleteURL" /><a href="${deleteURL}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>