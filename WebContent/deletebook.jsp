<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library System</title>
<link rel="stylesheet" href="formstyle.css">
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<h1 align="center">Delete Book</h1>
		<form action="BookController" method="post">
			<select name="accessionNo">
				<c:forEach items="${books}" var="book">
					<option value="${book.accessionNo}">${book.accessionNo}</option>
				</c:forEach>
			</select> <input type="submit" name="action" value="DeleteBook"
				style="width: 150px">
		</form>
	</body>
</c:if>
</html>