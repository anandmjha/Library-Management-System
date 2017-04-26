<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Details</title>
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body bgcolor="wheat">
	<h1 align="center">User Details</h1>
	<jsp:useBean id="mb" class="com.library.model.Member"
		scope="session" />
	<jsp:setProperty property="memberId" name="mb" value="${memberId}" />

	<table border="5" align="center" cellspacing="5" cellpadding="10">
		<tr>
			<th>Member Id</th>
			<td>${member.memberId}</td>
		</tr>
		<tr>
			<th>Name</th>
			<td>${member.name}</td>
		</tr>
		<tr>
			<th>Address</th>
			<td>${member.address}</td>
		</tr>
		<tr>
			<th>Member Type</th>
			<td>${member.type}</td>
		</tr>
	</table>

</body>
</c:if>
</html>