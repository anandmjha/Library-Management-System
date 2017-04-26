<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body bgcolor="wheat">
	<center>
		<h1 align="center">View Books</h1>
		<jsp:useBean id="bb" class="com.library.model.Book"
			scope="session" />

		<table border="10" cellpadding="10" cellspacing="10">
			<tr>
				<th>Accession No</th>
				<th>Title</th>
				<th>Author</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${bb.allBooks}" var="book">
				<tr>

					<td>${book.accessionNo}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.status}</td>

				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</c:if>
</html>