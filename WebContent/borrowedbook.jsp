<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrowed Book</title>
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<center>
			<h1 align="center">Borrowed Books</h1>
			<jsp:useBean id="tb" class="com.library.model.Transaction"
				scope="session" />
			<jsp:setProperty property="memberId" name="tb" value="${memberId}" />



			<table border="10" cellpadding="10" cellspacing="10">
				<tr>
					<th>Accession No</th>
					<th>Title</th>
					<th>Author</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${tb.retrieveBorrowedBooks}" var="transaction">
					<tr>
						<td>${transaction.accessionNo}</td>
						<td>${transaction.title}</td>
						<td>${transaction.author}</td>
						<td>${transaction.status}</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</c:if>
</html>