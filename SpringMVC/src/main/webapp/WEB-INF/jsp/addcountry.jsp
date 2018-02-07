<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add</title>
</head>
<body>
<s:url value="/country/save" var="saveURL"></s:url>
<f:form action="${saveURL }" modelAttribute="country" method="POST">
<f:hidden path="countryId"/>
<table border="1" bordercolor="red" width="auto">
<tr><td>CID</td><td><f:input path="countryId" title="countryId" /></td></tr>
<tr><td>Name</td><td><f:input path="name" title="Name" type="text" /></td></tr>
<tr><td>Code</td><td><f:input path="countryCode" title="countryCode" type="text" /></td></tr>
<tr><td colspan="2" align="right"><button onclick="submit" title="Click to save" type="submit" >SAVE</button></td></tr>
</table>
<h1>Country Add Page</h1>
</f:form>
</body>
</html>